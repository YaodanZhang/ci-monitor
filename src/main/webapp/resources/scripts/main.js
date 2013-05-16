function playSound( url ){
  document.getElementById("sound").innerHTML="<embed src='"+url+"' hidden=true autostart=true loop=false>";
}

$(document).ready(function(){
myTimer();
setInterval(function(){myTimer()},5000);

function myTimer()
{
$.getJSON('http://localhost:8080/ci-monitor/projects', function(data) {
 $('#root').html('');

  $.each(data, function(i,data) {
         var status = "succeed";
         if(data.success==false)
         {
         status="failed" ;
         if(data.changedToFailed==true)
         {
         playSound("resources/sound/alert.wav");
         }
         }

      $('#root').append('<div class="survey '+status+'">' + data.name + '<div/>');

  });

});


}
});