<!DOCTYPE html>
<html>

<head>
    <meta charset="utf8">
    <title>Pizzaparadies - Webshop</title>
</head>

<body>       
    <?php    
    if (!isset($_GET['pizza']) || !isset($_GET['price']) ) {
        echo "<p>Parameter 'pizza' and 'price' are required.</p></body></html>"; return;
    }
    ?>

    <h3>Pizza <?php echo $_GET['pizza']?></h3>
    <form action="pizza.php" method="POST">
        <p>Preis pro Pizza: CHF <?php echo  number_format($_GET['price'], 2, '.', ''); ?></p>
        <fieldset>            
            <legend>Bestellen:</legend>
            <label for="anzahl">Anzahl:</label>
            <input name="anzahl" type="number" size="3" value="1">
            <input name="pizza" type="hidden" value="<?php echo $_GET['pizza']; ?>">
            <button type="submit">In den Warenkorb</button>
        </fieldset>
        
    </form>
</body>

</html>