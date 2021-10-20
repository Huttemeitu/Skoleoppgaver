# Dette programmet leser inn to forkskjellige filer og behandler dataen fra filene
# på den måten oppgaven beskriver.

# Jeg åpner først filen.
fil = open("max_temperatures_per_month.csv", "r")

# Ordboken legger jeg i det globale skopet slik at den er tilgjengelig i alle funksjonene.
temp_max = {}
# Denne funksjonen går gjennom linje for linje i filen.
# Den splitter linjen på komma, og henter ut de to bitene og legger de inn
# i ordbok som nøkkel og nøkkelverdi.
def ordbok(filnavn) :
    for linje in filnavn :
        biter = linje.split(",")
        temp_max[biter[0].strip()]=float(biter[1].strip())
    return temp_max
# printer ut ordbok.
print(ordbok(fil))
print("")

# åpner fil2.
fil2 = open("max_daily_temperature_2018.csv", "r")
# Denne funksjonen tar inn to argumenter; ordbok og filnavn.
# Den går igjennom hver linje og sjekker opp mot ordboken jeg lagde i
# forrige funksjon om verdien er høyere. Om den er det skal den både si ifra
# til bruker, og den skal oppdatere ordboken med den nye temperaturrekorden.
def varmerekord(ordbok,filnavn) :

    for linje in filnavn :
        biter = linje.split(",")
        maaned = biter[0]
        dag = biter[1]
        temp = float(biter[2])

        if temp > temp_max[maaned] :
            print("Ny varmerekord på", biter[1], biter[0],":", temp, "grader Celsius (gammel rekord var", temp_max[biter[0]], "grader Celsius)")
            temp_max[maaned] = temp
    print("")
    return temp_max
# Her printer jeg ut den oppdaterte ordboken for å sjekke at funksjonen funket.

print(varmerekord(temp_max, fil2 ))

# Her lager jeg en ny fil.
nyfil = open("updatedtemp.csv", "w")

maaned = list(temp_max)
temp = temp_max.values()
temp = str(list(temp))

# Denne funksjonen skriver den oppdaterte ordboken til en ny fil,
# i samme format som filen den tok inn.
def warmtempwrite(ordbok, filnavn) :
    for linje in range(0,len(list(ordbok))) :
        filnavn.write(maaned[linje])
        filnavn.write(",")
        filnavn.write(str(temp_max[maaned[linje]]))
        filnavn.write("\n")




# Kaller på funksjonen.
warmtempwrite(temp_max, nyfil)
# Til slutt lukke jeg filene.
fil.close()
fil2.close()
nyfil.close()
