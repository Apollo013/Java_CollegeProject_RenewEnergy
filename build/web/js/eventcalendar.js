$(document).ready(function() {
    createEventCalendar();	
});	


//==========================================================================
// CREATES AND RETURNS A DOM ELEMENT.
//==========================================================================
function createElementNode(elemt){
    //==========================================================================================
    // Parameters:	elemt
    // Type:		Object
    // Properties:	type 		-	A string value containing the type of Element to create.
    //				id			-	A string value containing the element's 'id' attribute.
    //				classname	-	A string value containing the element's 'class' attribute.
    //				txt			-	TextNode value.
    //				href		-	Hyperlink Reference for an <a> tag.
    //				src			-	Image Source.
    //				alt			-	Image Alternative.
    //				tgt			-	Target
    //==========================================================================================
    // 'type' PROPERTY MUST BE SPECIFIED.
    if ((elemt.type === "") || (elemt.type === undefined) ){
        alert("You must specify the Type of element to create.");
        return null;
    }

    //===============================================
    // CREATE THE OBJECT.
    //===============================================
    var element 		= 	document.createElement(elemt.type);		
    element.id 			= (elemt.id !== undefined) 			? elemt.id : "";
    element.className 	= (elemt.classname !== undefined) 	? elemt.classname : "";

    //===============================================
    // <a> TAGS.
    //===============================================
    if ( elemt.type === "a" ){ 
        element.href 	= elemt.href;			
        element.target 	= (elemt.tgt !== undefined) ? elemt.tgt : "_top";
    }

    //===============================================
    // TEXT.
    //===============================================
    if (elemt.txt	!== undefined){
        element.appendChild(document.createTextNode(elemt.txt));
    }

    //===============================================
    // <img> TAGS.
    //===============================================
    if ( elemt.type === "img" ){ 
        element.src = elemt.src;
        element.alt = elemt.alt;
    }

    return element;
}

//==========================================================================
// CREATES THE EVENT CALENDAR
//==========================================================================
function createEventCalendar(){

    var calWrapper		=	"calendar_wrapper";

    var today			=	new Date();		
    var selectedMonth	=	null;
    var selectedYear	=	null;

    // Element nodes.
    var calendarTable 	= 	null;
    var monthDisplay	=	null;
    var yearDisplay		=	null;

    //==============================================================================================================================
    // START POINT - CREATES THE ENTIRE CALENDAR.
    //==============================================================================================================================
    function createCalendar(){		
        document.getElementById(calWrapper).appendChild(createNavigationHeader());
        document.getElementById(calWrapper).appendChild(createCalendarTable());
        moveCurrent();
    }

    //==============================================================================================================================
    // CREATES A 'div' ELEMENT WITH SOME CHILD NODES FOR DISPLAYING THE MONTH, YEAR AND NAVIGATION BUTTONS.
    //==============================================================================================================================
    function createNavigationHeader(){
        //=====================================================================================================
        // CREATE A CONTAINER.
        //=====================================================================================================
        var div = createElementNode({type:"div", id:"calendar_header_wrapper"});

        //=====================================================================================================
        // CREATE LEFT & RIGHT BUTTONS.
        //=====================================================================================================
        var leftButton      = createElementNode({type:"div", id:"scrollLeft", classname:"prev browse left"});
        leftButton.onclick  = movePrevious;

        var rightButton     = createElementNode({type:"div", id:"scrollRight", classname:"next browse right"});
        rightButton.onclick = moveNext;

        //=====================================================================================================
        // CREATE MONTH & YEAR NODES.
        //=====================================================================================================
        monthDisplay = createElementNode({type:"div", id:"monthDisplay", classname:"header_item"});
        yearDisplay  = createElementNode({type:"div", id:"yearDisplay", classname:"header_item"});

        div.appendChild(leftButton);
        div.appendChild(monthDisplay);
        div.appendChild(yearDisplay);			
        div.appendChild(rightButton);	

        return div;
    }
	
    //==============================================================================================================================
    // CREATES THE ACTUAL CALENDAR TABLE.
    //==============================================================================================================================
    function createCalendarTable(){
        calendarTable	=   createElementNode({type:"table", id:"calendar_table"});
        for (var rowNo = 0 ; rowNo < 7 ; rowNo++){			
            calendarTable.appendChild(createTableRow(rowNo));
        }		
        return calendarTable;			
    }

    //==============================================================================================================================
    // CREATES THE ROWS FOR OUR CALENDAR TABLE.
    //==============================================================================================================================
    function createTableRow(rowNo){	
        var tr 	= createElementNode({type:"tr", id:"calendar_week_" + rowNo, classname:"calendar_week"});						
        if (rowNo === 0){ 
            createWeekDayHeader(tr); 
        } else {
            createWeekDay(tr,rowNo);
        }
        return tr;			
    }

    //==============================================================================================================================
    // CREATES THE DAY TITLES FOR OUR CALENDAR TABLE.
    //==============================================================================================================================
    function createWeekDayHeader(tr){
        var dayNames = new Array("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun");			
        for(var dayNo = 0 ; dayNo < dayNames.length ; dayNo++){		
            var td = createElementNode({type:"td", 	id:"week_day_header_" + dayNo, 	classname:"calendar_week_day_header"});					
            var span = createElementNode({type:"span", 	id:"week_day_title_" + dayNo, 	classname:"calendar_week_day_title",	txt:dayNames[dayNo]});

            td.appendChild(span);
            tr.appendChild(td);
        }
    }
	
    //==============================================================================================================================
    // CREATES THE EACH DAY FOR OUR CALENDAR TABLE.
    //==============================================================================================================================
    function createWeekDay(tr,rowNo){
        for(var dayNo = 1 ; dayNo < 8 ; dayNo++){		
            var cellClass = (dayNo !== 6 && dayNo !== 7) ? "calendar_day" : "calendar_day calendar_weekend" ;

            var td 	= createElementNode({type:"td", 	id:"week_" + rowNo + "_day_" + dayNo,   classname:cellClass});	
            var span 	= createElementNode({type:"span",	id:"week_" + rowNo + "_day_" + dayNo + "_title"});					
            var div 	= createElementNode({type:"div",	id:"week_" + rowNo + "_day_" + dayNo + "_event"});

            td.appendChild(span);
            td.appendChild(div);
            tr.appendChild(td);
        }
    }

    //==============================================================================================================================
    // DISPLAY MONTH & YEAR IN THE HEADER.
    //==============================================================================================================================
    function displayMonthandYear(){
        var monthNames	=  new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");	
        document.getElementById("monthDisplay").innerHTML = monthNames[selectedMonth];
        document.getElementById("yearDisplay").innerHTML = selectedYear;
        displayDates();
    }
	
    //==============================================================================================================================
    // DISPLAY THE DAY NUMBER IN EACH CELL.
    //==============================================================================================================================	
    function displayDates(){
        var firstDate = new Date(selectedYear , selectedMonth , 1);			// GET THE FIRST DATE OF THE MONTH.			
        var weekDay = firstDate.getDay();										// WHAT DAY OF THE WEEK IS THIS ?				
        var dateIndex = (weekDay === 0) ? -5 : (weekDay - 2)*-1; 			// GET INDEX VALUE FOR 'setDate()' METHOD.

        for (var weekNo = 1 ; weekNo <= 6 ; weekNo++){					// ITERATE THROUGH EACH WEEK.

            for (var dayNo = 1 ; dayNo <= 7 ; dayNo++){					// ITERATE THROUGH EACH DAY OF THE WEEK.

                firstDate = new Date(selectedYear , selectedMonth , 1);			// GET THE FIRST DATE OF THE MONTH AGAIN.				
                firstDate.setDate(dateIndex);						// CHANGE THE DATE TO CORRESPOND WITH THE CURRENT CELL.

                //==================================================================================================
                // GRAB THE CHILD NODES FROM EACH CELL TO CHANGE DATE DISPLAY, CLASSES AND ID's.
                //==================================================================================================				
                var cell = document.getElementById("week_" + weekNo + "_day_" + dayNo);				
                var children = cell.childNodes;
                var classname = (firstDate.getMonth() !== selectedMonth) ? "out_of_range" : "in_range";

                children[0].innerHTML = firstDate.getDate();
                children[0].className = classname;
                children[1].id = firstDate.getFullYear() + "" + firstDate.getMonth() + "" + firstDate.getDate();
                children[1].className = "";
                children[1].innerHTML = "";

                dateIndex++;
            }
        }

        displayEvents();
        filterLastRow(weekDay);
    }

    //==============================================================================================================================
    // DISPLAY THE EVENTS (IF ANY) FOR EACH DATE.
    //==============================================================================================================================	
    function displayEvents(){		
        $.ajax({
            url: "../../repository/events.json",
            beforeSend: function(xhr){
                    if (xhr.overrideMimeType){
                            xhr.overrideMimeType("application/json");
                    }
            },
            dataType: 'json',
            success: function(data){

                for(event in data.events){

                    if((data.events[event].year == selectedYear) && ((data.events[event].month - 1) == selectedMonth)){

                        var div = document.getElementById(selectedYear +""+ selectedMonth +""+ data.events[event].date);
                        div.className = "has_events";

                        for(dayevent in data.events[event].dayevents){	
                                var a = createElementNode({type:"a", classname:"day_event", href:data.events[event].dayevents[dayevent].href, tgt:"_blank", txt:data.events[event].dayevents[dayevent].title});
                                div.appendChild(a);
                        }
                    }
                }
            }
        });				
    }
	
    //==============================================================================================================================
    // DETERMINES WHETHER TO HIDE THE LAST ROW OR NOT.
    //==============================================================================================================================			
    function filterLastRow(weekDay){
        if(weekDay === 0){
            if(daysInMonth() > 29){
                document.getElementById('calendar_week_6').style.display = "table-row";
            } else {
                document.getElementById('calendar_week_6').style.display = "none";
            }
        } 
        else if (weekDay === 6){
            if(daysInMonth() > 30){
                document.getElementById('calendar_week_6').style.display = "table-row";
            } else {
                document.getElementById('calendar_week_6').style.display = "none";
            }		
        }
        else {
            document.getElementById('calendar_week_6').style.display = "none";
        }	
    }
    
    //==============================================================================================================================
    // MOVE TO PREVIOUS MONTH AND/OR YEAR.
    //==============================================================================================================================			
    function movePrevious(){
        selectedMonth 	= 	(selectedMonth === 0) 	? 11 			: selectedMonth - 1;
        selectedYear	=	(selectedMonth === 11) 	? selectedYear - 1 	: selectedYear;		
        displayMonthandYear();
    }

    //==============================================================================================================================
    // MOVE TO NEXT MONTH AND/OR YEAR.
    //==============================================================================================================================			
    function moveNext(){
        selectedMonth 	= 	(selectedMonth === 11) 	? 0 			: selectedMonth + 1;
        selectedYear	=	(selectedMonth === 0) 	? selectedYear + 1 	: selectedYear;
        displayMonthandYear();
    }

    //==============================================================================================================================
    // MOVE TO CURRENT MONTH AND YEAR.
    //==============================================================================================================================			
    function moveCurrent(){
        selectedMonth	=	today.getMonth();
        selectedYear	=	today.getFullYear();
        displayMonthandYear();			
    }
	
    //==============================================================================================================================
    // DETERMINES THE NUMBER OF DAYS IN CURRENT MONTH.
    //==============================================================================================================================			
    function daysInMonth(){
        var dayCount = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
        dayCount[1] = (isLeapYear(selectedYear)) ? 29 : dayCount[1];
        return dayCount[selectedMonth];
    }

    //==============================================================================================================================
    // DETERMINES IF THE CURRENT YEAR IS A LEAP YEAR OR NOT.
    //==============================================================================================================================			
    function isLeapYear(){
        if (selectedYear % 4 === 0)
        {
            if ((selectedYear % 100 !== 0) || (selectedYear % 400 === 0))
            {
                return true;
            }
        }		
        return false;
    }

    createCalendar();
}

