<?php
session_start();

function initializeGame($name, $pairs) {
    echo "<script>console.log('started')</script>";
    $_SESSION['name'] = $name;
    $cards = array();
    for ($i = 1; $i <= $pairs; $i++) {
        // Store each card as an associative array with 'value' and 'matched' keys
        $cards[] = ['value' => $i, 'matched' => false];
        $cards[] = ['value' => $i, 'matched' => false];
    }
    shuffle($cards);
    $_SESSION['cards'] = $cards;
    $_SESSION['flipped'] = array();
    $_SESSION['matches'] = 0;
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    if (isset($_POST['name']) && isset($_POST['pairs'])) {
        // Initial setup from index.php form submission
        initializeGame($_POST['name'], (int)$_POST['pairs']);
    } elseif (isset($_POST['flip'])) {
        // Game card flip action
        $flipIndex = $_POST['flip'];
        // Allow showing up to 2 cards before checking/resetting
        if (!in_array($flipIndex, $_SESSION['flipped'])) {
            array_push($_SESSION['flipped'], $flipIndex);
            if (count($_SESSION['flipped']) == 3) {
                $firstCard = &$_SESSION['cards'][$_SESSION['flipped'][0]];
                $secondCard = &$_SESSION['cards'][$_SESSION['flipped'][1]];
                if ($firstCard['value'] == $secondCard['value']) {
                    $firstCard['matched'] = true;
                    $secondCard['matched'] = true;
                    $_SESSION['matches']++;
                    $debug++;
                }
                // Reset flipped cards but keep the third one for showing
                array_shift($_SESSION['flipped']); // Remove the first card
                array_shift($_SESSION['flipped']); // Remove the second card
            }

            if (count($_SESSION['cards']) - $_SESSION['matches']*2 == 2){
                foreach ($_SESSION['cards'] as $index => $card) {
                    if (!isset($card['matched']) || $card['matched'] !== true) {
                        $remainingCardsToFlip[] = $index;
                        $card['matched'] = true;
                    }
                }
    
                if (count($remainingCardsToFlip) == 2) {
                    $_SESSION['flipped'] = array_merge($_SESSION['flipped'], $remainingCardsToFlip);
                }
            }
        }   
    }
}

if (!isset($_SESSION['cards']) || !isset($_SESSION['name'])) {
    // Show initial game setup form
    header("Location: index.php");
    exit;
} else {
    echo $_SESSION['matches'] * 2 . " " . count($_SESSION['cards']);
    if ($_SESSION['matches'] * 2 == count($_SESSION['cards'])) {
        echo "<p>Game Finished. Congratulations, " . htmlspecialchars($_SESSION['name']) . "!</p>";
        session_destroy(); // End the session and reset for a new game
    } else {
        // Display game board
        echo "<link rel='stylesheet' href='style.css'>";
        echo "<form action='' method='post'>";
        echo "<div class='cards-container'>";
        foreach ($_SESSION['cards'] as $index => $cardInfo) {
            $disabled = $cardInfo['matched'] ? 'disabled' : '';
            echo "<button type='submit' name='flip' value='$index' class='card-button' $disabled>";
            if (in_array($index, $_SESSION['flipped']) || $cardInfo['matched']) {
                // Assuming you have individual images for each card value
                echo "<img src='cards/{$cardInfo['value']}.png' alt='Card {$cardInfo['value']}'>";
            } else {
                echo "<img src='cards/template.jpg' alt='Card Back'>";
            }
            echo "</button>";
        }
        echo "</div>";
        echo "</form>";
        
        echo "<form action='index.php' method='post'>";
        echo "<input type='hidden' id='exit' value='true' required><br>";
        echo "<button type='submit'> Back to Menu </button>";
        
    }
}
?>