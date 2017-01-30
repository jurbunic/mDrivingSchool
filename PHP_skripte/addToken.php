<?php
    header('charset=utf-8');
    $mysqli = new mysqli("localhost","id564019_dbadmin","Uklonjeno iz sigurnosnih razloga","id564019_mdrivingschool");
    
    $token = $_POST["token"];
    $userId = $_POST["userid"];
        
    $newEntry = "INSERT INTO user_tokens VALUES (null,'$userId','$token')";
    if($userId==0 ||$userId == NULL){
        echo 'error';
            
    } else {
        $test = $mysqli->query("SELECT userId FROM user_tokens WHERE userId=$userId");
        
        $results = $test->num_rows;
        
        if($results==0){
            $results=$mysqli->query($newEntry);
        } else {
            $mysqli->query("UPDATE user_tokens SET token = '$token' WHERE userId = $userId");
        }
        
    }
       
  //  }
  // echo "Odgovor!";
    $mysqli->close();
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */