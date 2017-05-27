<!DOCTYPE html>
<html lang="en">
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Promotor - {name}</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <link rel="stylesheet" href="./css/bootstrap.css" media="screen">
      <link rel="stylesheet" href="./css/custom.min.css">
      <link rel="stylesheet" href="./css/jqcloud.css">
      <!-- Custom CSS -->
      <link href="css/profile-page.css" rel="stylesheet">
      <script src="https://use.fontawesome.com/34f4721ea9.js"/></script>
	  <script>
		var promotorId = '<?=($_GET['id'])?$_GET['id']:''?>';
	  </script>
   </head>
   <body class="loading">
      <div id="navbar" class="navbar-collapse collapse">
         <ul class="nav navbar-nav">
            <li class="active">
               <a href="search.php">Wyszukiwarka</a>
            </li>
            <li>
               <a href="survey.php">Ankieta</a>
            </li>
         </ul>
      </div>
				
      <div class="container hidden">
         <div class="well bs-component promotors table-responsive">
      <div class="main">
         <div class="top-section row">
            <div id="profile" class="col-sm-3"></div>
            <div id="contact-info" class="col-sm-3">
				<table class="table table-striped contact-table">
                     <tbody>
                        <tr>
                           <td>Imię i nazwisko:</td>
                           <td><span class="imie" id="name">prof. nzw. dr hab. Marian Jajecznica</span></td>
                        </tr>
                        <tr>
                           <td>Wydział:</td>
                           <td id="department">WEiTI, MEL</td>
                        </tr>
						<tr>
                           <td>e-mail:</td>
                           <td><a href="mailto:mjajecznica@eiti.pw.edu.pl" id="mail">mjajecznica@eiti.pw.edu.pl</a></td>
                        </tr>
						<tr>
                           <td>pokój:</td>
                           <td id="roomInfo">WEiTI: 503, MEL:317</td>
                        </tr>
                     </tbody>
                  </table>
			</div>
			<div class="col-sm-3">
				<svg width="235" height="200" font-family="sans-serif" font-size="10" text-anchor="middle"></svg>
			</div>
         </div>
		 <div class="chars row">
			<div class="col-sm-3 freedom">
				<div class="char-title">Charakter współpracy</div>
				<div class="freedom-desc">
					<div class="col-sm-6">Daje dużą wolność</div>
					<div class="col-sm-6">Prowadzi studenta</div>
				</div>
				<div class="progbar">
					<div class="progress col-sm-6">
						<div class="progress-bar progress-bar-success " style="width: 40%" id="friendlyMinus"></div>
					</div>
					<div class="progress col-sm-6">
						<div class="progress-bar progress-bar-success" style="width: 40%" id="friendlyPlus"></div>
					</div>
				</div>
			</div>
			<div id="rates"></div>

		 </div>
         <div class="thesis-list">
            <ul class="nav nav-tabs">
               <li class="active">
                  <a href="#open" data-toggle="tab" aria-expanded="true">Tematy do podjęcia</a>
               </li>
               <li class="">
                  <a href="#defenced" data-toggle="tab" aria-expanded="false">Prace obronione</a>
               </li>
            </ul>
            <div id="myTabContent" class="tab-content">
               <div class="tab-pane fade active in" id="open">
                  <table class="table table-striped table-hover">
                     <thead>
                        <tr>
                           <th>LP</th>
                           <th>Temat</th>
                           <th>Tagi</th>
                        </tr>
                     </thead>
                     <tbody>
                        <tr>
                           <td>1</td>
                           <td>Pierwsza praca</td>
                           <td>
							 <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a>
						   </td>
                        </tr>
                        <tr>
                           <td>2</td>
                           <td>Druga praca</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
                        <tr>
                           <td>3</td>
                           <td>Trzecia praca</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
                        <tr>
                           <td>4</td>
                           <td>Czwarta praca</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
                        <tr>
                           <td>5</td>
                           <td>Piąta praca</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
						<tr>
                           <td>6</td>
                           <td>Szósta praca</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
						<tr>
                           <td>7</td>
                           <td>Siódma praca</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
                     </tbody>
                  </table>
               </div>
               <div class="tab-pane fade" id="defenced">
                  <table class="table table-striped table-hover ">
                     <thead>
                        <tr>
                           <th>LP</th>
                           <th>Temat</th>
                           <th>Tagi</th>
                        </tr>
                     </thead>
                     <tbody>
                        <tr>
                           <td>1</td>
                           <td>Pierwsza praca obroniona</td>
                           <td>
							 <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a>
						   </td>
                        </tr>
                        <tr>
                           <td>2</td>
                           <td>Druga praca obroniona</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
                        <tr>
                           <td>3</td>
                           <td>Trzecia praca obroniona</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
                        <tr>
                           <td>4</td>
                           <td>Czwarta praca obroniona</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
                        <tr>
                           <td>5</td>
                           <td>Piąta praca obroniona</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
						<tr>
                           <td>6</td>
                           <td>Szósta praca obroniona</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
						<tr>
                           <td>7</td>
                           <td>Siódma praca obroniona</td>
                           <td> <a class="btn btn-default btn-xs">JAVA</a>
						   <a class="btn btn-default btn-xs">jQuery</a>
						   <a class="btn btn-default btn-xs">HTML</a>
						   <a class="btn btn-default btn-xs">CSS</a></td>
                        </tr>
                     </tbody>
                  </table>
               </div>
            </div>
         </div>
         </div>
         </div>
      </div>
      <script src="./js/jquery-1.10.2.min.js"></script>
      <script src="./js/bootstrap.min.js"></script>
      <script src="./js/properties.js"></script>
      <script src="https://d3js.org/d3.v4.min.js"></script>
      <script src="./js/profile-page.js"></script>
	  
	  
	<div class="modal"><!-- Place at bottom of page --></div>
   </body>
</html>