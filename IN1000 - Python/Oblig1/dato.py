# coding=<Python>
# Dette programmet sjekker rekkefølgen på to oppgitte datoer fra bruker.
# Den printer så ut til bruker om datoene er i riktig eller feil rekkefølge i et år.

# Her har jeg laget 4 variabler som senere avgjør hva som blir verdien til "dato1" og "dato2".
# Variablene får verdi fra en input fra bruker. Jeg har fordelt outputen over flere linjer,
# samt lagt inn piler for å få det til å se oversiktelig ut.
# Jeg tok en ekstra utfordring og ville få programmet til å stoppe om input er ugyldig.
dag1 = input("Skriv inn en dato.\nSkriv først en dag.(Tall mellom 1 og 31):\n> ")
if int(dag1) > 31 or int(dag1) < 1 :
    print("Tallet", dag1, "er ikke gyldig.")
else :
    maaned1 = input("Skriv så en måned. (Tall mellom 1 og 12):\n>")
    if int(maaned1) > 12 or int(maaned1) < 1 :
        print("Tallet", maaned1, "er ikke gyldig.")
    else :
        dag2 = input("Skriv nå en ny dag.\n(Tall mellom 1 og 31):\n> ")
        if int(dag2) > 31 or int(dag2) < 1 :
            print("Tallet", dag2, "er ikke gyldig.")
        else :
            maaned2 = input("Skriv nå en ny måned.\n(Tall mellom 1 og 12):\n>")
            if int(maaned2) > 12 or int(maaned2) < 1 :
                print("Tallet", maaned2, "er ikke gyldig.")
            else :

# Her testes først måned. Hvis "maaned1" er midre enn "maaned2" trenger vi ikke teste dag.
# Derfor kan "riktig-" eller "feil rekkefølge" skrives ut allerede her.
# Hvis "maaned2" = "maaned2" vil elsen fange opp dette for å så teste dag.
                if maaned1 < maaned2 :
                    print("Riktig rekkefølge!")
                elif maaned1 > maaned2 :
                    print("Feil rekkefølge!")

                else : # Her vet vi at det er samme måned og må derfor teste på dag1 og dag2.

                    if dag1 < dag2 :
                        print("Riktig rekkefølge!")
                    elif dag1 > dag2 :
                        print("Feil rekkefølge!")
                    else :
                        print("Samme dato!") # Her vet vi at både måned og dag er lik.
