# Projekt-Dokumentation


## Informieren

### User Stories

| US-№ | Verbindlichkeit | Art          | Beschreibung                                                       |
| ---- | --------------- | ------------ | ------------------------------------------------------------------|
| 0    | Muss            | Funktional   | Als ein Besucher muss ich in der Lage sein, das APK zu öffnen. |
| 1    | Muss            | Funktional   | Als ein Besucher kann ich Prüfungstermine erstellen. |
| 2    | Muss            | Funktional   | Als ein Besucher kann ich Noten hinzufügen und den Notenschnitt sehen. |
| 3    | Muss            | Funktional   | Als ein Besucher habe ich Zugriff auf relevante Links zur Kantibaden. |
| 4    | Muss            | Funktional   | Als ein Besucher kann ich alle Einträge löschen. |
| 5    | Kann            | Qualitativ   | Als ein Besucher kann ich Darkmode/Lightmode toggeln. |




### 1.3 Testfälle

| Testfall-Nummer | Ausgangslage                                                                  | Eingabe                                  | Erwartete Ausgabe                                                     |
| --------------- | ----------------------------------------------------------------------------- | ---------------------------------------- | --------------------------------------------------------------------- |
| 0.1             | Der Besucher öffnet das Programm.                      | Programm öffnen.    | Kalendermenü wird angezeigt.    |
| 0.2             | Der Besucher wechselt zwischen Menüs.                    | Klick auf die Schaltflächen der Navigationsbar                 | Entsprechende Menü wird gewechselt.                 |
| 1.1             | Der Besucher erstellt einen Prüfungstermin.                    | Klick auf "+" Schaltfläche im Kalender-Menü. | Dialog zur Erstellung wird angezeigt. |
| 1.2             | Der Besucher gibt Name und Fach ein.                      | Klick auf Textinput.                      | Tastatur wird geöffnet.     |
| 1.3             | Der Besucher wählt Datum aus.                               | Klick auf "Datum auswählen".                                           | Kalenderdialog wird geöffnet.                                           |
| 1.4             | Der Besucher fügt einen Prüfungstermin in der Liste ein.                                          | Klick auf "Hinzufügen".                                           | Neue Prüfungstermin wird im Menü angezeigt.                                  |
| 2.1             | Der Besucher fügt eine Note ein.                    | Klick auf "+" Schaltfläche im Noten-Menü. | Dialog zur Erstellung wird angezeigt. |
| 2.2             | Der Besucher gibt Name, Fach und Note ein.                      | Klick auf Textinput.                      | Tastatur wird geöffnet.     |
| 2.3             | Der Besucher gibt eine ungültige Note ein.                               | Textinput ausserhalb 1 - 6 Spektrum                                           | Fehlermeldung wird angezeigt.                                           |
| 2.4             | Der Besucher fügt eine Note in der Liste ein.                                          | Klick auf "Hinzufügen".                                           | Neue Note wird im Menü angezeigt, alle vorhandene Noten werden berechnet, Gesamtdurchschnitt wird angezeigt.                                  |
| 3.1             | Der Besucher öffnet Links.                                          | Klick auf die Schaltflächen im Links-Menü                                           | Browser mit dem entsprechenden Link wird geöffnet.                                  |
| 4.1             | Der Besucher konvertiert/komprimiert/dekomprimiert eine existierende Output                                          | Klick auf Aktion                                           | Fehlermeldung wird angezeigt.                                  |
| 4.2             | Der Besucher konvertiert/komprimiert/dekomprimiert eine ungültige Datei                                          | Klick auf Aktion                                           | Fehlermeldung wird angezeigt.                                  |


## 2 Planen

| AP-№ | Zuständig | Beschreibung                            | Geplante Zeit | Frist        |
| ---- | --------- | --------------------------------------- | ------------- | ------------ |
| 0.0  | Raviraj   | Erstellung der Projektdokumentation    | 2 Stunden     | 22.12.2023   |
| 1.A  | Raviraj   | Design und Umsetzung des Kalender-Menü     | 6 Stunden     | 22.12.2023   |
| 1.B  | Raviraj   | Design und Umsetzung des Noten-Menü  | 6 Stunden | 22.12.2023   |
| 1.C  | Raviraj   | Design und Umsetzung des Links-Menü | 4 Stunden | 22.12.2023   |
| 1.D  | Raviraj   | Design und Umsetzung des Einstellungen-Menü | 4 Stunden | 22.12.2023   |
| 2.A  | Raviraj   | Darkmode-Funktion        | 2 Stunden     | 23.02.2024   |
| 3.A  | Raviraj   | Funktion, um alle Einträge zu löschen    | 2 Stunden     | 22.12.2023   |
| 4.A  | Raviraj   | Erstellung eines Portfolioeintrags       | 2 Stunden     | 22.12.2023   |




## 3 Entscheiden

Keine

## 4 Realisieren

| AP-№ | Zuständig | Geplante Zeit | Tatsächliche Zeit | Datum      |
| ---- | --------- | ------------- | ----------------- | ---------- |
| 0.0  | Raviraj   | 2 Stunden      | 2 Stunden         | 10.11.2023 |
| 1.A  | Raviraj   | 6 Stunden      | 10 Stunden        | 10.11.2023 |
| 1.B  | Raviraj   | 6 Stunden      | 8 Stunden         | 17.11.2023 |
| 1.C  | Raviraj   | 4 Stunden      | 2 Stunden         | 24.11.2023 |
| 1.D  | Raviraj   | 4 Stunden      | 2 Stunden         | 01.12.2023 |
| 2.A  | Raviraj   | 2 Stunden      | 4 Stunden         | 08.12.2023 |
| 3.A  | Raviraj   | 2 Stunden      | 6 Stunden         | 15.12.2023 |
| 4.A  | Raviraj   | 2 Stunden      | 2 Stunden          | 22.12.2023 |




## 5 Kontrollieren

### 5.1 Testprotokoll

| Testfall-№ | Resultat | Tester  | Datum     |
| -----------| ---------| --------| ----------|
| 0.1        | OK       | Raviraj | 12.01.2024|
| 0.2        | OK       | Raviraj | 12.01.2024|
| 1.1        | OK       | Raviraj | 12.01.2024|
| 1.2        | OK       | Raviraj | 12.01.2024|
| 1.3        | OK       | Raviraj | 12.01.2024|
| 1.4        | OK       | Raviraj | 12.01.2024|
| 2.1        | OK       | Raviraj | 12.01.2024|
| 3.1        | OK       | Raviraj | 12.01.2024|
| 3.2        | OK       | Raviraj | 12.01.2024|
| 3.3        | OK       | Raviraj | 12.01.2024|
| 3.4        | OK       | Raviraj | 12.01.2024|
| 4.1        | OK       | Raviraj | 12.01.2024|
| 4.2        | OK       | Raviraj | 12.01.2024|






