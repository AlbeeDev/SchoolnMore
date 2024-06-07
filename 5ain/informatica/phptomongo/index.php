<?php
require 'composer/vendor/autoload.php';

$mongoClient = new MongoDB\Client("mongodb://localhost:27017");
$database = $mongoClient->selectDatabase("test");
$collection = $database->selectCollection("user");

// Esegui la query
$documents = $collection->find();

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>

<table class="table table-primary table-striped table-hover">
    <tr>
        <th>Username</th>
        <th>Nome</th>
    </tr>
    <?php foreach ($documents as $document): ?>
    <tr>
        <td><?php echo $document['username']; ?></td>
        <td><?php echo $document['nome']; ?></td>
    </tr>
    <?php endforeach; ?>
</table>

</body>
</html>