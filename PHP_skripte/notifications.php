<?php
header('charset=utf-8');
//require 'init.php';


function send($tokens,$bodys){
  $url = "https://fcm.googleapis.com/fcm/send ";
  $fields = array(
      'to' => $tokens,
      'data' => $bodys
    );

    $headers = array(
        "Authorization: key=AAAATuVVWRI:APA91bG7KjSh2gNG5qbQ24oKjs2Bi4piHmd9oJOlIeL2iF0vfkmArCQx0qJsJaSwwiyih6TtumAtddUMiUfHCYYhEt94f5WeqRQ3hqJ2aKTLTuS17jz-8za6BNP-0acpyYvBzp4qSEG7lY1qMoHout6HmsbbL4SzjQ",
        "Content-Type: application/json" 
      );

    $ch = curl_init();
       curl_setopt($ch, CURLOPT_URL, $url);
       curl_setopt($ch, CURLOPT_POST, true);
       curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
       curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
       curl_setopt ($ch, CURLOPT_SSL_VERIFYHOST, 0);  
       curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
       curl_setopt($ch, CURLOPT_POSTFIELDS, json_encode($fields));
       $result = curl_exec($ch);           
       if ($result === FALSE) {
           die('Curl failed: ' . curl_error($ch));
       }
       curl_close($ch);
       return $result;
}

$token = $_POST["token"];
$message1 = $_POST["message"];

$message = array("message" => "$message1");
  $message_status = send($token, $message);
  echo $message_status;