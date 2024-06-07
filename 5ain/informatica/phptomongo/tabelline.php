<!DOCTYPE html>
<!-- Albano alex 5ain -->
<html>
<head>
    <style>
        .even {
            background-color: lightblue;
        }
        .odd {
            background-color: lightgreen;
        }
    </style>
</head>
<body>
    <table border="1">
        <tr>
            <th>Tabelline</th>
            <?php
            for ($i = 1; $i <= 10; $i++) {
                echo "<th>$i</th>";
            }
            ?>
        </tr>
        <?php
        for ($i = 1; $i <= 10; $i++) {
            echo "<tr>";
            echo "<td>$i</td>";
            
            for ($j = 1; $j <= 10; $j++) {
                $result = $i * $j;
                $class = ($result % 2 == 0) ? "even" : "odd";
                echo "<td class='$class'>$result</td>";
            }
            
            echo "</tr>";
        }
        ?>
    </table>
</body>
</html>