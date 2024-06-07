<?php
session_start();

$user = $_SESSION['user'];
$cardNumber = $_SESSION['cardnumber'];

$cardt = range(1,$cardNumber);

$cards = array_merge($cardt,$cardt);

shuffle($cards);

function createCard($number) {
    $card = '<button class="card">' . $number . '</button>';
    return $card;
}

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>Document</title>
</head>
<body>
    
    <?php
        echo "username: ".$user." number of cards: ".$cardNumber."<br>";
        echo '<div class="card-container">';
        for($i=0; $i<$cardNumber*2; $i++){
            echo createCard($cards[$i]);
        }
        echo '</div>';
    ?>
</body>
</html>

