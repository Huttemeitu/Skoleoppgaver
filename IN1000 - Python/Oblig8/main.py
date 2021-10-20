from spillebrett import Spillebrett

# Hovedprogrammet består hovedsaklig av en while-løkke som kjører så lenge bruker
# ikke taster inn "q". Brettet blir oppdatert for hver gang løkken kjører.
# videre inneholder main utskriftsvennlige setninger som hjelper brukeren med
# "spillet". Jeg har kuttet ned på så mye som mulig av tekst inne i while løkken
# for at utskriftene skal bli behagelig for øynene dersom man ønsker å holde inne
# enter knappen!
def main():
    inputRad = input("Hvor mange rader oensker du? ")
    inputKolonne = input("Hvor mange kolonner oensker du? ")
    spillebrett = Spillebrett(int(inputRad),int(inputKolonne))

    spillebrett.tegnBrett()

    print("\n")
    print("Generasjonsnummer: ",spillebrett._generasjonsnummer, " - ", "Levende celler: ", spillebrett.finnAntallLevende())

    inp = ""
    while inp != "q":
        inp = input("Trykk enter for aa fortsette. Tast inn q om du vil avslutte. ")
        if inp != "q":
            spillebrett.oppdatering()
            spillebrett.tegnBrett()
            print("\n")
            print("Generasjonsnummer: ",spillebrett._generasjonsnummer, " - ", "Levende celler: ", spillebrett.finnAntallLevende())






# starte hovedprogrammet
main()
