function playSound(){
  $('#playsound').trigger("play");
}

$(document).ready(function(){
myTimer();
setInterval(function(){myTimer()},5000);

function myTimer()
{
$.getJSON('/ci-monitor/projects', function(data) {
 $('#root').html('');

  $.each(data, function(i,data) {

  if(getCookie(data.name)=="false")
  {
  return;
  }

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
                    playSound();

                  }
             }
      $('#root').append('<div class="survey '+status+'">' + data.name + '</div>');

  });

});


}
});