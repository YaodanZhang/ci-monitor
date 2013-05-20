<html>
<head>
<title>CI-Monitor</title>
<link href="resources/styles/main.css" rel="stylesheet" type="text/css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
<script src="resources/scripts/main.js"></script>
<script src="resources/scripts/cookie.js"></script>
</head>

<body>
<div><a href="config">Choose projects to display</a><a style="padding-left:20px;padding-right:20px;" href="music">Choose failure music</a>
<input type="checkbox" name="musictoggle" value="playmusic" id="musicoff">Do not play music
</div>
<div id="root"></div>
<div id="sound">
<audio id="alert" src="resources/sound/alert.wav"></audio>
<audio id="ifeelgood" src="resources/sound/ifeelgood.wav"></audio>
<audio id="tiggers" src="resources/sound/tiggers.wav"></audio>
<audio id="hellobaby" src="resources/sound/hellobaby.wav"></audio>
<audio id="drink" src="resources/sound/drink.wav"></audio>
<audio id="nanana" src="resources/sound/nanana.wav"></audio>
<audio id="nono" src="resources/sound/nono.wav"></audio>
<audio id="train" src="resources/sound/train.wav"></audio>
<audio id="thunder" src="resources/sound/thunder.wav"></audio>
<audio id="b9" src="resources/sound/b9.wav"></audio>
<audio id="march" src="resources/sound/march.wav"></audio>
</div>
<div id="count" hidden="true"></div>

</body>

</html>
