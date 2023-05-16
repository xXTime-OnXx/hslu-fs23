<!DOCTYPE html>
<html>
    <head>
        <title>Berechneter Gesamtwiderstand</title>
        <meta charset="utf8">
    </head>
    <body>
<?php

// DONE: Übernehmen Sie hier Funktion calculateResistance aus Übung 3a der Serie
//       "Interaktive Webapplikationen" und nehmen Sie Anpassungen vor, welche
//       für PHP notwendig sind.
function calculateResistance($r1, $r2, $wiring) {
    if ($wiring == 'serial') {
        $totalResistance = $r1 + $r2;
    } else if ($wiring == 'parallel') {
        $totalResistance = $r1 * $r2 / ($r1 + $r2);
    }
    return $totalResistance;
}

function validateParameters() {
    $valid = true;
    
    // Prüfe Existenz
    if (!isset($_POST['r1'])) {
        echo "<p>Parameter 'r1' wird benötigt</p>";
        $valid = false;
    }
    if (!isset($_POST['r2'])) {
        echo "<p>Parameter 'r2' wird benötigt</p>";
        $valid = false;
    }
    if (!isset($_POST['wiring'])) {
        echo "<p>Parameter 'wiring' wird benötigt</p>";
        $valid = false;
    }

    return $valid;
}

if (validateParameters()) {
    // DONE: Parameter auslesen und Berechnung des Gesamtwiderstands
    $totalResistance = calculateResistance($_POST['r1'], $_POST['r2'], $_POST['wiring']);
    // DONE: Ausgabe des Gesamtwiderstands
    echo '<p>' . $totalResistance . '</p>';
}
?>
    <a href="resistanceForm.html">Zurück zum Formular</a>
    </body>
</html>