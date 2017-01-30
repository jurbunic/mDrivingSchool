<?php
    $userId = $_POST["userId"];
    
    
    header('charset=utf-8');
    $mysqli = new mysqli("localhost","id564019_dbadmin","Uklonjeno iz sigurnosnih razloga","id564019_mdrivingschool");
    
    
    $sqlQuery = "SELECT token FROM user_tokens WHERE userId = $userId";
    
    $results = $mysqli->query($sqlQuery); 
    //$rez = $results->get_result();
    $userToken = $results->fetch_row();
    echo "$userToken[0]";