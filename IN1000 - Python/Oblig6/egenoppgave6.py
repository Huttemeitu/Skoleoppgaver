# Her har jeg fulgt eksempeloppgaven fra oppgaveteksten.

# Klassen blir laget.
class Person:
    def __init__(self, navn, alder):
        self._navn = navn
        self._alder = alder
        self._hobby = []
# her lages metoden som legger til hobbyer i en liste.
# Denne er tilpasset slik at den passer til while løkken jeg har laget lengre ned.
    def leggTilHobby(self):
        hobbyStreng = input("Skriv inn en hobby(skriv s når du er ferdig): ")
        self._hobby.append(hobbyStreng)
        return hobbyStreng

# Her blir listen over hobbyer skrevet ut på én linje. Ettersom  input = "s"
# hopper ut av løkken måtte jeg legge til en del setning for å unngå å få den med
# i listen.
# Jeg har også brukt join for å gjøre det litt mer utskriftsvennlig.
    def skrivHobbyer(self):
        del self._hobby[-1]
        print("Hobbyene dine er: ",", ".join(self._hobby))

# Her printes navn og alder ut til bruker. Denne metoden kaller også på
# metoden skrivHobbyer. Dette gjorde at jeg ikke skjønte meg hvordan jeg skulle
# snike meg rundt det at skrivHobbyer her ikke blir kallt på med et objekt.
# Dette har jeg "løst" ved å legge til et til parameter "obj" som blir lagt
# inn ved kallet på skrivHobbyer. Dette gjør at man må skrive objektet også som
# et argument ved kall på skrivUt. (Dette antar jeg er en ulempe, og jeg vil gjerne
# vite hvordan man heller skulle løst dette.)
    def skrivUt(self,obj):
        print(self._navn + ", " + str(self._alder) + " aar")
        obj.skrivHobbyer()

# Her lages hovedprogrammet. Navn og alder blir lagret i variabler og
# objektet blir laget basert på disse variablene.
def hovedprogram():
    navninp = input("Skriv inn navnet ditt: ")
    alderinp = input("Skriv inn alderen din: ")
    pers1 = Person(navninp, alderinp)

# Her lages while-løkken som lar bruker legge til hobbyer. Variabelen "hobbyStreng"
# blir returnert i leggTilHobby metoden slik at denne kan brukes her. Så fort bruker
# skriver inn s vil den hoppe ut av løkken.
    inp = None
    while inp != "s" :
        inp = pers1.leggTilHobby()
# Programmet vil så printe ut navn, alder og vedkommendes hobbyer.
# Her kaller jeg på metoden skrivUt med objektet, men sender også med objektet
# som et argument som blir anvendet i skrivUt som forklart over.
    print("")
    pers1.skrivUt(pers1)
# til slutt kaller jeg på hovedprogrammet.
hovedprogram()
