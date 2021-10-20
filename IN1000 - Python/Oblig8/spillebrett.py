import random
from celle import Celle

class Spillebrett:
    def __init__(self, rader, kolonner):
        self._rader = rader
        self._kolonner = kolonner
        self._rutenett = self._lagRuteNett()
        self._generasjonsnummer = 1
        self._generer()

    # En metode for å lage rutenettet. Denne blir kalt på i konstruktøren.
    def _lagRuteNett(self):
        rutenett = []
        for rad in range(self._rader):
            rutenett.append([])

            for kolonne in range(self._kolonner):
                rutenett[rad].append(Celle())
        return rutenett

    # Denne metoden tegner rutenettet.
    def tegnBrett(self):
        print("\n\n\n\n\n\n\n\n\n\n\n")
        for rad in range(len(self._rutenett)):
            print("\n")
            for kolonne in range(self._kolonner):
                print(self._rutenett[rad][kolonne].hentStatusTegn(), end="   ")


        # Denne metoden oppdaterer brettet i henhold til spillets regler.
    def oppdatering(self):
        listeDoed = []
        listeLevende = []

        for rad in self._rutenett:
            for celle in rad:
                # Her setter jeg to variabler med verdi 0. doedNabo har kun blitt brukt
                # til debugging av koden.
                levendeNabo = 0
                doedNabo = 0
                # her blir finnNabo kallt på med indeksene til celle-objektet
                # løkken over er på. Det blir så sjekket om naboen er levende.
                for nabocelle in self.finnNabo(self._rutenett.index(rad), rad.index(celle)):
                    if nabocelle.erLevende():
                        levendeNabo += 1
                    else:
                        doedNabo += 1
                # Her sjekker jeg om celle-objektet vi er på er levende eller død.
                # If sjekker på om cellen er levende, mens elsen fanger opp, som i
                # praksis betyr at cellen er død.
                # De blir i henhold til sjekken appendet i respektive lister.
                if celle.erLevende():
                    if levendeNabo > 3 or levendeNabo < 2:
                        listeLevende.append(celle)
                else:
                    if levendeNabo == 3:
                        listeDoed.append(celle)


        # til slutt endrer jeg her statusen på alle celle objektene i de to
        # listene.
        for celle in listeDoed:
            celle.settLevende()

        for celle in listeLevende:
            celle.settDoed()

        # og plusser generasjonsnummer med 1.
        self._generasjonsnummer += 1


    # finnAntallLevende går gjennom hele rutenettet og sjekker hvor mange
    # levende celler brettet inneholder.
    def finnAntallLevende(self):
        levendeCelle = 0
        for rad in self._rutenett:
            for celle in rad:
                if celle.erLevende():
                    levendeCelle += 1

        return levendeCelle
    # min finnNabo metode tror jeg er gjort på en tungvint måte. Her har jeg kun
    # brukt huet og gjort det jeg mente var logisk. Den fungerer som den skal!
    # Metoden inneholder 9 if-sjekker som hver sjekker det som er kommentert over
    # if-setningen. Videre blir celle-objektene lagt til i listen øverst, som til
    # slutt blir returnert.
    def finnNabo(self, rad, kolonne):
        naboliste = []
        # finnNabo kalles på med indeks mens instansvariablene til brettet blir
        # lagd som antall rader/kolonner. Mens self._rader derfor har verdien
        # (feks) 20 er den høyeste indeksen 19. Derfor måtte jeg legge til -1
        # på alle self._rader og self._kolonner.

        #ikke hjørne eller kant
        if rad > 0 and rad < self._rader-1 and kolonne > 0 and kolonne < self._kolonner-1:
            naboliste.append(self._rutenett[rad][kolonne-1])
            naboliste.append(self._rutenett[rad][kolonne+1])
            naboliste.append(self._rutenett[rad-1][kolonne])
            naboliste.append(self._rutenett[rad-1][kolonne-1])
            naboliste.append(self._rutenett[rad-1][kolonne+1])
            naboliste.append(self._rutenett[rad+1][kolonne])
            naboliste.append(self._rutenett[rad+1][kolonne-1])
            naboliste.append(self._rutenett[rad+1][kolonne+1])
            # oevre kant
        if rad == 0 and kolonne > 0 and kolonne < self._kolonner-1:
                naboliste.append(self._rutenett[rad][kolonne-1])
                naboliste.append(self._rutenett[rad][kolonne+1])
                naboliste.append(self._rutenett[rad+1][kolonne])
                naboliste.append(self._rutenett[rad+1][kolonne-1])
                naboliste.append(self._rutenett[rad+1][kolonne+1])
            # nedre kant
        if rad == self._rader-1 and kolonne > 0 and kolonne < self._kolonner-1:
                naboliste.append(self._rutenett[rad][kolonne-1])
                naboliste.append(self._rutenett[rad][kolonne+1])
                naboliste.append(self._rutenett[rad-1][kolonne])
                naboliste.append(self._rutenett[rad-1][kolonne-1])
                naboliste.append(self._rutenett[rad-1][kolonne+1])
            # venstre kant
        if kolonne == 0 and rad > 0 and rad < self._rader-1:
                naboliste.append(self._rutenett[rad][kolonne+1])
                naboliste.append(self._rutenett[rad-1][kolonne+1])
                naboliste.append(self._rutenett[rad+1][kolonne+1])
                naboliste.append(self._rutenett[rad+1][kolonne])
                naboliste.append(self._rutenett[rad-1][kolonne])
            # hoeyre kant
        if kolonne == self._kolonner-1 and rad > 0 and rad < self._rader-1:
                naboliste.append(self._rutenett[rad][kolonne-1])
                naboliste.append(self._rutenett[rad-1][kolonne-1])
                naboliste.append(self._rutenett[rad+1][kolonne-1])
                naboliste.append(self._rutenett[rad+1][kolonne])
                naboliste.append(self._rutenett[rad-1][kolonne])
            # hjoerne oppe venstre
        if rad == 0 and kolonne == 0:
            naboliste.append(self._rutenett[rad+1][kolonne])
            naboliste.append(self._rutenett[rad+1][kolonne+1])
            naboliste.append(self._rutenett[rad][kolonne+1])
            # hjoerne nede venstre
        if rad == self._rader-1 and kolonne == 0:
            naboliste.append(self._rutenett[rad-1][kolonne])
            naboliste.append(self._rutenett[rad-1][kolonne+1])
            naboliste.append(self._rutenett[rad][kolonne+1])
            # hjoerne oppe hoeyre
        if rad == 0 and kolonne == self._kolonner-1:
            naboliste.append(self._rutenett[rad+1][kolonne])
            naboliste.append(self._rutenett[rad+1][kolonne-1])
            naboliste.append(self._rutenett[rad][kolonne-1])
            # hjoerne nede hoeyre
        if rad == self._rader-1 and kolonne == self._kolonner-1:
            naboliste.append(self._rutenett[rad-1][kolonne])
            naboliste.append(self._rutenett[rad-1][kolonne-1])
            naboliste.append(self._rutenett[rad][kolonne-1])

        # denne ble lagt inn som hjelp for meg selv.
        if len(naboliste) < 3 or len(naboliste) > 8:
            print("Noe er feil!")


        return naboliste

        # Denne metoden går igjennom rutenettet og gir hvert celle objekt 1/3
        # sjanse for å være levende. Denne blir kun kallt på én gang, og det er
        # i opprettelsen av spillebrettet. 
    def _generer(self):
        for rad in  self._rutenett:
            for celle in rad:


                tall = random.randint(0,2)
                if tall == 0:
                    celle.settLevende()
