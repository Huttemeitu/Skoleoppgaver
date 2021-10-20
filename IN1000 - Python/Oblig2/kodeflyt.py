def print_prosa(): #1
    print("Melding til alle gaardeiere:") #2 #6 #12
    print("Antall dyr paa gaarden: ") #3 #7 #13
antall_dyr = 4 #4
print_prosa() #5
print(antall_dyr) #8
antall_nye_dyr = int(input("Hvor mange nye dyr kommer til gaarden: ")) #9
antall_dyr = antall_dyr + antall_nye_dyr #10
print_prosa() #11
print(antall_dyr) #14
if antall_dyr > 12: #15
    print("Det er mer enn ett dusin dyr paa gaarden!")
elif antall_dyr == 12: #16
    print("Det er ett dusin dyr paa gaarden!") #17
else:
    print("Det er mindre enn ett dusin dyr paa gaarden!")
    
