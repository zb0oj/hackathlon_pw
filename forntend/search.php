<!DOCTYPE html>
<html lang="en">
	<?php
		error_reporting(0);
	?>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>TYTUL</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <link rel="stylesheet" href="./css/bootstrap.css" media="screen">
      <link rel="stylesheet" href="./css/custom.min.css">
      <link href="magicsuggest/magicsuggest-min.css" rel="stylesheet">
	  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/jqc-1.12.4/dt-1.10.15/fc-3.2.2/fh-3.1.2/r-2.1.1/datatables.min.css"/>
      <!-- Custom CSS -->
      <link href="css/search-page.css" rel="stylesheet">
      <script src="https://use.fontawesome.com/34f4721ea9.js"></script>
	  <script>
		var initialQuery = '<?=($_GET['query'])?$_GET['query']:''?>';
	  </script>
   </head>
   <body class="loading">
      <div id="navbar" class="navbar-collapse collapse">
         <ul class="nav navbar-nav">
            <li class="active"><a href="search.php">Wyszukiwarka</a></li>
            <li><a href="survey.php">Ankieta</a></li>
         </ul>
      </div>
      <a name="about"></a>
      <div class="intro-header">
      <div class="container">
         <div class="row">
            <div class="col-lg-10 clearmargin">
               <div id="magicsuggest"></div>
            </div>
            <div class="col-lg-2">
               <button class="btn btn-success save">Szukaj w bazie</button>
            </div>
         </div>
         <br />
         <div class="well bs-component promotors table-responsive">
			<table id="table" class="table table-striped table-hover table-condensed">
				<thead>
					<tr>
						<th data-field="title" data-sortable="true">Tytuł pracy</th>
						<th data-field="difficulity" data-sortable="true" data-formatter="diffFormatter">Poziom trudności</th>
						<th data-field="author.name" data-sortable="true">Promotor</th>
						<th data-field="author.department" data-sortable="true">Wydział</th>
						<th data-field="author.rates" data-sortable="true" data-formatter="rateFormatter" data-sorter="ratesSorter">Ocena promotora</th>
						<th data-field="author.relatedTags" data-formatter="relatesTagFormatter">Powiązania</th>
						<th data-field="author.mail">EMail</th>
						<th data-field="author.phone">Telefon</th>
					</tr>
				</thead>
			</table> 
         </div>
      </div>
      </div>
      <script src="./js/jquery-1.10.2.min.js"></script>
      <script src="./js/bootstrap.min.js"></script>
      <script src="./js/properties.js"></script>
      <!-- Magicsuggest -->
      <script src="magicsuggest/magicsuggest-min.js"></script>
	  <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">

	<!-- Latest compiled and minified JavaScript -->
	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>

	<!-- Latest compiled and minified Locales -->
	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
	  
      <script type="text/javascript" src="./js/search-page.js"></script>
	  
	  
	<div class="modal"><!-- Place at bottom of page --></div>
 
   </body>
</html>