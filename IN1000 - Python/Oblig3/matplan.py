liste1 = ["egg", "pannekaker", "kjøttkaker"]
liste2 = ["cornflakes", "suppe", "Torsk"]
liste3 = ["Speilegg", "Baguette", "Taco"]

dict = {"Berit": liste1, "Tor": liste2, "Birgit": liste3}

def navn() :
    print("Berit, Tor, Birgit")
    inp = input("Skriv inn navnet til en beboer: ")
    if inp == "Berit" or inp == "Tor" or inp == "Birgit" :
        print(dict[inp])

    else :
        print("Denne beboeren er ikke registrert.")


navn()

# a. Ordbok: Ved bruk av ordbok kan bruker søke etter navnet på student
# Da vil bruker få opp den koblede verdien som i dette tilfellet er brukernavnet.
# b. Liste: Her vil en liste være adekvat. Ved bruk av liste vil man kunne
# feks sjekke antall ganger en karakter forekommer.
# c. Mengde: Her har ikke rekkefølge noe å si. Her vil man kun få opp en
# samling av vinnerne det siste året.
# d. Mengde: Her kan man bruke mengde. Det har ikke noe å si om det er én
# eller to som har laktoseinntoleranse, menyen må fortsatt tilpasses ettersom.
# Mengde er fint å bruke for å sjekke om noe finnes i samlingen, i dette tilfellet; en allergi.
# Hvis menyen skal tilpasses hver enkelt person kan man bruke en liste. Her kan man se etter
# hvor mange som feks har laktoseinntoleranse og tilpasse menyen etter dette.
