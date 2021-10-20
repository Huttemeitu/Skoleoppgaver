class Celle:
   # Konstruktør
    def __init__(self):
        self._status = "doed"


    # Endre status
    def settDoed(self):
        self._status = "doed"

    def settLevende(self):
        self._status = "levende"

    # Hente status
    def erLevende(self):
        if self._status == "levende":
            return True
        if self._status == "doed":
            return False


    def hentStatusTegn(self):
        if self._status == "levende":
            return "O"
        if self._status == "doed":
            return "."
