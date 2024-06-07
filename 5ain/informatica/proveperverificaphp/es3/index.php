<?php
// Avvia la sessione
session_start();

// Controlla se il form è stato inviato
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Salva i nomi nella sessione e reindirizza alla pagina del gioco
    $_SESSION['giocatore1'] = $_POST['giocatore1'];
    $_SESSION['giocatore2'] = $_POST['giocatore2'];
    $_SESSION['turno'] = rand(1, 2); // Decide casualmente chi inizia
    $_SESSION['parole'] = []; // Array per memorizzare le parole inserite
    header('Location: gioco.php');
    exit();
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Inserisci Nomi Giocatori</title>
</head>
<body>
    <form method="post">
        Giocatore 1: <input type="text" name="giocatore1" required><br>
        Giocatore 2: <input type="text" name="giocatore2" required><br>
        <input type="submit" value="Inizia Gioco">
    </form>
</body>
</html>