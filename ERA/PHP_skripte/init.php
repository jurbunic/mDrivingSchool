<?php
 $db_name = "WebDiP2015x045";
 $mysql_user = "WebDiP2015x045";
 $mysql_pass = "admin_tVC3";
 $server_name = "localhost";

 $con = mysqli_connect($server_name, $mysql_user, $mysql_pass, $db_name);
 if(!$con){
 	//echo "Baza je nedostupna".mysqli_connect_error();
 }

?>