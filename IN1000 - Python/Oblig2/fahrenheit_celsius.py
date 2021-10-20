# Dette programmet konverterer en input fra bruker fra fahrenheit til celsius.

# Her lager jeg variabelen "fahrenheit". Denne blir direkte omgjort til heltall.
fahrenheit = int(input("Skriv inn en temperatur i fahrenheit:\n>"))
print("Temperatur i fahrenheit: " + str(fahrenheit)+"°F")
# Her blir formelen lagt inn. Ettersom variabelen "fahrenheit" nå har heltallsverdi
# kan den gli rett inn i formelen. Den nye variabelen heter "celsius".
celsius = ((fahrenheit-32)*5/9)
# Til slutt skriver programmet ut hva den oppgitte temperaturen er i celsius.
print("Temperaturen i celsius er: " + str(celsius)+"°C")
