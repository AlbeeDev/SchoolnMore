<?php
//albano alex 5ain
session_start();
//se l'utente non ha effetuato il login va alla pagina di login
if (!isset($_SESSION['loggedin']) || $_SESSION['loggedin'] != true) {
    header("Location: login.php");
    exit;
}
//se l utente ha fatto il loguout va alla pagina di login
if (isset($_POST['logout'])) {
    session_destroy();
    header("Location: login.php");
    exit;
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="page.css">
</head>
<body>
    <ul>
        <li><a href="pagina1.php">pagina 1</a></li>
        <li><a href="pagina2.php">pagina 2</a></li>
        <li><a href="pagina3.php">pagina 3</a></li>
        <li><a href="logout.php">logout</a></li>
    </ul>
</body>
</html>