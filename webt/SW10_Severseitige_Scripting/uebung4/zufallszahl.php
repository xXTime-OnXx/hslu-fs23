<!DOCTYPE html>
<html>

<head>
    <title>Übung 4: Zufallszahl</title>
    <meta charset="utf8">
    <style>
        .red   { color: red; }
        .green { color: green; }
    </style>
</head>

<body>
    <form action="zufallszahl.php" method="POST">
        <?php        
        // Erster Aufruf: Paragraph mit Infotext ausgeben, sonst Zufallszahl
        if (!isset($_POST["action"]) || $_POST["action"] != "random") {
            echo "<p>bisher noch keine Zufallszahl vorliegend.</p>";
        } else {
            // Berechnung der Zufallszahl
            $zahl = mt_rand() / (mt_getrandmax() / 100);

            // DONE: Paragraph mit Zahl ausgeben. Klasse green, falls < 50 sonst Klasse red.
            if ($zahl < 50) {
                echo "<p class=\"green\">" . $zahl . "</p>";
            } else {
                echo "<p class=\"red\">" . $zahl . "</p>";
            }         
        }
        ?>
        <input type="hidden" name="action" value="random">
        <button type="submit">berechne Zufallszahl</button>
    </form>
</body>

</html>