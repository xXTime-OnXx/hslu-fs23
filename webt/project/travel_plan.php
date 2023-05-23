<!DOCTYPE html>
<html>

<head>
    <title>Berechneter Gesamtwiderstand</title>
    <meta charset="utf8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
    <?php
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

    // TODO: validation

    $firstname = mysqli_real_escape_string($conn, $firstname);
    $lastname = mysqli_real_escape_string($conn, $lastname);
    $email = mysqli_real_escape_string($conn, $email);
    $destination = mysqli_real_escape_string($conn, $destination);
    $startDate = mysqli_real_escape_string($conn, $startDate);
    $endDate = mysqli_real_escape_string($conn, $endDate);

    $query = "INSERT INTO travel_plan (firstname, lastname, email, destination, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";
    $stmt = mysqli_prepare($conn, $query);
    mysqli_stmt_bind_param($stmt, 'ssssss', $firstname, $lastname, $email, $destination, $startDate, $endDate);

    $statementExecuted = mysqli_stmt_execute($stmt);
    if (!$statementExecuted) {
        die ("Statement execution failed");
    }

    // TODO: create response with form data

    ?>
    <a href="travelAgency.html">Zurück zur Website</a>
</body>

</html>