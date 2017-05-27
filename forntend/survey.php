<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <title>TYTUL</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="./css/bootstrap.css" media="screen">
    <link rel="stylesheet" href="./css/custom.min.css">
    <!-- Custom CSS -->
    <link href="css/survey-page.css" rel="stylesheet">
	<script src="https://use.fontawesome.com/34f4721ea9.js"></script>
  </head>
  <body class="loading">
	<div id="navbar" class="navbar-collapse collapse">
	  <ul class="nav navbar-nav">
		<li><a href="search.php">Wyszukiwarka</a></li>
		<li class="active"><a href="survey.php">Ankieta</a></li>
	  </ul>
	  <ul class="nav navbar-nav navbar-right">
		<li><a href="#">O projekcie</a></li>
	  </ul>
	</div>
	
    <a name="about"></a>
    <div class="intro-header">
        <div class="container hidden">
            <div class="row">
			<div class="col-lg-12">
				<div class="well bs-component">
					<div id="steps"></div>
					<br style="clear:both" />
					<h3>Wypełnij ankietę, a my zrobimy resztę.</h3>
					<form class="form-horizontal" id="questions"></form>
					
					<div class="form-group">
						<div class="col-lg-12">
							<button class="btn btn-default back" onclick="prevStep()">Wstecz</button>
							<button class="btn btn-default next" onclick="nextStep()">Dalej</button>
							<button class="btn btn-success hidden save">Szukaj w bazie</button>
						</div>
					</div>
					<br style="clear:both" />
				</div>
            </div>
        </div>
    </div>
	</div>
	
    <script src="./js/jquery-1.10.2.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/properties.js"></script>
    <script src="./js/survey-page.js"></script>
	
	<!-- Magicsuggest -->
	<link href="magicsuggest/magicsuggest-min.css" rel="stylesheet">
	<script src="magicsuggest/magicsuggest-min.js"></script>
	
	<div class="modal"><!-- Place at bottom of page --></div>

</body>
</html>