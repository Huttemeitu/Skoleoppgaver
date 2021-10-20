# coding=<Python>

# Dette programmet følger oppskriften for oblig 1.

# 1. Her skrev jeg først ut "Hei student" i linje 12.
# Dette ble endret i deloppgave 2.
# Jeg formet om utskriften til å ta med en input fra bruker, som en variabel.
# Variabelen heter "navn" og står på linje 10.

navn = input("Skriv navnet ditt her:\n> ")

print("Hei", navn + "!" )

# 3. Her har jeg laget to heltallsvariabler.
# En tredje variabel er laget som er direkte avhengig av de to første.
heltall1 = 10
heltall2 = 5
heltall3 = heltall1-heltall2

# Denne blir printet ut til bruker med en tekststreng foran.
print("Differanse:", heltall3)

# Etterfulgt av differansen ber jeg så om en ny input fra bruker.
# Den nye inputen er fremstilt som variabelen "navn2"
# Her er det også lagt inn en tekststreng.
navn2 = input("Oppgi et nytt navn her:\n> ")

# En til variabel blir laget ved navn "sammen".
# Denne variabelen har verdien av de to tidligere inputene sammen.
# Denne blir så skrevet ut.
sammen = (navn + navn2)
print(sammen)

# Her endrer jeg variabelen "sammen"
# Jeg la også inn tekstrenger for både "og" og mellomrom.
# Dette gjør at outputen blir bedre å se på.
sammen = (navn + " " "og" " " + navn2)
print(sammen)
