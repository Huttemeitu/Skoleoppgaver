def billett() :
    inp = input("Hva er alderen din? ")
    alder = int(inp)
    billettpris = 0

    if alder < 18 :
        print("Du skal betale for en barnebilett. Denne koster:",billettpris+30)
    elif alder > 17 and alder < 63 :
        print("Du skal betale for en voksenbilett. Denne koster:",billettpris+50)
    elif alder > 62 :
        print("Du skal betale for en pensjonistbilett. Denne koster:",billettpris+35)

billett()

# Oppgave 5 skjønte jeg ikke helt. Jeg kjørte programmet for 15, 31 og 63 som input,
# og det funket, men jeg skjønner ikke hvordan jeg skal avgi et "svar" på denne oppgaven.
