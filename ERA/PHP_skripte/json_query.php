<?php
header('charset=utf-8');
require "init.php";

$choose_query = $_GET["data_retrive"];
$choose_person = $_GET["osoba"];

if($choose_query == 4){
$ime = $_POST["ime"];
$prezime = $_POST["prezime"];
$datum_rodenja = $_POST["datum_rodenja"];
$mjesto_rodenja = $_POST["mjesto_rodenja"];
$mobitel = $_POST["mobitel"];
$telefon = $_POST["telefon"];
$email = $_POST["email"];
$propisi = $_POST["propisi"];
$adresa = $_POST["adresa"];
$prva_pomoc = $_POST["prva_pomoc"];
$sati_voznje = $_POST["sati_voznje"];
$user_name = $_POST["user_name"];
$user_pass = $_POST["user_pass"];
}elseif ($choose_query == 6){
	$instruktor = $_POST["instruktor"];
	$polaznik = $_POST["polaznik"];
}elseif ($choose_query == 7){
	$brisiI = $_POST["instruktor"];
	$brisiP = $_POST["polaznik"];
}elseif($choose_query == 8){
	$id = $_POST["id"];
	$propisi1 = $_POST["propisi"];
	$prva_pomoc1 = $_POST["prva_pomoc"];
	$ispit_voznje1 = $_POST["ispit_voznje"];
}elseif ($choose_query == 9) {
	$sati = $_POST["sati"];
	$id1 = $_POST["id1"];
}elseif ($choose_query == 10) {
	$id2 = $_POST["id2"];
	$datum_voznje = $_POST["datum_voznje"];
	$vrijeme_voznje = $_POST["vrijeme_voznje"];
}
	
$response = array();


if($choose_query == 1){
	$select_instruktor = "SELECT * FROM korisnik WHERE id = (SELECT instruktor FROM instruktor WHERE instruktor.polaznik = '$choose_person');";
	$result = mysqli_query($con, $select_instruktor);
	while ($row = mysqli_fetch_array($result)) {
		array_push($response, array("id"=>$row[0],"ime"=>$row[1], "prezime"=>$row[2],"datum_rodenja"=>$row[3],"mjesto_rodenja"=>$row[4],"mobitel"=>$row[5],"telefon"=>$row[6],"email"=>$row[7],"adresa"=>$row[8],"propisi"=>$row[9],"prva_pomoc"=>$row[10],"ispit_voznje"=>$row[11],"datum_voznje"=>$row[12],"vrijeme_voznje"=>$row[13],"sati_voznje"=>$row[14],"user_name"=>$row[15],"user_pass"=>$row[16],"tip_id"=>$row[17]));
	}
	echo json_encode(array("instruktor"=>$response));	
	/*$query = "SELECT * FROM korisnik;";
	$result = mysqli_query($con, $query);
	while ($row = mysqli_fetch_array($result)) {
		array_push($response, array("id"=>$row[0],"ime"=>$row[1], "prezime"=>$row[2],"datum_rodenja"=>$row[3],"mjesto_rodenja"=>$row[4],"mobitel"=>$row[5],"telefon"=>$row[6],"email"=>$row[7],"adresa"=>$row[8],"propisi"=>$row[9],"prva_pomoc"=>$row[10],"sati_voznje"=>$row[11],"user_name"=>$row[12],"user_pass"=>$row[13],"tip_id"=>$row[14]));
	}
	echo json_encode(array("korisnici"=>$response));*/

}elseif ($choose_query == 2) {
	$query_1 = "SELECT * FROM korisnik WHERE id = '$choose_person';";
	$result = mysqli_query($con, $query_1);
	while ($row = mysqli_fetch_array($result)) {
		array_push($response, array("id"=>$row[0],"ime"=>$row[1], "prezime"=>$row[2],"datum_rodenja"=>$row[3],"mjesto_rodenja"=>$row[4],"mobitel"=>$row[5],"telefon"=>$row[6],"email"=>$row[7],"adresa"=>$row[8],"propisi"=>$row[9],"prva_pomoc"=>$row[10],"ispit_voznje"=>$row[11],"datum_voznje"=>$row[12],"vrijeme_voznje"=>$row[13],"sati_voznje"=>$row[14],"user_name"=>$row[15],"user_pass"=>$row[16],"tip_id"=>$row[17]));
	}
	echo json_encode(array("korisnik"=>$response));
	
}elseif ($choose_query == 3) {
	$query_2 = "SELECT k.id, k.ime, k.prezime, k.datum_rodenja, k.mjesto_rodenja, k.mobitel, k.telefon, k.email,k.adresa, k.propisi,k.prva_pomoc,k.ispit_voznje,k.datum_voznje,k.vrijeme_voznje,k.sati_voznje FROM instruktor i JOIN korisnik k ON i.polaznik = k.id WHERE i.instruktor = '$choose_person';";
	$result = mysqli_query($con, $query_2);
	while ($row = mysqli_fetch_array($result)) {
		array_push($response, array("id"=>$row[0],"ime"=>$row[1], "prezime"=>$row[2],"datum_rodenja"=>$row[3],"mjesto_rodenja"=>$row[4],"mobitel"=>$row[5],"telefon"=>$row[6],"email"=>$row[7],"adresa"=>$row[8],"propisi"=>$row[9],"prva_pomoc"=>$row[10],"ispit_voznje"=>$row[11],"datum_voznje"=>$row[12],"vrijeme_voznje"=>$row[13],"sati_voznje"=>$row[14]));
	}
	echo json_encode(array("polaznik"=>$response));
}elseif($choose_query == 4){
      $insert_query = "INSERT INTO korisnik (id,ime,prezime,datum_rodenja,mjesto_rodenja,mobitel,telefon,email,adresa,propisi,prva_pomoc,sati_voznje,user_name,user_pass,tip_id) VALUES(DEFAULT,'$ime','$prezime','$datum_rodenja','$mjesto_rodenja','$mobitel','$telefon','$email','$adresa',DEFAULT,DEFAULT,DEFAULT,'$user_name','$user_pass',DEFAULT);";
      if(mysqli_query($con, $insert_query)){
      	echo "1";
      }else{
      	echo "0";
      }
}elseif ($choose_query == 5){
	$query4 = "SELECT id,ime,prezime,datum_rodenja,mjesto_rodenja,mobitel,telefon,email,adresa,propisi,prva_pomoc,ispit_voznje,sati_voznje FROM korisnik WHERE NOT EXISTS(SELECT * FROM instruktor WHERE instruktor.polaznik = korisnik.id) AND tip_id = 2;";
	$result = mysqli_query($con, $query4);
	while ($row = mysqli_fetch_array($result)) {
		array_push($response, array("id"=>$row[0],"ime"=>$row[1], "prezime"=>$row[2],"datum_rodenja"=>$row[3],"mjesto_rodenja"=>$row[4],"mobitel"=>$row[5],"telefon"=>$row[6],"email"=>$row[7],"adresa"=>$row[8],"propisi"=>$row[9],"prva_pomoc"=>$row[10],"ispit_voznje"=>$row[11],"sati_voznje"=>$row[12]));
	}
	echo json_encode(array("add"=>$response));
}elseif($choose_query == 6){
      $insert_query = "INSERT INTO instruktor (instruktor, polaznik) VALUES('$instruktor','$polaznik');";
      if(mysqli_query($con, $insert_query)){
      	echo "1";
      }else{
      	echo "0";
      }
}elseif($choose_query == 7){
      $delete_query = "DELETE FROM instruktor WHERE instruktor = '$brisiI' AND polaznik = '$brisiP';";
      if(mysqli_query($con, $delete_query)){
      	echo "2";
      }else{
      	echo "3";
      }
}elseif($choose_query == 8){
	$update_ispit = "UPDATE korisnik SET propisi = '$propisi1', prva_pomoc = '$prva_pomoc1', ispit_voznje = '$ispit_voznje1' WHERE id = '$id';";
	if(mysqli_query($con,$update_ispit)){
		echo "4";
	}else{
		echo "5";
	}
}elseif($choose_query == 9){
	$update_ispit = "UPDATE korisnik SET sati_voznje = sati_voznje +'$sati' WHERE id = '$id1';";
	if(mysqli_query($con,$update_ispit)){
		echo "6";
	}else{
		echo "7";
	}
}elseif($choose_query == 10){
	$update_voznja = "UPDATE korisnik SET datum_voznje = '$datum_voznje', vrijeme_voznje = '$vrijeme_voznje' WHERE id = '$id2';";
	if(mysqli_query($con,$update_voznja)){
		echo "8";
	}else{
		echo "9";
	}
}/*elseif($choose_query == 12){
	$select_instruktor = "SELECT * FROM korisnik WHERE id = (SELECT instruktor FROM instruktor WHERE instruktor.polaznik = '$choose_person');";
	$result = mysqli_query($con, $select_instruktor);
	while ($row = mysqli_fetch_array($result)) {
		array_push($response, array("id"=>$row[0],"ime"=>$row[1], "prezime"=>$row[2],"datum_rodenja"=>$row[3],"mjesto_rodenja"=>$row[4],"mobitel"=>$row[5],"telefon"=>$row[6],"email"=>$row[7],"adresa"=>$row[8],"propisi"=>$row[9],"prva_pomoc"=>$row[10],"ispit_voznje"=>$row[11],"datum_voznje"=>$row[12],"vrijeme_voznje"=>$row[13],"sati_voznje"=>$row[14],"user_name"=>$row[15],"user_pass"=>$row[16],"tip_id"=>$row[17]));
	}
	echo json_encode(array("instruktor"=>$response));	
}*/
else{
	echo 'No data is requiered';
}	

mysqli_close($con);

?>

