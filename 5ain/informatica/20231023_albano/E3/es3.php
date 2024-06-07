<!DOCTYPE html>
<!--Albano alex 5ain-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Es3</title>
</head>
<body>
    <?php
    //variabili di inzio
    $n1=6;
    $n2=9;

    function mcd($n1,$n2){
        $max=0;
        $min=0;
        if($n1==$n2) return $n1;
        if($n1>$n2){
            $max = $n1;
            $min = $n2;
        }
        else if($n1<$n2){
            $max = $n2;
            $min = $n1;
        }
        if($min==0) return $max;
        else{
            $r=10; //arbitrario
            $a=$max;
            $b=$min;
            //ciclo di divisioni per trovare l mcd
            while($r!=0){
                $r = $a%$b;
                $a=$b;
                $b=$r;
            }
            return $a;
        }
    }

    function mcm($n1,$n2){
        return ($n1*$n2)/mcd($n1,$n2);
    }
    //assegnano le funzioni a 2 variabili
    $mcm = mcm($n1,$n2);
    $mcd = mcd($n1,$n2);
    //stampa
    echo"i 2 numeri $n1 e $n2 hanno come mcd $mcd e mcm $mcm";
    ?>
</body>
</html>