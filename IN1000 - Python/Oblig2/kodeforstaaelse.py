# 1.
# Nei, dette er ikke lovlig kode. På andre linje blir inputen konvertert
# fra tekststreng til heltall. Dette gjøres ved å lage en ny variable med navn "b".
# Denne variablen "b" har verdien til a konvertert til heltall. Det betyr at ved
# all bruk av variabelen "b" senere vil det være en heltallsverdi.
# Det er ikke muig å plusse en streng og et heltall. Derfor vil ikke printen
# kjøres ut.

# Det er flere måter å endre koden på for å få den til å fungere.
# Vedlagt ligger en annen måte å skrive koden på. Her konverterer vi fra tekst til heltallsverdi
# kun ved beregningen istedet. Dette gjør at verdien a fortsatt har en tekstverdi.
# Det gjør at den samme variabelen "a" kan brukes i printen i siste setning uten problemer.
# en annen løsning ville vært å heller skrive "print(a + "Hei!")". Her vil print
# hente tekstverdien fra variabelen "a" istedet.

a = input("Tast inn et heltall! ")
b = int(a)
if b < 10:
    print (b + "Hei!")

# 2.
# Ved kjøring av koden vil vi få en feilmelding som sier at vi ikke kan plusse
# en tekststreng med et heltall.


"""
a = input("Tast inn et heltall! ")

if int(a) < 10:
    print (a + "Hei!")
"""
