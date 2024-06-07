<?php
session_start();

// Controlla se una parola è stata inviata
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['parola'])) {
    $parola = strtolower(trim($_POST['parola']));
    $ultimaParola = end($_SESSION['parole']);

    // Controlla la validità della parola e cambia turno
    if (
        (empty($ultimaParola) || substr($ultimaParola, -2) === substr($parola, 0, 2)) &&
        !in_array($parola, $_SESSION['parole'])
    ) {
        array_push($_SESSION['parole'], $parola);
        $_SESSION['turno'] = $_SESSION['turno'] == 1 ? 2 : 1;
    } else {
        // Termina il gioco se la parola non è valida
        header('Location: fine.php');
        exit();
    }
}

// Nome del giocatore attuale
$giocatoreCorrente = $_SESSION['turno'] == 1 ? $_SESSION['giocatore1'] : $_SESSION['giocatore2'];
?>

<!DOCTYPE html>
<html>
<head>
    <title>Gioco delle Parole</title>
</head>
<body>
    <p>È il turno di <?php echo $giocatoreCorrente; ?></p>
    <form method="post">
        Inserisci una parola: <input type="text" name="parola" required><br>
        <input type="submit" value="Invia">
    </form>
    <a href="lista.php">Visualizza parole inserite</a>
</body>
</html>
