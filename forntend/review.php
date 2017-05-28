<!DOCTYPE html>
<html lang="en">
	<?php
		error_reporting(0);
	?>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Ocena współpracy</title>
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <link rel="stylesheet" href="./css/bootstrap.css" media="screen">
      <link rel="stylesheet" href="./css/custom.min.css">
      <!-- Custom CSS -->
      <link href="css/review-page.css" rel="stylesheet">
      <script src="https://use.fontawesome.com/34f4721ea9.js"/></script>
	  <script>
		var promotorId = '<?=($_GET['id'])?$_GET['id']:''?>';
	  </script>
   </head>
   <body>
      <div id="navbar" class="navbar-collapse collapse">
         <ul class="nav navbar-nav">
            <li class="active">
               <a href="#search">Wyszukiwarka</a>
            </li>
            <li>
               <a href="#about">Ankieta</a>
            </li>
         </ul>
         <ul class="nav navbar-nav navbar-right">
            <li>
               <a href="#">O projekcie</a>
            </li>
         </ul>
      </div>
      <div class="container">
         <div class="well bs-component table-responsive">
            <div class="main">
               <h2><i class="fa fa-star fa-2" aria-hidden="true">&nbsp;</i>Ocena współpracy z promotorem</h2>
               <div class="thesis-info">
                  <div class="info col-sm-4">Proszę wypełnij ankietę dotyczącą współpracy z promotorem, by ułatwić przyszłym studentom wybór najlepszego promotora</div>
                  <div class="thesis-info-table col-sm-8">
                     <table class="table table-striped thesis-table">
                        <tbody>
                           <tr>
                              <td><span>Temat:</span></td>
                              <td><span class="topic" id="title"></span></td>
                           </tr>
                           <tr>
                              <td><span>Promotor:</span></td>
                              <td><span class="imie" id="name"></span></td>
                           </tr>
                           <tr>
                              <td><span>Wydział:</span></td>
                              <td id="department"></td>
                           </tr>
                           <tr>
                              <td><span>Stopień:</span></td>
                              <td id="stage"></td>
                           </tr>
                        </tbody>
                     </table>
                  </div>
               </div>
               <div class="review">
                  <table class="table table-striped table-hover review-table">
                     <tbody>
                        <tr>
                           <td><i class="fa fa-handshake-o fa-2" aria-hidden="true"></i></td>
                           <td><span>*&nbsp;Charakter współpracy:</span></td>
                           <td>
                              <div class="progbar">
							  <div class="freedom-desc">
									<div class="col-sm-6">Daje dużą wolność</div>
									<div class="col-sm-6">Prowadzi studenta</div>
								</div>
                                 <div class="progress col-sm-2" onmouseover="setFriendly(-3)" onclick="saveFriendly(-3)" onmouseout="friendlySaved=false;">
                                    <div class="progress-bar progress-bar-success hidden" style="width:100%;" id="friendly-3"></div>
								</div>
                                 <div class="progress col-sm-2" onmouseover="setFriendly(-2)" onclick="saveFriendly(-2)" onmouseout="friendlySaved=false;">
                                    <div class="progress-bar progress-bar-success hidden" style="width: 100%" id="friendly-2"></div>
                                 </div>
								 <div class="progress col-sm-2" onmouseover="setFriendly(-1)" onclick="saveFriendly(-1)" onmouseout="friendlySaved=false;">
                                    <div class="progress-bar progress-bar-success hidden" style="width: 100%" id="friendly-1"></div>
                                 </div>
                                 <div class="progress col-sm-2" onmouseover="setFriendly(1)" onclick="saveFriendly(1)" onmouseout="friendlySaved=false;">
                                    <div class="progress-bar progress-bar-success hidden" style="width: 100%" id="friendly1"></div>
                                 </div>
								 <div class="progress col-sm-2" onmouseover="setFriendly(2)" onclick="saveFriendly(2)" onmouseout="friendlySaved=false;">
                                    <div class="progress-bar progress-bar-success hidden" style="width: 100%" id="friendly2"></div>
                                 </div>
								 <div class="progress col-sm-2" onmouseover="setFriendly(3)" onclick="saveFriendly(3)" onmouseout="friendlySaved=false;">
                                    <div class="progress-bar progress-bar-success hidden" style="width: 100%" id="friendly3"></div>
                                 </div>
								<input type="hidden" name="friendly" />
                              </div>
                           </td>
                        </tr>
                        <tr>
                           <td><i class="fa fa-exclamation-triangle fa-2" aria-hidden="true"></i></td>
                           <td><span>*&nbsp;Konstruktywność uwag:</span></td>
                           <td>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                           </td>
                        </tr>
                        <tr>
                           <td><i class="fa fa-comments fa-2" aria-hidden="true"></i></td>
                           <td><span>*&nbsp;Komunikatywność:</span></td>
                           <td>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                           </td>
                        </tr>
                        <tr>
                           <td><i class="fa fa-thumbs-up fa-2" aria-hidden="true"></i></td>
                           <td><span>*&nbsp;Zaangażowanie:</span></td>
                           <td>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                              <i class="fa fa-star-o" aria-hidden="true"></i>
                           </td>
                        </tr>
                     </tbody>
                  </table>
               </div>
			   <div class="summary">
			   <a href="#" class="btn btn-default">Wyślij</a>
			   </div>
            </div>
         </div>
      </div>
      <script src="./js/jquery-1.10.2.min.js"></script>
      <script src="./js/bootstrap.min.js"></script>
      <script src="./js/properties.js"></script>
      <script src="./js/review-page.js"></script>
   </body>
</html>