# Dette programmet lager i oppgave1 en funksjon som summerer to argumenter, to ganger.
# I de to siste oppgavene tar programmet inn en streng fra bruker hvor den så lar bruker,
# sjekke antall ganger en bokstav forekommer i tekststrengen.

def adder(tall1, tall2 ) :

    return tall1 + tall2


print("De to tallene summert er:", adder(4,3))
print("De to tallene summert er:", adder(22,4))

#Oppgave 2 er lagt til her som en kommentar.
"""
tekst = input("Skriv inn et ord: ")
bokstav = input("Skriv inn en bokstav: ")

antall_ganger = tekst.count(bokstav)

print("Bokstaven", "'"+bokstav+"'", "forekommer", antall_ganger, "gang(er)!" )
"""
# Her lages det en funksjon tellForekomst med parametere.
def tellForekomst(minTekst, minBokstav) :


    print("Bokstaven", "'"+minBokstav+"'", "forekommer", minTekst.count(minBokstav), "gang(er) i ordet", "'"+minTekst+"'"+"!")
    return minTekst.count(minBokstav)
# Verdien blir returnet. Dette gjør det enkelt å printe ut verdien til bruker med input som argumenter. 
tellForekomst(input("Skriv inn et ord: "), input("Skriv inn en bokstav: "))
