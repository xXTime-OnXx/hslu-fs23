<!DOCTYPE html>
<html>

<head>
    <title>Hallo</title>
    <meta charset="utf8">
</head>

<body>
    <?php
    // DONE: Prüfen, ob Parameters 'name' gesetzt ist
    if (isset($_POST['name']) && !empty($_POST['name']))  {

        // DONE: Ausgabe des Parameters 'name'
        echo "<p>Hallo " . $_POST['name'] . "</p>";
        
    } else {
        echo "<p>Parameter 'name' nicht gesetzt</p>";
    }
    ?>
</body>

</html>