<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</head>
<body class="bg-info text-light">
    <div class="container-fluid">
        <div class="row">
            <?php 
            for ($i=0; $i < 64; $i++) { 
                $index = random_int(1,3);
                ?>
                <div class="col">
                <img src="/assets/<?php echo $index ?>.png" style="max-width: 100px; max-height: 100px;" alt="" >
                </div>
                <?php
            }
            ?>
            
        </div>
        <div class="footer py-5 bg-warning" style="position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: #f8f9fa;
            padding: 1rem;
            text-align: center;">
                <div class="container">
                    <span class="text-muted"></span>
                </div>
            </div>
    </div>
    
</body>
</html>