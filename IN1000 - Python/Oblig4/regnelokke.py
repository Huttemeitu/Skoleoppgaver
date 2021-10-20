# Dette programmet tar inn en rekke tall og legger det inn i en liste for å
# så gjøre flere operasjoner med tallene.

inp = 1
list = []
# Her blir while løkken laget. Denne kjører helt til bruker taster inn 0.
# For å unngå at 0 blir en del av listen la jeg inn en if-setning som sier at
# tallet skal være høyere enn 0 for at den skal bli lagt til i listen. Hadde 0 blitt
# med i listen ville det ødelagt for siste deloppgave, hvor det minste tallet alltid
# ville vært 0. 
while inp >= 1 :
    inp = int(input("Skriv tall. Når du er ferdig skriver du 0 \n> "))
    if inp > 0 :
        list.append(inp)

# Denne for-løkken går gjennom alle tallene i listen og printer de ut.
for tall in list :
    print(tall)

minSum = 0
# Denne for løkken øker verdien til minSum med tall hver gang den kjører gjennom
# et tall fra listen.
for tall in list :
    minSum += tall
# Her printes summen ut.
print("Summen av tallene er: ", minSum)

minst = list[0]
# Denne for løkken sjekker hvilke tall som er minst.
# Dette gjør den ved å gå igjennom ett og ett tall og sjekke om x er mindre enn
# elementene i listen. Er den det blir minst erstattet med x og den sjekker neste element.

for x in list :
    if x < minst :
        minst = x

print("Det minste tallet er: ", minst)
# Her skjer det samme bare motsatt.
stoerst = list[0]
for y in range(1, len(list)) :
    if list[y] > stoerst :
        stoerst = list[y]

print("Det største tallet er: ", stoerst)
