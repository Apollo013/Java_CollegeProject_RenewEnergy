 
(function($){

	$.fn.mySlider = function(){

		var element 		= 	this;
		var currentDiv		=	null; 
		var mOver 			= 	false;
		var items			= 	element.children('li');
		var currentItem 	= 	items.length;
		var started			= 	false;
		
		//=====================================================================================================
		// GRAB EACH 'li' ELEMENT AND ASSIGN 'mouseover' AND 'mouseout' EVENT HANDLERS.
		//=====================================================================================================
		items.each(function(i){
			$(items[i]).mouseover(function(){
				mOver = true;
			});
			
			$(items[i]).mouseout(function(){
				mOver = false;
			});
		});
		
		//=====================================================================================================
		// FADE 'li' ELEMENT IN.
		//=====================================================================================================
		var fadeItemIn = function(){
		
			if(items.length === 0){
				$(element).empty().append("please add some photos !!!");
				return;
			}
			
			fetchNextSlide();
			$(items[currentItem]).fadeIn(1100);
			setTimeout(function(){slideItemIn();},1000);
		};
		
		//=====================================================================================================
		// SLIDE 'div' ELEMENT INTO VIEW.
		//=====================================================================================================
		var slideItemIn = function(){
			$(currentDiv).delay(500).animate({marginTop: "-65px", height: "62px"},500, "linear");
			setTimeout(function(){slideItemOut();},5000);
		};

		//=====================================================================================================
		// SLIDE 'div' ELEMENT OUT OF VIEW.
		//=====================================================================================================
		var slideItemOut = function(){
			if (mOver === true){
				setTimeout(function(){slideItemOut();},100);
			}else{
				$(currentDiv).delay(500).animate({marginTop: "0px", height: "0px"},500, "linear");
				setTimeout(function(){fadeItemOut();},1500);
			}			
		};

		//=====================================================================================================
		// FADE 'li' ELEMENT OUT.
		//=====================================================================================================
		var fadeItemOut = function(){			
			$(items[currentItem]).fadeOut(1100);
			setTimeout(function(){fadeItemIn();},1100);
		};
		
		//=====================================================================================================
		// GET NEXT 'li' AND 'div' ELEMENTS.
		//=====================================================================================================
		var fetchNextSlide = function(){
			currentItem++;
			currentItem = (currentItem >= items.length) ? 0 : currentItem ;
			currentDiv = $(items[currentItem]).children('div');
		};
		
		// START ANIMATION
		fadeItemIn(); 
	};

})(jQuery);


(function($){

	$.fn.myNewsSlider = function(){
	
		var element 		= 	this;
		var items			= 	element.children('li');
		var elementID		=	$(this).attr('id');	
		var firstItem		=	'#' + elementID + ' li:eq(0)';
		var currentIdx 		= 	items.length;
		var listItemObject	=	null;
		
		//=====================================================================================================
		// INITIATE ANIMATION.
		//=====================================================================================================
		var startSlideShow = function(){
			if (items.length === 0){ 
				$(element).empty().append("Please add some list items.");
				return ;
			}
			slideItemUp();		
		};
		
		//=====================================================================================================
		// SLIDE TOP/FIRST 'li' ELEMENT UP.
		//=====================================================================================================
		var slideItemUp = function(){	
			currentIdx++;
			currentIdx = (currentIdx >= items.length) ? 0 : currentIdx ;
			listItemObject = '<li>' + items[currentIdx].innerHTML + '</li>';			

			$(firstItem).delay(3000).slideUp(1000);
			setTimeout(function(){moveItem();},4000);
		};
		
		//=====================================================================================================
		// MOVE TOP/FIRST 'li' ELEMENT TO BOTTOM OF LIST.
		//=====================================================================================================
		var moveItem = function(){
			$(firstItem).remove();
			$(element).append(listItemObject);
			setTimeout(function(){slideItemUp();},1000);			
		};
		
		// START ANIMATION		
		startSlideShow();
	};

})(jQuery);

   
$(document).ready(function() {
    $('#slider_Content').mySlider({});
    $('#news_list').myNewsSlider({});		
});     
       