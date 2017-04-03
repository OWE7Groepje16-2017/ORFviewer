# ORFFinder
ORF Finder informatica project course 7a

  
Auteurs:  
-Tim van de Kerkhof          
-Jasper de Meijer

Functionaliteit ORFFinder:

    Het programma is in staat om een .FASTA bestands formaat in te laden met meerdere headers en DNA sequenties.
    Vervolgens kan het programma de ingeladen sequenties analyseren op alle mogelijke ORF's in alle mogelijke RF's.
  
    De ingeladen sequenties kunnen per header gevisualiseert worden en worden direct vertaalt naar een AA sequentie 
    (deze wordt ook gevisualiseert). De gebruiker kan per header (deze kan geselecteerd worden dmv een dropdown menu)
    de ORF's visualiseren.
  
    Het is mogelijk om de gevonden resultaten te exporteren naar een database. Deze database staat op de server: xirect.nl
    Het is ook mogelijk om opgeslagen resultaten op te halen uit de database en deze te visualiseren.


Implementatie van het ontwerp:

  Database:
  
    Ivm tijd en de complexiteit van het verbinden met de database en data ophalen/wegschrijven is er voor gekozen een versimpelde versie van de ontworpen database te maken. 
    In deze versimpeld versie is normalisering buiten beschouwing gelaten.
    
  Per class:
  
    FileHandler:
    
      FileHandler voldoet aan het ontwerp behalve het de inhoud van het bestand returned in een arraylist ipv een string. 
      Dit is gedaan ivm de structuur van een fasta bestand die niet in stand viel te houden met behulp van een string en wel met een arraylist

    SequenceTranscriptor:
    
      Wijkt af van het ontwerp. 
      De class maakt niet alleen gebruik van 2 strings, maar ook een HashMap. 
      Ipv een functie voor het vertalen wordt er een getter gebruikt om values uit de codon hashmap te halen.

    DataExporter:
    
      Wijkt af van het ontwerp.
      toegevoegd: methode getConnection om connectie te maken aan de database
      verwijderd: exportFile, exportBlast. deze functies zijn niet langer relevant voor de applicatie

    DataImporter:
      Wijkt af van het ontwerp:
      toegevoegd: methode getConnection om connectie te maken aan de database.

    ORFPredictor:
      Wijkt af van het ontwerp:
      toegevoegd: getters & setters voor de private fields, de functie ORFbuilder en de functie makeComplementary
      visualizeImport is meegenomen met de functie predictORF





Known bugs:

          none
