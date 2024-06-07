<?php
// Impostare la durata del cookie (es. 3 minuti)
$cookieDuration = 180;

// Controllare e impostare il cookie per il numero di visite
if (isset($_COOKIE['visite'])) {
    $visite = $_COOKIE['visite'] + 1;
} else {
    $visite = 1;
}
setcookie('visite', $visite, time() + $cookieDuration);

// Controllare e impostare il cookie per l'ultima visita
$dataUltimaVisita = date('d/m/Y H:i:s');
if (isset($_COOKIE['ultima_visita'])) {
    $ultimaVisita = $_COOKIE['ultima_visita'];
} else {
    $ultimaVisita = 'Prima visita';
}
setcookie('ultima_visita', $dataUltimaVisita, time() + $cookieDuration);
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contatore Visite</title>
</head>
<body>
    <form action="" method="post">
        <label for="nome">Il tuo nome:</label>
        <input type="text" id="nome" name="nome" required>
        <input type="submit" value="Invia">
    </form>
    <?php
        if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST['nome'])) {
            $nome = $_POST['nome'];
            echo "Ciao $nome, è la tua $visite visita, la tua ultima visita è stata: $ultimaVisita";
        }
    ?>
    <form method="post">
        <button type="submit">Aggiorna Pagina</button>
    </form>
</body>
</html>