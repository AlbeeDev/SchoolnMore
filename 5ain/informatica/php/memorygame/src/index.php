<?php
session_start()
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
        if ($_SERVER['REQUEST_METHOD'] == 'POST') {
            $_SESSION['user']=$_POST['user'];
            $_SESSION['cardnumber']=$_POST['cardnumber'];
            header('Location: game.php');
            exit();
        }
    ?>

    <form action="index.php" method="post">
        Username: <input type="text" name="user"><br>
        Pairs Number: <input type="text" name="cardnumber"><br>
        <input type="submit" value="Start">
    </form>
</body>
</html>