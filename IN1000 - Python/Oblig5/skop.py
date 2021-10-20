def minFunksjon():
    for x in range(2):
        c = 2
        print(c)
        c += 1
        b = 10
        b += a
        print(b)
    return(b)

def hovedprogram():
    a = 42
    b = 0
    print(b)
    b = a
    a = minFunksjon()
    print (b)
    print (a)


hovedprogram()

"""
Først blir det definert en funksjon med navn "minFunksjon" som ikke tar imot parametre.
Deretter defineres prosedyren "hovedprogram" som heller ikke tar imot parametre.
Så kaller vi på hovedprogrammet. I hovedprogrammet blir to variabler definert. Disse er:
a = 42 og b = 0. Hovedprogrammet skal deretter printe ut b. Dette vil printe ut 0 i terminalen.
Deretter settes b til å ha verdien a, altså 42. a endres så til å ha verdien som blir returnert i minFunksjon.
Her hopper den til minFunksjon. Inni minFunksjon er det laget en for-løkke. Den definerer først variabelen c til å ha en verdi
2. Denne printes så ut i terminalen. Deretter vil c ha en økning i verdi med 1. c har nå verdien 3. Så defineres b som en
lokal variabel i minFunksjon. Denne har verdien 10. i linje 7 skal b ha en økning med verdien a. Verdien a er kun definert
som en lokal variabel i hovedprogrammet. minFunksjon vil først sjekke lokalt om den finner noen variabler med navn a.
Dette vil den ikke finne. Den vil så søke i det globale skopet. Her ligger det heller ikke noe variabel med navn a. 
Denne variabelen ligger kun i det lokalet skopet til hovedprogrammet. Denne kan ikke bli hentet ut av minFunksjon.
Derfor vil du her få en feilmelding som sier at variabelen a ikke er definert. Her hoppes det ut av programmet.
"""
