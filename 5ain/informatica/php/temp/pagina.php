<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <form action="pagina.php" method="post">
        name: <input type="text" name="name" value="">
        email: <input type="text" name="email" value="">
        <input type="submit" name="inviato">
    </form>

    <?php
        if(isset($_POST["inviato"])){
            if($_POST["name"]) echo "ciao "+$_POST["name"]+" <br>";
            if(strlen($_POST["email"])<>0) echo "la tua email "+$_POST["email"]+" <br>";
        }
        else{
            echo "nessun dato";
        }
    ?>
</body>
</html>