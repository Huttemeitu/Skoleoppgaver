# Dette programmet tar inn tre navn og tre bosteder og skriver ut en liten hilsen tilbake.
# Jeg definerer en prosedyre som tar inn navn og bosted.
# Denne blir så kaldt inn tre ganger.

def navnbosted() :
    navn1 = input("Skriv inn navn:\n>")
    bosted1 = input("Hvor kommer du fra? \n>")
    print("Hei, " + navn1 + "!", "Du er fra " + bosted1+".")
    print("\n")

navnbosted()
navnbosted()
navnbosted()
