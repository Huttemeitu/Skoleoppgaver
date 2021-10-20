# Dette programmet holder styr på ønsket antall motorsykler.
# Den lagrer merke, registreringsnummer og kilometerstand.

# Klassen blir dannet.
class Motorsykkel:
    def __init__(self, merke, reg, kilometer ):
        self._merke = merke
        self._reg = reg
        self._km = kilometer
    # Her lages en metode som gjør at vi kan øke kilometerstanden.
    def kjor(self,km):
        self._km += km
    # Denne metoden er egnet for å senere kunne skrive ut eller gjøre
    # beregninger med kilometerstanden
    def hentKilometerstand(self):
        return self._km
    # Den siste metoden er laget for å kunne skrive ut infoen om syklene. 
    def skrivUt(self):
        print(self._merke)
        print(self._reg)
        print(self._km)
