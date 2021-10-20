# klassen blir importert

from dato import Dato


def hovedprogram():
    # Her dannes dato-objektet.
    dato1 = Dato(15,3,2020)
    # Her printes datoens år.
    print(dato1.lesAar())
    # Her har jeg grublet litt over hva oppgaven spørr om. Jeg har tolket det
    # som at jeg må ha if-sjekker i både metoden og i metodekallet.
    if dato1.dag(15):
        print("Loenningsdag!")
    if dato1.dag(1):
        print("Ny maaned, nye muligheter.")
    # til slutt blir datoen printet ut på en utskiriftsvennlig måte.
    penDato = str(dato1.skrivUt())
    print(penDato)
# Her kalles det på hovedprogrammet. 
hovedprogram()
