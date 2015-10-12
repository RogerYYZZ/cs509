
var flightnum="";
var seating= "";




jQuery(document).ready(function($){
	//open popup
	$('.cd-popup-trigger').on('click', function(event){
		event.preventDefault();
		$('.cd-popup').addClass('is-visible');
	});
	
	//close popup
	$('.cd-popup').on('click', function(event){
		if( $(event.target).is('.cd-popup-close') || $(event.target).is('.cd-popup') ||$(event.target).is('.cd-popup-no')) {
			event.preventDefault();
			$(this).removeClass('is-visible');
		}
	});
	//close popup when clicking the esc keyboard button
	$(document).keyup(function(event){
    	if(event.which=='27'){
    		$('.cd-popup').removeClass('is-visible');
	    }
    });
  $('.cd-popup-yes').on('click', function(event){
	   
	
		alert("You have successfully purchased the tickets!");
		   flightnum = docment.getElementById("flightnum").value;
			seating = document.getElementById("seating").value;
			var url3 = "http://localhost:8080/cs509.hobbits/purchase?flightnum="+flightnum+"&&seating="+seating;
			var xhr = new XMLHttpRequest();
			xhr.open("POST", url3, true);
			xhr.send(null);
			$('.cd-popup').removeClass('is-visible');
			
  });
	
});