<?php
// File to store user data - in a real application, use a database
define('USER_FILE', 'users.txt');

// Function to save user data
function registerUser($email, $password, $name, $surname) {
    $userData = $email . ',' . md5($password) . ',' . $name . ',' . $surname . PHP_EOL;
    file_put_contents(USER_FILE, $userData, FILE_APPEND);
}

// Handling the registration form submission
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    registerUser($_POST['email'], $_POST['password'], $_POST['name'], $_POST['surname']);
    header('Location: login.php'); // Redirect to login page after registration
    exit();
}
?>

<!-- Registration Form -->
<form action="register.php" method="post">
    Name: <input type="text" name="name"><br>
    Surname: <input type="text" name="surname"><br>
    Email: <input type="email" name="email"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Register">
</form>
