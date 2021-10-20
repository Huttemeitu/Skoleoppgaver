
# Oppgave:
# Skriv et program som tar inn fire tall fra bruker og sorterer de i stigende rekkefølge.


# Det første jeg gjør er å printe en beskrivelse av hvordan programmet brukes til bruker.
# Jeg tar så inn fire inputer fra bruker og gjør de om til heltallsverdi.
print("\n")
print("Velkommen til sorteringsmaskinen!")
print("Du skal nå legge fire tall inn i sorteringsmaskinen. Husk å kun legge inn tall,\nog ikke legg inn samme tall to ganger. Lykke til! ")
inp = input("Tast inn første tall:\n> ")
tall1 = int(inp)
inp2 = input("Tast inn andre tall:\n> ")
tall2 = int(inp2)
inp3 = input("Tast inn tredje tall:\n> ")
tall3 = int(inp3)
inp4 = input("Tast inn fjerde tall:\n> ")
tall4 = int(inp4)

#Her legger jeg inn en liten tekst for å være tydelig ovenfor bruker.
print("\n")
print("Dette er tallene dine i stigende rekkefølge: ")
print("\n")

# Første if-setning gjelder for om det første tallet er det laveste.
if tall1 < tall2 and tall1 < tall3 and tall1 < tall4 :
    print(tall1)
#Hvis "tall" er det laveste tallet vil den fortsette å teste rekkefølgen på tall 2, 3 og 4
    if tall2 < tall3 and tall2 < tall4 :
        print(tall2)
        if tall3 < tall4 :
            print(tall3)
            print(tall4)
        else :
            print(tall4)
            print(tall3)

    if tall3 < tall2 and tall3 < tall4 :
        print(tall3)
        if tall2 < tall4 :
            print(tall2)
            print(tall4)
        else :
            print(tall4)
            print(tall2)

    if tall4 < tall2 and tall4 < tall3 :
        print(tall4)
        if tall2 < tall3 :
            print(tall2)
            print(tall3)
        else :
            print(tall3)
            print(tall2)
# Videre er if-setningen kopiert og omgjort for å gjelde om tall 2,3 eller 4 skal være lavest.
#nr2
if tall2 < tall1 and tall2 < tall3 and tall2 < tall4 :
    print(tall2)

    if tall1 < tall3 and tall1 < tall4 :
        print(tall)
        if tall3 < tall4 :
            print(tall3)
            print(tall4)
        else :
            print(tall4)
            print(tall3)

    if tall3 < tall1 and tall3 < tall4 :
        print(tall3)
        if tall1 < tall4 :
            print(tall1)
            print(tall4)
        else :
            print(tall4)
            print(tall1)

    if tall4 < tall1 and tall4 < tall3 :
        print(tall4)
        if tall1 < tall3 :
            print(tall1)
            print(tall3)
        else :
            print(tall3)
            print(tall1)
#nr3
if tall3 < tall2 and tall3 < tall1 and tall3 < tall4 :
    print(tall3)

    if tall1 < tall2 and tall1 < tall4 :
        print(tall1)
        if tall2 < tall4 :
            print(tall2)
            print(tall4)
        else :
            print(tall4)
            print(tall2)

    if tall2 < tall1 and tall2 < tall4 :
        print(tall2)
        if tall1 < tall4 :
            print(tall1)
            print(tall4)
        else :
            print(tall4)
            print(tall1)

    if tall4 < tall2 and tall4 < tall1 :
        print(tall4)
        if tall2 < tall1 :
            print(tall2)
            print(tall)
        else :
            print(tall1)
            print(tall2)
#nr4
if tall4 < tall2 and tall4 < tall3 and tall4 < tall1 :
    print(tall4)

    if tall2 < tall3 and tall2 < tall1 :
        print(tall2)
        if tall3 < tall1 :
            print(tall3)
            print(tall1)
        else :
            print(tall1)
            print(tall3)

    if tall3 < tall2 and tall3 < tall1 :
        print(tall3)
        if tall2 < tall1 :
            print(tall2)
            print(tall1)
        else :
            print(tall1)
            print(tall2)

    if tall1 < tall2 and tall1 < tall3 :
        print(tall1)
        if tall2 < tall3 :
            print(tall2)
            print(tall3)
        else :
            print(tall3)
            print(tall2)
print("\n")
print("Håper dette kom til nytte! Hade bra!")
print("\n")

# Denne oppgaven kunne blitt løst på mange måter. Ved å bruke sorted funksjonen hadde jeg hatt lagt færre kodelinjer.
# Oppgaven var å bruke if og else, og jeg er fornøyd med sluttreultatet.
