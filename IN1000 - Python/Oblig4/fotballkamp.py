# Skriv et program som bruker lister og løkker til å dele en vennegjeng inn i to fotballlag.

print("Fotballkamp! Fyll inn vennegjengen din. \nNår du har skrevet opp ønsket antall venner skriver du: ferdig")

venneliste = []
inp = []
while inp != 'ferdig' :
    inp = input("Skriv inn et navn på en venn: ")
    venneliste.append(inp)

venneliste.pop()

lag1 = []

for x in range(0,(int(len(venneliste)/2))) :
    lag1.append(venneliste[x])

print("Lag 1 er: ", lag1)

del venneliste[0:len(lag1)]

print("Lag 2 er: ", venneliste)

print("Lykke til!")
