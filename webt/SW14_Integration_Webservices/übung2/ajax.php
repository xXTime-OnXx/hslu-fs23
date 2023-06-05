<?php

$attraktionen = [ "Freiburger Münster", "Kunsthaus Zürich", "Schloss Rapperswil" ];

$attraktionen_infos = [
	"Freiburger Münster" => [
				"text" => "Jeden Besucher Freiburgs zieht es sofort zum Münster, sobald er 
							über den Dächern der 
							Altstadt die durchbrochene Pyramide des schlanken Turms erblickt",
				// DONE: Array um Bild ergänzen
				"bild" => "img/freiburg.jpg"
	],
							
	"Kunsthaus Zürich" => [
				"text" => "Stetig wechselnde Ausstellungen mit hochqualitativen Meisterwerken 
	                       aus aller Welt. 
	                       Jedes Jahr mit vielen Grossereignissen wie die aufregende und 
						   kontroverse Cindy Sherman-Ausstellung",
				// DONE: Array um Bild ergänzen
				"bild" => "img/zuerich.jpg"
	],
	
	"Schloss Rapperswil" => [
				"text" =>   "Es ist ein besonderer Ort, an dem man die hektische Welt 
							ausserhalb der dicken Schlossmauern schnell vergisst. Konzerte 
							geniessen, frischer Kaffeeduft, ...",
				// DONE: Array um Bild ergänzen
				"bild" => "img/rapperswil.jpg"
	]
 
	];

	function getAttractionList() {
		global $attraktionen;
		
		echo json_encode($attraktionen);		
	}

	function getAttractionInfo() {
		global $attraktionen;
		global $attraktionen_infos;

		if (isset($_GET['attraktion'])) {
			$attraktion = $_GET['attraktion'];
			
			if (isset($attraktionen_infos[$attraktion])) {
				echo json_encode($attraktionen_infos[$attraktion]);					
			} else {
				echo "Fehler: Attraktion '" . $attraktion . "' nicht bekannt";
			}

		} else {
			echo "Fehler: Aktion 'info' benötigt Parameter 'attraktion'";
		}
	}
	
	if (isset($_GET['action'])) {
		$action = $_GET['action'];

		if ($action == "list") {
			getAttractionList();
		} else if ($action == "info") {			
			getAttractionInfo();
		} else {
			echo "Fehler: unbekannte Aktion: '" . "'";
		}
	} else {
		echo "Fehler: Parameter 'action' nicht gesetzt";
	}
?>