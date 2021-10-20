# Dette programmet tar først inn ett ord fra bruker og skriver ut antall bokstaver.
# Den tar så inn en setning og lager en ordbok av denne. Denne blir så printet ut.
# Til slutt tar den inn en setning fra bruker og skriver ut samme data på en bedre måte,
# med hjelp av funksjonene fra deloppgave 1 og 2.

# 1
def ord() :
    inp = input("Skriv inn et ord: ")
    return len(inp)

print(ord())
# 2
setning_splittet = []
setning_ordbok = {}
inp2 = input("Skriv inn en setning: ")
setning_splittet = inp2.split()

def setning() :
    for x in range(0,len(setning_splittet)) :

        setning_ordbok[setning_splittet[x]]= setning_splittet.count(setning_splittet[x])

    return setning_ordbok

print(setning())


# 3
input1 = input("Skriv inn en setning: ")
setning_splittet = input1.split()

print(setning_splittet)

print("Det er", len(setning_splittet), "ord i setningen din.")
for x in range(0,len((setning_splittet))) :
    print("Ordet", setning_splittet[x],"forekommer",setning_splittet.count(setning_splittet[x]), "ganger og har", len(setning_splittet[x]), "bokstaver.")

# Dette programmet har en liten feil ved at om det samme ordet forekommer to antall_ganger
# i setningen vil den printe ut samme informasjon om dette ordet to ganger. Dette har jeg
# ikke klart å rette opp i etter mange forsøk! 

# Jeg så nå i siste liten at oppgave 3 ikke er så basert på funksjonene fra oppgave 1 og 2 som det kanskje
# er ønsket. Det er likevel basert på samme koder.
