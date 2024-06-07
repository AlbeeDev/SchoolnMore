<?php
//albano alex 5ain
session_start();
// usando loggedin come variabile per verificare se l utente ha gia effettuato il login
if (isset($_SESSION['loggedin']) && $_SESSION['loggedin'] == true) {
    header("Location: pagina1.php"); // allora si reindirizza alla dashboard
    exit;
}

$errorMessage = '';
// se la form html è stata inviata
if (isset($_POST['inviato'])) {
    $username = $_POST['username'];
    $password = $_POST['password'];

    //se le credenziali corrispondono
    if ($username == 'utente' && $password == 'password') {
        $_SESSION['loggedin'] = true; // utente ha effettuato il login
        header("Location: pagina1.php");
        exit;
    } else {
        $errorMessage = 'Credenziali non valide!';
    }
}
?>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <?php if ($errorMessage) echo "<p style='color: red;'>$errorMessage</p>"; //stampa l errore?>

    <form action="login.php" method="post">
        Username: <input type="text" name="username" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" name="inviato" value="Accedi">
    </form>
</body>
</html>