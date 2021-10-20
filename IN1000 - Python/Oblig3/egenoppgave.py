# Oppgave:
# En kompisgjeng på 3 skal samles og hosten foreslår drikke og snacks.
# Hosten gidder ikke kjøpe en halvliter med drikke til hver, og heller ikke
# en pose med snacks til hver. Han gidder kun å kjøpe store chipsposer og
# 1,5-litere med brus.
# Be om input fra alle de 3 gjestene på hva de ønsker av de 3 forksjellige
# brustypene og de 4 forskjellige snackstypene. Legg disse så inn i en liste
# og sjekk hva som forekomer mest.


snacks = ["1: Sørlandschips", "2: Ostepop"]
drikke = ["1: Cola", "2: Fanta"]
print("Snacks:",snacks)
print("Drikke:",drikke)

snacksvalg = []
brusvalg = []

tjommi1s = int(input("Velg en snacks fra listen over(nr): "))
tjommi1d = int(input("Velg en drikke fra listen over(nr): "))
tjommi2s = int(input("Velg en snacks fra listen over(nr): "))
tjommi2d = int(input("Velg en drikke fra listen over(nr): "))
tjommi3s = int(input("Velg en snacks fra listen over(nr): "))
tjommi3d = int(input("Velg en drikke fra listen over(nr): "))



snacksvalg.append(tjommi1s)
brusvalg.append(tjommi1d)

snacksvalg.append(tjommi2s)
brusvalg.append(tjommi2d)

snacksvalg.append(tjommi3s)
brusvalg.append(tjommi3d)

snackssortert = [snacksvalg.count(1),snacksvalg.count(2)]

drikkesortert = [brusvalg.count(1),brusvalg.count(2)]


if snackssortert[0]>snackssortert[1] :
    if drikkesortert[0]>drikkesortert[1] :
        print("Da blir det Sørlandschips og Cola!")
    elif drikkesortert[0]<drikkesortert[1] :
        print("Da blir det Sørlandsschips og Fanta!")


else :
    if drikkesortert[0]>drikkesortert[1] :
        print("Da blir det Ostepop og Cola!")
    elif drikkesortert[0]<drikkesortert[1]:
        print("Da blir det Ostepop og Fanta!")
