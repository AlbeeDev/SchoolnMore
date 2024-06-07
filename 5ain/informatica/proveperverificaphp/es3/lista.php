<?php
session_start();
?>

<!DOCTYPE html>
<html>
<head>
    <title>Lista delle Parole</title>
</head>
<body>
    <ul>
        <?php foreach ($_SESSION['parole'] as $parola) {
            echo "<li>$parola</li>";
        } ?>
    </ul>
    <a href="gioco.php">Torna al Gioco</a>
</body>
</html>
