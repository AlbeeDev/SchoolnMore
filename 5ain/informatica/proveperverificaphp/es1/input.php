<!DOCTYPE html>
<html>
<head>
    <title>Lancio Dadi</title>
</head>
<body>
    <form action="results.php" method="post">
        <label for="dadi">Numero di dadi:</label>
        <input type="number" id="dadi" name="dadi" required>
        <label for="facce">Numero di facce per dado:</label>
        <input type="number" id="facce" name="facce" required>
        <input type="submit" value="Lancia i dadi">
    </form>
</body>
</html>
