#lister.py

liste = [21, 45, 36]

liste.append(12)

print(liste[0], liste[2])

liste2 = []

liste2.append(input("Oppgi et navn: "))
liste2.append(input("Oppgi et navn: "))
liste2.append(input("Oppgi et navn: "))
liste2.append(input("Oppgi et navn: "))

print(liste2)

if liste2[0] == "Snorre" or liste2[1] == "Snorre" or liste2[2] == "Snorre" or liste2[3] == "Snorre" :
    print("Du husket meg!")

else :
    print("Glemte du meg?")

sum = [liste[0]+liste[1]+liste[2]+liste[3]]
produkt = [liste[0]*liste[1]*liste[2]*liste[3]]

liste3 = sum + produkt

liste4 = liste + liste3

print(liste4)

liste4.pop(4)
liste4.pop(4)

print(liste4)
