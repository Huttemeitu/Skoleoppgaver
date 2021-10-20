# Dette programmet lager både brukernavn og eposter utifra inputene:
# Fullt navn og epost-suffix.

brukernavn = {}

# Denne funksjonen tar inn et navn, setter alt til små bokstaver, og
# lager et brukernavn fra navnet bestående av fornavn og første bokstav i etternavn.
def lagBrukernavn(navn) :
    navn_low = navn.lower()
    navnliste = navn_low.split()
    # list funksjonen bruker jeg her for å dele opp etternavnet.
    # Jeg kan deretter hente ut element 1 i denne listen, som her tilsvarer
    # første bokstav i etternavnet.
    etternavn = list(navnliste[1])
    brukernavnet = navnliste[0]+etternavn[0]
    # brukernavnet blir returnert.
    return brukernavnet
# Her blir brukernavnet printet ut til bruker.
print(lagBrukernavn(input("Skriv inn navnet ditt(Fornavn og etternavn): ")))

# Denne funksjonen tar inn et brukernavn og en epost suffix.
# Deretter lager den en epost-adresse basert på disse to.
def lagEpost(brukernavnet, suffix) :
    epost = brukernavnet+"@"+suffix
    return epost
# Denne blir printet ut i terminalen.
print(lagEpost(input("Skrv inn brukernavnet ditt: "), input("Skrv inn suffix: ")))

ordboktest =  {"olan": "ifi.uio.no", "karian":
"student.matnat.uio.no"}
# Jeg lager så en prosedyre printEposter som tar inn en ordbok som argument.
def printEposter(ordbok) :
    brukernavn_liste = list(ordbok)
    suffix = ordbok.values()
    suffix_liste = list(suffix)
    for x in range(0,len(ordbok)):
        epost = lagEpost(brukernavn_liste[x], suffix_liste[x])
        print(epost)
# Denne funksjonen testes med ordboktest.
printEposter(ordboktest)



# Her lager jeg en while løkke for å har tre funksjoner.
# s avslutter programmet, i legger til en epost, og p printer ut epostene.
inp = None
while inp != "s" :
    inp = input("Skriv inn en streng: ")
    if inp == "i" :
        navn = input("Skriv inn navn og etternavn: ")
        suffix = input("Skriv inn en suffix: ")
        brukernavn1 = lagBrukernavn(navn)
        brukernavn[brukernavn1] = suffix
    if inp == "p" :
        printEposter(brukernavn)
