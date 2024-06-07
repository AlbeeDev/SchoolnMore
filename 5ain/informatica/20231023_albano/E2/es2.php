<!DOCTYPE html>
<!--Albano alex 5ain-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Es2</title>
</head>
<body>
    <?php
    //stringa di inizio
    $string = "la vita è bella ma la bellavita di piu";
    //contatori
    $a=0;
    $e=0;
    $i=0;
    $o=0;
    $u=0;
    //loop che inspeziona ogni lettera del array stringa
    for($j = 0; $j<strlen($string);$j++){
        //controllo lettere siano uguali - aumento il contatore
        if($string[$j]=="a"){
            $a++;
        }
        if($string[$j]=="e"){
            $e++;
        }
        if($string[$j]=="i"){
            $i++;
        }
        if($string[$j]=="o"){
            $o++;
        }
        if($string[$j]=="u"){
            $u++;
        }
    }
    //stampa
    echo"la frase/parola \"$string\" contiene vocali a:$a-e:$e-i:$i-o:$o-u:$u";
    ?>
</body>
</html>