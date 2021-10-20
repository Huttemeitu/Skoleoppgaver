# Klassen blir importert
from hund import Hund

def hovedprogram():
# Her lages hundeobjektet
    hund1 = Hund(2,35)
# Jeg kaller på de to metodene spis og spring og printer ut vekten mellom hver gang.
    print("Hundens vekt er: ", hund1.skrivVekt())
    hund1.spring()
    print("Hundens vekt er: ", hund1.skrivVekt())
    hund1.spring()
    hund1.spis(2)
    print("Hundens vekt er: ", hund1.skrivVekt())
    hund1.spring()
    print("Hundens vekt er: ", hund1.skrivVekt())
    hund1.spis(3)
    print("Hundens vekt er: ", hund1.skrivVekt())
    # Her kan man se hvordan vekten forandres ettersom hunden spiser og springer.

# Til slutt kaller jeg på hovedprogrammet.
hovedprogram()
