## Widgets von Swing:
* Gridlayout
* JButton
* JFrame / JDialog mit Modal option
* JTextfield
* JFormatedTextfield
* JLabel

## Was geschieht im Programm:
* Öffnen den Layer
* Preis abfragen: _vorstellung.getPreisFuerPlaetze(plaetze);
* Eingabefeld erlaubt nur Ints (Zahlen)
* Differenz wird auf Eingabe berechnet
* Differenz aktualisiert
* Bei Klick auf OK wird verkaufePlaetze aufgerufen und das Fenster geschlossen - OK nur aktiv, wenn Differenz >= 0
* Bei Klick auf Abbrechen wird das Fenster geschlossen, und die Ausgewählten Plätze zurückgesetzt

## Soll es während des Bezahlvorganges möglich sein das restliche UI zu verwenden?
* Nein, dafür müssen allerdings die Observer auch während das Fenster offen ist den Preis aktualisieren können und darauf hin die Differenz neu Berechnen (PlatzSelectionListener)

## Wie werden Geldeinheiten Präsentiert?
In Eurocent / Integer