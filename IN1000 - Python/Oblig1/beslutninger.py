# coding=<Python>
# Dette programmet spør brukeren om han/hun vil ha en brus.
# Programmet gir tre forskjellige ouputs avhengig av inputen.

# Variabelen "svar" bestemmes av inputen fra spørsmålet.
svar = input("Kunne du tenke deg en brus? (ja/nei)\n> ")

# Avhengig av verdien til "svar" printes det ut ett av de tre frasene under.
if svar == "ja" :
    print("Her har du en brus!")
# Her brukte jeg først en til "if" i linje 16. Dette gjorde slik at hvis
# bruker svarte "ja" ble det printet ut både "Her har du en brus" og
# "Det forstod jeg ikke helt".
# Jeg brukte derfor en "elif" istedet.
# Dette hindrer at "elsen" slår ut ettersom inputen IKKE er "nei".
elif svar == "nei" :
    print("Den er grei.")
# Til slutt er "else" lagt inn for å si ifra om at inputen ikke er gyldig.
else :
    print("Det forstod jeg ikke helt.")
