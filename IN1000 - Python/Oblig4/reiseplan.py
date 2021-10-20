# Dette programmet tar inn fem inputs for både steder, klesvalg og avreisedatoer.
# Den lar deg så velge to tall som i dette tilfellet er indexer i den senere nøstede listen.

steder = []
klesvalg = []
avreisedatoer = []
reiseplan = []
for sted in range(5) :
    steder.append(input("Skriv inn et reisemål:\n>"))

for klær in range(5) :
    klesvalg.append(input("Skriv inn et klesplagg:\n>"))

for dato in range(5) :
    avreisedatoer.append(input("Skriv inn en dato:\n>"))

reiseplan.append(steder)
reiseplan.append(klesvalg)
reiseplan.append(avreisedatoer)

for utskrift in reiseplan :
    print(utskrift)

i1 = int(input("tall mellom 0 og 2: "))
i2 = int(input("Tall mellom 0 og 4: "))

# Her blir det sjekket om inputen er gyldig. Hvis den er det printer den ut
# elementet i listen reiseplan med de oppgitte indeksene. 
if i1 > 0 and i1 < 3 and i2 > 0 and i2 < 5 :
    print(reiseplan[i1][i2])

else :
    print("Uglydig input!")
