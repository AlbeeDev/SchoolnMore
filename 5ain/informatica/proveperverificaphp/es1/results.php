<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $dadi = $_POST['dadi'];
    $facce = $_POST['facce'];

    // Controllo dei dati
    if ($dadi > 0 && $facce > 0) {
        $risultati = [];
        $somma = 0;

        for ($i = 0; $i < $dadi; $i++) {
            $lancio = rand(1, $facce);
            $somma += $lancio;
            array_push($risultati, $lancio);
        }

        $media = $somma / $dadi;

        // Calcolo della moda
        $frequenze = array_count_values($risultati);
        arsort($frequenze);
        $moda = key($frequenze);

        echo "Risultati dei dadi: " . implode(", ", $risultati) . "<br>";
        echo "Somma: $somma<br>";
        echo "Media: $media<br>";
        echo "Moda: $moda<br>";
    } else {
        echo "I valori inseriti non sono validi.";
    }
} else {
    echo "Nessun dato ricevuto.";
}
echo '<br><a href="input.php"><button>Torna al lancio dei dadi</button></a>';
?>
