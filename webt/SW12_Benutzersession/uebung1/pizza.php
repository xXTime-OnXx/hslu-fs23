<!DOCTYPE html>
<html>

<head>
    <meta charset="utf8">
    <title>Übung 1: Pizzaparadies - Webshop</title>
</head>

<body>       
    <?php
    $pizzas = [ 'Margherita', 'Fantasia', 'Tonno', 'Funghi', 'Gorgonzola', 'Prosciutto', 'Padrone'];
    $preis = [ 'Margherita' => 17.5,
               'Fantasia'   => 19.5,
               'Tonno'      => 18.5,
               'Funghi'     => 18,
               'Gorgonzola' => 18.5,
               'Prosciutto' => 18,
               'Padrone'    => 19.5];

    // Änderung an der Bestellung
    if (isset($_POST['pizza']) && isset($_POST['anzahl'])) {
        $pizza = $_POST['pizza'];
        $neu = intval($_POST['anzahl']);
        
        // TODO: Fragen Sie den aktuellen Wert für die Pizzaart im Warenkorb ab
        // (gleicher Name im Cookie wie im Requestparameter)
        // und speichern Sie die Anzahl in die Variable $aktuell (0 falls nichts
        // im Warenkorb ist).
        if (isset($_COOKIE[$pizza])) {
            $aktuell = intval($_COOKIE[$pizza]);
        } else {
            $aktuell = 0;
        }
        
        // TODO: Falls $neu == -1 soll der Artikel aus dem Warenkorb
        // entfernt werden (Anzahl == 0), ansonsten soll die aktuelle Anzahl
        // um die neue Menge $neu erhöht werden.
        if ($neu != -1) {
            $aktuell = $aktuell + $neu;
        } else {
            $aktuell = 0;
        }

        // TODO: Speichern Sie die neue Anzahl im Cookie
        setcookie($pizza, $aktuell);
        $_COOKIE[$pizza] = $aktuell;
    }
    ?>

    <h1>Pizzaparadies</h1>
    <h2>Sortiment</h2>
    <p>Bitte wählen Sie Ihre Pizza aus unserem Sortiment:</p>
    <table>
        <tr>
            <th>Pizza</th><th>Preis CHF</th>
        </tr>

        <?php
        // Generiere Tabellenzeilen für die Produktübersicht
        $i = 0;
        while($i < count($pizzas)) {
            $pizza = $pizzas[$i];
            echo "<tr>";
            echo "  <td><a href=\"show.php?pizza=" . $pizza . "&price=" . $preis[$pizza] . "\">" . $pizza. "</td>";
            echo "  <td>" . number_format($preis[$pizza], 2, '.', '') . "</td>";
            echo "</tr>";            
            $i = $i + 1;
        }
        ?> 
    </table>

    <h2>Warenkorb</h2>
    <table>
        <tr>
            <th>Anzahl</th><th>Pizza</th><th>Preis CHF</th><th>Total CHF</th>
        </tr>

        <?php
        $gesamttotal = 0;
        $i = 0;
        while($i < count($pizzas)) {
            $pizza = $pizzas[$i];

            // Pizza ist Teil des Warenkorbs, falls Wert eine positive Ganzzahl ist.
            if (isset($_COOKIE[$pizza])) {
                $anzahl = intval($_COOKIE[$pizza]);
                if ($anzahl < 0) { $anzahl = 0; }
            } else {
                $anzahl = 0;
            }

            // Zeige Pizza im Warenkorb an, falls Anzahl > 0 
            if ($anzahl > 0) {
                $total = $anzahl * $preis[$pizza];
                $gesamttotal = $gesamttotal + $total;

                // Generiere Tabelleneintrag
                echo "<tr>";
                echo "  <td>" . $anzahl . "</td>";
                echo "  <td>" . $pizza . "</td>";
                echo "  <td>" . number_format($preis[$pizza], 2, '.', '') . "</td>";
                echo "  <td>" . number_format($total, 2, '.', '') . "</td>";
                echo "  <td><form action=\"pizza.php\" method=\"POST\">";
                echo "          <input name=\"pizza\" type=\"hidden\" value=\"" . $pizza . "\">";
                echo "          <input name=\"anzahl\" type=\"hidden\" value=\"-1\">";
                echo "          <button type=\"submit\">x</button>";
                echo "      </form></td>";
                echo "</tr>";
            }       
            $i = $i + 1;
        }
        ?> 
        
        <tr>
            <td>
            <th>Total</th>
            <td></td>                
            <?php echo "<td>" . number_format($gesamttotal, 2, '.', '') . "</td>";?>
        </tr>
    </table>

    <p><a href="checkout.php">Bestellvorgang abschliessen (nicht implementiert)</a></p>
</body>

</html>