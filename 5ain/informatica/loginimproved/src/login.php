<?php
define('USER_FILE', 'users.txt');
session_start();

// Function to verify user credentials
function verifyUser($email, $password) {
    $users = file(USER_FILE);
    foreach ($users as $user) {
        list($userEmail, $userPassword, $name, $surname) = explode(',', trim($user));
        if ($userEmail == $email && $userPassword == md5($password)) {
            return ['name' => $name, 'surname' => $surname];
        }
    }
    return false;
}

// Handling the login form submission
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $userInfo = verifyUser($_POST['email'], $_POST['password']);
    if ($userInfo) {
        $_SESSION['user'] = $userInfo;
        setcookie('name', $userInfo['name'], time() + 3600); // 1 hour for cookie expiration
        setcookie('surname', $userInfo['surname'], time() + 3600);
        header('Location: welcome.php'); // Redirect to welcome page after successful login
        exit();
    } else {
        echo "Invalid email or password.";
    }
}
?>

<!-- Login Form -->
<form action="login.php" method="post">
    Email: <input type="email" name="email"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>
