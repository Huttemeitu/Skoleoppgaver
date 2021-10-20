# Programmet lager en klasse Sang som anvendes i de nedlastbare testprogrammene.

# Konstruktør
class Sang:
    def __init__(self, artist, tittel):
        self._tittel = tittel
        self._artist = artist

    # metoden spill "spiller av" objektet metoden blir kalt på med.
    def spill(self):
        print("Spiller: "+self._artist+" - "+self._tittel)
    # sjekkArtist sjekker om argumentet (i dette tilfellet navn) finnes i
    # self._artist. Den returnerer eller False.
    def sjekkArtist(self, navn):
        for i in navn.split():
            if i in self._artist.split():
                return True
        return False
    # Metoden sjekkTittel tar inn en tittel som argument og sjekker om denne er
    # lik self._tittel
    def sjekkTittel(self, tittel):
        if tittel.lower() == self._tittel.lower():
            return True
        return False
    # sjekkArtistOgTittel sjekker om sjekkArtist og sjekkTittel er True, og
    # returnerer isåfall True. Ellers False
    def sjekkArtistOgTittel(self, artist, tittel):
        if self.sjekkArtist(artist) == True and self.sjekkTittel(tittel) == True:
            return True
        return False
