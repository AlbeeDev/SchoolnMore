<?php
session_start();

// Check if the user is logged in
if (!isset($_SESSION['user'])) {
    header('Location: login.php'); // Redirect to login if not logged in
    exit();
}

$userInfo = $_SESSION['user'];
echo "Welcome, " . htmlspecialchars($userInfo['name']) . " " . htmlspecialchars($userInfo['surname']);
echo "<br>Your name and surname from the cookie: " . htmlspecialchars($_COOKIE['name']) . " " . htmlspecialchars($_COOKIE['surname']);
