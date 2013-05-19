$(document).ready(function(){

 $("#savemusic").click(function () {

var music= $("input[type='radio'][name='failuemusic']:checked");

if(music.length>0)
{
setCookie('music',music.val(),2000);
}
   window.location = '/davenkin-ci-monitor';
 });

});