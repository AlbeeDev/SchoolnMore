<?php
define('USER_FILE', 'users.txt');
session_start();

function verifyUser($name, $password) {
    $users = file(USER_FILE);
    foreach ($users as $user) {
        list($username, $userpassword) = explode(',', trim($user));
        if ($username == $name && $userpassword == $password) {
            return ['name' => $name];
        }
    }
    return false;
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $userInfo = verifyUser($_POST['name'], $_POST['password']);
    if ($userInfo) {
        $_SESSION['user'] = $userInfo;
        setcookie('name', $userInfo['name'], time() + 60);
        header('Location: home.php'); // Redirect to welcome page after successful login
        exit();
    } else {
        echo "Invalid email or password.";
    }
}

?>

<form action="login.php" method="post">
    Email: <input type="text" name="name"><br>
    Password: <input type="password" name="password"><br>
    <input type="submit" value="Login">
</form>