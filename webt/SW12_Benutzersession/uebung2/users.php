<?php

// Beispielimplementierung von Benutzerkonten in PHP
//
// Hinweis: Dies ist ein Schulbeispiel, welches die elementare Funktionsweise
// von Benutzerkonton in PHP demonstriert. Diese Implementierung ist nicht
// für einen produktiven Betrieb geeignet (beispielsweise sind
// Fehlerrückmeldungen nicht vollständig implementiert).

// Die Funktionen übernehmen jeweils den Parameter $conn. Dieser muss auf
// eine geöffnete MySQL-Datenbankverbindung zeigen. Auf dieser Datenbank muss
// die Tabelle users, wie in der Datei schema.sql angegeben, existieren.

// globale Einstellungen
$options = [ 'cost' => 10 ]; // Kosten für Berechnung des Hashes

// gibt den Hash für Benutzer $user zurück
// oder null, falls der Benutzer nicht existiert
function password_db_query($conn, $user) {

    // frage den Hash für einen bestimmten Benutzer ab
    $query = "select hash from users where login = ?;";
    $stmt = mysqli_prepare($conn, $query);
    mysqli_stmt_bind_param($stmt, 's', $user);
    mysqli_stmt_execute($stmt);
    $res = mysqli_stmt_get_result($stmt);  

    if ($res) {
        // unique key: nur ein Eintrag, daher if anstelle von while
        if ($row = mysqli_fetch_assoc($res)) {
            mysqli_free_result($res);
            return $row['hash'];
        }
    }
    return null;
}

// setzt den Hash von $user auf den neuen Wert $newHash
function password_db_update($conn, $user, $newHash) {
    $query="update users set hash = ? where login = ?;";
    $stmt = mysqli_prepare($conn, $query);
    mysqli_stmt_bind_param($stmt, 'ss', $user, $newHash);
    return mysqli_stmt_execute($stmt);
}

// füge $user mit $hash in DB ein:
// gibt false zurück $user bereits existiert, sonst true.
function password_db_insert($conn, $user, $hash) {
    $query = "insert into users (login, hash) values (?, ?);";
    $stmt = mysqli_prepare($conn, $query);
    mysqli_stmt_bind_param($stmt, 'ss', $user, $hash);
    return mysqli_stmt_execute($stmt);
}

// registriere Benutzer $user mit Passwort $pass
// gibt false zurück $user bereits existiert, sonst true.
function register($conn, $user, $pass) {

    // berechne den Hash für das Passwort
    global $options;
    $hash = password_hash($pass, PASSWORD_DEFAULT, $options);

    // füge das Passwort in die Benutzerdatenbank ein 
    $res = password_db_insert($conn, $user, $hash);
    if (!$res) {
        echo "Benutzer '" . $user . "' existiert bereits";
    }

    return $res;
}

// verknüpft Benutzer mit Login $user und Passwort $pass
// mit der aktuellen Benutzersession, falls Logindaten korrekt sind.
// gibt false zurück falls $user nicht existiert oder $pass falsch ist, sonst true.
function login($conn, $user, $pass) {

    // abfragen und prüfen des Hashes
    $hash = password_db_query($conn, $user);
    if (!password_verify($pass, $hash)) {
        echo "Benutzer existiert nicht oder falsches Passwort";
        return false;
    }

    // Wartungsoperation (Hashfunktion oder deren Parameter ändern)
    global $options;
    if (password_needs_rehash($hash, PASSWORD_DEFAULT, $options)) {
        $newHash = password_hash($pass, PASSWORD_DEFAULT, $options);
        password_db_update($conn, $user, $newHash);
    }

    // verknüpfen mit Benutzersession
    $_SESSION['user'] = $user;

    return true;
}

function logout() {
    // lösche Sessionvariablen und das Sessioncookie, dann löse die Session auf
    $_SESSION = [];
    setcookie(session_name(), "", time() - 3600, "/");
    session_destroy();
}

?>