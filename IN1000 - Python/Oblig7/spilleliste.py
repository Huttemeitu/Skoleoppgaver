# Dette programmet lager en klassen Spilleliste som importerer klassen Sang,
# og tar i bruk metodene og objekter av klassen Sang.

# Dette er kopiert inn.
from sang import Sang

class Spilleliste:
    def __init__(self, listenavn):
        self._sanger = []
        self._navn = listenavn
    # Metoden lesFraFil tar inn et filnavn og danner en liste av Sang-objekter basert
    # på filens innhold.
    def lesFraFil(self, filnavn):
        fil = open(filnavn)
        for linje in fil:
            alleData = linje.strip().split(';')
            sang = Sang(alleData[1],alleData[0])
            self._sanger.append(sang)

        fil.close()


    # leggTilSang tar inn et nytt sang-objekt som parameter og legger dette
    # objektet til i _sanger.
    def leggTilSang(self, nySang):
        self._sanger.append(nySang)
    # fjernSang tar inn et sang-objekt og fjerner sangen om den finner sangen i
    # listen.
    def fjernSang(self, sang):
        if sang in self._sanger:
            self._sanger.remove(sang)
        else:
            return "Sang ikke funnet."
    # spillSang tar inn et sang objekt og kaller på metoden spill fra klassen Sang.
    def spillSang(self, sang):
        sang.spill()
    # spillAlle vil med en for-løkke kalle på spill med alle objektene som ligger
    # i spillelisten.
    def spillAlle(self):
        for i in self._sanger:
            i.spill()
    # finnSang tar inn en tittel som argument og sjekker kaller på sjekkTittel
    # for å sjekke om tittelen du sendte med er lik en av sangene i spillelisten.
    # Hvis den finner sangen returneres sang-objektet.
    def finnSang(self, tittel):
        for i in self._sanger:
            if i.sjekkTittel(tittel):
                return i
        return None
    # hentArtistUtvalg tar inn et artistnavn. Den går så gjennom alle objektene i
    # spillelisten ved hjelp av en for-løkke. Så kaller den på sjekkArtist med
    # artistnavn som argument. Hvis sjekkArtist returnerer True vil listen som
    # er laget i starten av metoden bli tilført sang-objektet. Metoden
    # returnerer så listen over sang-objektene.
    def hentArtistUtvalg(self, artistnavn):
        ArtistUtvalg = []
        for i in self._sanger:
            if i.sjekkArtist(artistnavn):
                ArtistUtvalg.append(i)

        return ArtistUtvalg
