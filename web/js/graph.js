
//==========================================================================================
// BUILD PRODUCT GRAPH.
//==========================================================================================
function loadProductGraphValues(values){

    var arr = values.split(",");

    document.getElementById("graph").style.display="block";
    for(var i = 0 ; i < arr.length ; i++){
            var bar = new graphBar(i,arr[i]);
    }
}

//==========================================================================================
// BUILD PRODUCT GRAPH.
//==========================================================================================
function graphBar(id,height){

    var curHeight	= 200;
    var maxHeight 	= curHeight-(height*2);

    // CREATE THE BAR.
    var activeBar	= createElementNode({type:"div", id:"graph_bar_"+id, classname:"graph_bar"});
    // ADD THE BAR TO THE GRAPH
    document.getElementById("graph").appendChild(activeBar);
    // OFFSET IT 20PX FROM THE BAR TO ITS LEFT
    document.getElementById("graph_bar_"+id).setAttribute("style","margin-left: " + (id*20) +"px;");
    // ANIMATE THE BAR.
    var timeid 		= setInterval(function(){var j = growBar();},15);
    var growBar = function(){
        if(curHeight > maxHeight){
            activeBar.style.display = "block";
            curHeight-=5;
            activeBar.style.clip = "rect(" + curHeight + "px, 20px, 200px, 0px)";
        } else {
            clearInterval(timeid);
        }
    };
}
        
function createElementNode(elemt){
    //==========================================================================================
    // Parameters:      elemt
    // Type:            Object
    // Properties:      type        -	A string value containing the type of Element to create.
    //                  id		-	A string value containing the element's 'id' attribute.
    //                  classname   -	A string value containing the element's 'class' attribute.
    //                  txt		-	TextNode value.
    //                  href        -	Hyperlink Reference for an <a> tag.
    //                  src		-	Image Source.
    //                  alt		-	Image Alternative.
    //                  tgt		-	Target
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

    return element;  
}

