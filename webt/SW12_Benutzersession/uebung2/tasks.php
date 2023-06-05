<!DOCTYPE html>
<html>
    <head>
        <title>Übung 2: Aufgabenverwaltung</title>
        <meta charset="utf8">
    </head>
    <body>
    <h1>Aufgabenverwaltung</h1>

<?php

// require_once fügt die entsprechedne PHP-Datei an exakt dieser Stelle ein.
// Dies wird benutzt um identische PHP-Code Fragmente in mehreren PHP-Skripts
// zu verwenden und vermeidet Code-Duplikation.
require_once 'users.php';

// starte Benutzersession
if (!session_start()) {
    echo 'Internal error: cannot open user session\n'; return;
}

// erstelle Verbindung zur Datenbank
$conn = mysqli_connect('localhost', 'root' ,'', 'tasks');
if (!$conn) {
    echo 'Internal error: no database connection\n'; return;
}

// führe Benutzerkonto-Aktion aus, sofern Request-Parameter "action" gesetzt ist
if (isset($_POST['action'])) {
    if ($_POST['action'] == 'register') {
        if (isset($_POST['login']) && isset($_POST['passwort'])) {
            register($conn, $_POST['login'], $_POST['passwort']);
        }
    } elseif ($_POST['action'] == 'login') {
        if (isset($_POST['login']) && isset($_POST['passwort'])) {
            login($conn, $_POST['login'], $_POST['passwort']);
        }
    } elseif ($_POST['action'] == 'logout') {
        logout();
    }
}

// Kein Konto verknüpft: zeige Anmelde- und Registrierungsformular
// Konto verknüpft: zeige angemeldeten Benutzer und Logoutbutton
if (!isset($_SESSION['user'])) {
    echo "<form action=\"tasks.php\" method=\"POST\">\n";
    echo "    <label>Login:</label>\n";
    echo "    <input name=\"login\"><br>\n";
    echo "    <label>Passwort:</label>\n";
    echo "    <input type=\"password\" name=\"passwort\"><br>\n";
    echo "    <input type=\"radio\" name=\"action\" value=\"login\" checked>Login<br>\n";
    echo "    <input type=\"radio\" name=\"action\" value=\"register\" >Registrierung<br>\n";
    echo "    <button type=\"submit\">Einloggen / Registrieren</button>\n";
    echo "</form>";
} else {
    echo "<form action=\"tasks.php\" method=\"POST\">\n";
    echo "<label>Angemeldeter Benutzer: " . $_SESSION['user'] . "</label>";
    echo "  <input type=\"hidden\" name=\"action\" value=\"logout\">\n";
    echo "  <button type=\"submit\">Logout</button>\n";
    echo "</form>\n";
}

// TODO: Zeige Tasks nur, falls ein Benutzer eingeloggt ist

// TODO: Zeige nur die Tasks für den eingeloggten Benutzer
if (isset($_SESSION['user'])) {
    $user = $_SESSION['user'];

    $stmt = mysqli_prepare($conn, 'select task from tasks where user = ?;');
    mysqli_stmt_bind_param($stmt, 's', $user);
    mysqli_execute($stmt);
    $res = mysqli_stmt_get_result($stmt);
    if ($res) {
        // TODO: Zeige ein Mitteilung: Liebe(r) [Name des Benutzers], dies sind Deine Aufgaben
        echo '<p>Liebe(r) ' . $user . ' Deine aktuellen Aufgaben sind:</p>';
        echo '<ul>';
        while($row = mysqli_fetch_assoc($res)) {
            echo '<li>' . $row['task'] . '</li>';
        }
        echo '</ul>';
    } else {
        echo 'Internal error: cannot fetch tasks\n'; return;
    }
}

mysqli_close($conn);
?>
    </body>
</html>