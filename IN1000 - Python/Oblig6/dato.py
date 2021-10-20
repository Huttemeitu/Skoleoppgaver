# Dette programmet tar inn et dato-objekt for å så kunne gjøre forskjellige
# handlinger med den.

# klassen blir definert.
class Dato:
    # konstruktøren lages.
    def __init__(self, nyDag, nyMaaned, nyttAar):
        self._dag = nyDag
        self._maaned = nyMaaned
        self._aar = nyttAar

    # Denne metoden leser av året på datoen.
    def lesAar(self):
        return self._aar
    # Denne metoden lager en utskiriftsvennlig versjon av datoen.
    # I tillegg la jeg til en if sjekk som legger til "0" før tallet
    # på både måned og dag hvis det består av ett siffer. Dette gjør det
    # mer utskiriftsvennlig.
    def skrivUt(self):
        if len(str(self._dag)) == 1:
            self._dag = "0"+str(self._dag)
        if len(str(self._maaned)) == 1:
            self._maaned = "0"+str(self._maaned)
        return str(self._dag) + "." + str(self._maaned) + "." + str(self._aar)
    # Her trenger jeg et til parameter. Denne metoden sjekker så om dagen
    # er det samme som argumentet man sender inn når man kaller på denne metoden.
    # Dette gjør at man kan sjekke om datoen er på en spesiell dag i måneden. 
    def dag(self, dag):
        if self._dag == dag:
            return True
