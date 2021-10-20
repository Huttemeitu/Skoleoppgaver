# I denne oppgaven har jeg lastet ned csv filer fra ssb. Disse blir behandlet
# for å så printe ut info jeg selv valgte skulle printes ut.
# Programmet gjør ikke mer enn å printe ut endring i antall elever i grunnskolen
# og endring i folketall i norge basert på csv filenes innhold.

"""
Oppgavetekst: Skriv et program som tar inn en fil nedlastet fra ssb og behandler dataen ved hjelp av funksjoner.
Du velger selv hvordan dataen skal behandles. Sørg for å skrive det ut på en ryddig måte.
"""

dict= {}

# Funksjonen legger dataen fra filen inn i ordboken dict med årstall som nøkkel
# og antall elever som nøkkelverdi.
# i slutten av funksjonen blir det økningen over ti år returnert.
def elever_oekning() :
    skole_elever = open("tabellskole.csv", "r")

    for linje in skole_elever :
        linjer = linje.split(";")
        aar = linjer[0]
        antall = linjer[1]
        dict[aar]=int(antall.strip())
    skole_elever.close()
    aarstall=list(dict)
    return dict[aarstall[len(aarstall)-1]]-dict[aarstall[0]]
elever_oekning()


folkedict = {}

# Denne funksjonen gjør akuratt det samme for forrige, bare med data om folketall.
# Her blir økningen i norsk befolkning returnert.
def regning() :
    folkemengde = open("Folkemengde (1).csv", "r")
    for linje in folkemengde :
        linjer = linje.split(";")
        aar = linjer[0]
        befolkning = linjer[1]
        folkedict[aar]=int(befolkning.strip())
    folkemengde.close()
    aarstall1=list(folkedict)
    return folkedict[aarstall1[len(aarstall1)-1]]-folkedict[aarstall1[0]]
regning()

# Begge funksjonene over blir kallt på, for å fylle opp ordbøkene før siste prosedyre kjøres.

# I denne prosedyren blir det printet ut infoen som de to forrige funksjonene regnet ut.
def hovedprogram() :
    aarstall = list(dict)
    print("")
    print("Fra", aarstall[0], "til", aarstall[len(aarstall)-1], "har det vært en økning på", elever_oekning(), "elever i den norske grunnskolen.")
    print("I samme periode var det en økning i befolkningen i Norge på", regning(), "personer.")
    print("Dette er fakta som er artig å vite!")
    print("")

hovedprogram()
