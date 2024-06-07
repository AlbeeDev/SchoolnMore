<?php
session_start();
$vincitore = $_SESSION['turno'] == 1 ? $_SESSION['giocatore2'] : $_SESSION['giocatore1'];
session_destroy(); // Termina la sessione e resetta il gioco
?>

<!DOCTYPE html>
<html>
<head>
    <title>Fine del Gioco</title>
</head>
<body>
    <p><?php echo $vincitore; ?> ha vinto!</p>
    <a href="index.php">Ricomincia Gioco</a>
</body>
</html>
