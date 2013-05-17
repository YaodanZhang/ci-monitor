
$(document).ready(function(){

 $("#button").click(function () {
        $("#root :input").each(function(){
        setCookie($(this).attr('name'), $(this).attr('checked'),3000);
        });

        window.location = '/ci-monitor';
    });


$.getJSON('/ci-monitor/projects', function(data) {
 $('#root').html('');

  $.each(data, function(i,data) {

  var isShow="";
  if(getCookie(data.name)=="true")
  {
  isShow="checked"
  }

      $('#root').append('<input type="checkbox" name="'+data.name+'" value="'+data.name+'" '+isShow+'>'+data.name+'<br>');

  });

});

});