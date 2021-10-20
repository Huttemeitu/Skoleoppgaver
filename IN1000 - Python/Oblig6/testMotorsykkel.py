# Klassen blir importert
from motorsykkel import Motorsykkel


def hovedprogram():
    # Her lages objektene.
    sykkel1 = Motorsykkel("BMW", "DN73502", 10000)
    sykkel2 = Motorsykkel("Ducati", "ST84375", 20000)
    sykkel3 = Motorsykkel("Yamaha", "YT64026", 30000)

    # Informasjonen om syklene printes ut, samt er det lagt inn noen
    # print-setninger for å gjøre det oversiktlig i outputen.
    sykkel1.skrivUt()
    print(" ")
    sykkel2.skrivUt()
    print(" ")
    sykkel3.skrivUt()
    print(" ")
    sykkel3.kjor(10)
    print(sykkel3.hentKilometerstand())
# Til slutt kaller vi på hovedprogrammet.
hovedprogram()
