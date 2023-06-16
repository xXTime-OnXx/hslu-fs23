<!DOCTYPE html>
<html>

<head>
    <title>Reiseplanungs Antrag</title>
    <meta charset="utf8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
    <main class="w3-container">
        <?php
        function IsNullOrEmptyString($str) {
            return ($str === null || trim($str) === '');
        }
        function isValidEmail($email) {
            $emailPattern = '/^[\w\-\.]+@([\w\-]+\.)+[\w\-]{2,4}$/i';
            return preg_match($emailPattern, $email);
        }
        function isValidStartDate($date) {
            $validDate = date_create();
            date_add($validDate, date_interval_create_from_date_string("7 days"));
            return $date >= date_format($validDate, 'Y-m-d');
        }
        function isValidEndDate($startDate, $endDate) {
            return $endDate > $startDate;
        }

        $hostname = 'localhost';
        $username = 'root';
        $password = '';
        $database = 'travel_agency';

        $conn = mysqli_connect($hostname, $username, $password, $database);
        if (!$conn) {
            die('Database connection failed');
        }

        $firstname = $_POST['firstname'];
        $lastname = $_POST['lastname'];
        $email = $_POST['email'];
        $destination = $_POST['destination'];
        $startDate = $_POST['startDate'];
        $endDate = $_POST['endDate'];

        if (isNullOrEmptyString($firstname)) {
            die('Der Vorname darf nicht leer sein');
        }
        if (isNullOrEmptyString($lastname)) {
            die('Der Nachname darf nicht leer sein');
        }
        if (!isValidEmail($email)) {
            die('Die Email ist ungültig');
        }
        if (isNullOrEmptyString($destination) || strlen($destination) < 5) {
            die('Die Beschreibung der Destination ist zu kurz');
        }
        if (!isValidStartDate($startDate)) {
            die('Das Start Datum muss mindestens 7 Tage in der Zukunft liegen');
        }
        if (!isValidEndDate($startDate, $endDate)) {
            die('Das ende Datum muss nach dem start Datum sein');
        }
        
        $firstname = mysqli_real_escape_string($conn, $firstname);
        $lastname = mysqli_real_escape_string($conn, $lastname);
        $email = mysqli_real_escape_string($conn, $email);
        $destination = mysqli_real_escape_string($conn, $destination);
        $startDate = mysqli_real_escape_string($conn, $startDate);
        $endDate = mysqli_real_escape_string($conn, $endDate);

        $query = 'INSERT INTO travel_plan (firstname, lastname, email, destination, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)';
        $stmt = mysqli_prepare($conn, $query);
        mysqli_stmt_bind_param($stmt, 'ssssss', $firstname, $lastname, $email, $destination, $startDate, $endDate);

        $statementExecuted = mysqli_stmt_execute($stmt);
        if (!$statementExecuted) {
            die('Statement execution failed');
        }
        mysqli_close($conn);

        echo '<h2>Ihr Reiseplanungs Antrag wurde erfolgreich erstellt</h2>';
        echo '<h3>Reiseplanung:</h3>';
        echo '<p>Name: ' . $firstname . ' ' . $lastname . '</p>';
        echo '<p>E-Mail: ' . $email . '</p>';
        echo '<p>Destination: ' . $destination . '</p>';
        echo '<p>Dauer: ' . $startDate . ' - ' . $endDate . '</p>';

        ?>
        <a href="travelAgency.html">Zurück zur Website</a>
    </main>
</body>

</html>