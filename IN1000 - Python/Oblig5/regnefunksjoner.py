# Dette programmet lager en rekke funksjoner som den kaller på i
# utskriftsfunksjonen "skrivBeregninger" i slutten av programmet.

# Her blir tre funksjoner laget. Funksjonene er helt likt oppbygd,
# bare med forksjellige regnefunksjoner. Ettersom variablene alle ligger
# på det lokale skopet i funksjonene kan de alle ha samme navn uten at det skaper
# problemer.
# Resultatet fra utregningene blir returnert til funksjonene.
def addisjon(tall1, tall2) :
    res = tall1 + tall2
    return res

print(addisjon(6,3))


def subtraksjon(tall1, tall2) :
    res = tall1-tall2
    return res

print(subtraksjon(6,3))


def divisjon(tall1, tall2):
    res = tall1/tall2
    return res

print(int(divisjon(6,3)))

# Her blir funksjonene testet.
assert addisjon(5,6) == 11
assert addisjon(2,-7) == -5
assert addisjon(-5,-6) == -11

assert subtraksjon(5,6) == -1
assert subtraksjon(2,-7) == 9
assert subtraksjon(-5,-6) == 1

assert divisjon(12,6) == 2
assert divisjon(4,-2) == -2
assert divisjon(-18,-2) == 9

# Funksjonen "tommerTilCm" blir laget på samme måte som funksjonene over.
# Her er det kun ett parameter og inputen blir i tillegg testet for om den
# er over 0.
def tommerTilCm(antallTommer) :
    assert antallTommer > 0
    return antallTommer * 2.54

# Denne funksjonen kaller på de andre funksjonene underveis.
# Ettersom de forrige funksjonene er laget med parametre kan samme
# funksjon brukes for nye dannede variabler i denne funksjonen.
# Det er også lagt inn tekst, linjehopp etc. for å gjøre utskriften pen.
def skrivBeregninger():
    print("Utregninger: ")
    tall1 = float(input("Skriv inn tall 1: "))
    tall2 = float(input("Skriv inn tall 2: "))
    print("")
    print("Resultat av summering: ", addisjon(tall1, tall2))
    print("Resultat av subtraksjon: ",subtraksjon(tall1, tall2))
    print("Resultat av divisjon: ",divisjon(tall1, tall2))
    print("")
    print("Konvertering fra tommer til cm:")
    print("Resultat: ", tommerTilCm(float(input("Skriv inn et tall: "))))
# Helt til slutt kaller vi på skrivBeregninger.
skrivBeregninger()
