dict = {"melk": 14.90, "brød": 24.90, "yoghurt": 12.90, "pizza": 39.90}

print(dict)

vare1 = input("Oppgi et varenavn: ")
pris1 = input("Oppgi prisen på varen(kr): ")
vare2 = input("Oppgi et til varenavn: ")
pris2 = input("Oppgi prisen på varen(kr): ")

dict[vare1]=pris1
dict[vare2]=pris2


print(dict)
