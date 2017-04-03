# ORFviewer
ORF Finder informatica project course 7a

Auteurs:  -Tim van de Kerkhof
          -Jasper de Meijer

Implementatie van het ontwerp:
  Database:
    Ivm tijd en de complexiteit van het verbinden met de database en data ophalen/wegschrijven is er voor gekozen een versimpelde versie van de ontworpen database te maken. In deze versimpeld versie is normalisering buiten beschouwing gelaten.
  Per class:
    -FileHandler:
      FileHandler voldoet aan het ontwerp behalve het de inhoud van het bestand returned in een arraylist ipv een string. Dit is gedaan ivm de structuur van een fasta bestand die niet in stand viel te houden met behulp van een string en wel met een arraylist

    -SequenceTranscriptor:
      Wijkt af van het ontwerp. De class maakt niet alleen gebruik van 2 strings, maar ook een HashMap. Ipv een functie voor het vertalen wordt er een getter gebruikt om values uit de codon hashmap te halen.

    -DataExporter:

    -DataImporter:

    -ORFPredictor:





Known bugs:
none
