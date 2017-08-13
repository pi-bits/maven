$(document).ready(function(){
    $(".cars").css("background-color","yellow");

    
 $(".cars").on('change',function(){
 	console.log(this.value);
 });

});