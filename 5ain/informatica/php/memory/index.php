<?php
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if(isset($_POST['exit'])){
        echo "<script>console.log('closed')</script>";
        session_destroy();
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <title>Memory Game</title>
</head>
<body>
    <h2>Welcome to the Memory Game</h2>
    <form action="game.php" method="post"> <!-- Assuming setup logic is combined with game logic -->
        <label for="name">Your Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="pairs" class="slider-label">Number of Pairs: <span id="pairsValue">5</span></label>
        <input type="range" id="pairs" name="pairs" min="2" max="10" value="5" oninput="document.getElementById('pairsValue').innerText = this.value">

        <button type="submit">Start Game</button>
    </form>
</body>
</html>
