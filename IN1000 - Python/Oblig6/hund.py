# Dette programmet lager en klasse hvor man kan holde styr på hunde-objekter.

# Klassen defineres og instansvariabler dannes.
class Hund:
    def __init__(self, alder, vekt):
        self._alder = alder
        self._vekt = vekt
        self._metthet = 10
# Disse to metodene gjør det mulig å hente ut alder og vekt fra klassen.
    def skrivAlder(self):
        return self._alder

    def skrivVekt(self):
        return self._vekt
# Disse to metodene endrer på instansvariablenes verdi. 
    def spring(self):
        self._metthet -= 1
        if self._metthet < 5:
            self._vekt -= 1


    def spis(self, heltall):
        self._metthet += heltall
        if self._metthet > 7:
            self._vekt += 1
