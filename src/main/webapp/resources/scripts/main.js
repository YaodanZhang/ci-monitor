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

if($('#'+ data.name).length==0)
{
          $('#count').append('<div id='+data.name+'>' + data.notificationCount + '</div>');
}

            var status = "succeed";
             if(data.success==false)
             {
                status="failed" ;
                  if(data.notificationCount > parseInt($('#'+ data.name).text()))
                  {
                           $('#'+ data.name).text(data.notificationCount);
                    playSound("resources/sound/alert.wav");

                  }
             }
      $('#root').append('<div class="survey '+status+'">' + data.name + '</div>');

  });

});


}
});