<?php

require "init.php";
$user_name =$_POST["login_name"];
$user_pass = $_POST["login_pass"];

$sql_query = "SELECT id,tip_id FROM korisnik WHERE user_name LIKE '$user_name' AND user_pass LIKE '$user_pass';";
$result = mysqli_query($con, $sql_query);

$response = array();

if(mysqli_num_rows($result) > 0){
	$row = mysqli_fetch_array($result);
	array_push($response,array("id"=>$row[0],"tip_id"=>$row[1]));
	echo json_encode(array("server_response"=>$response));
}else{
	echo "Login faild";
}

?>