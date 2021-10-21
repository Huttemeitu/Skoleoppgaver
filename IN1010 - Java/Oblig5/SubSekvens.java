class SubSekvens {
    private String subSekvens; 
    private int antallForekomster = 1;

    SubSekvens(String ss) {subSekvens = ss;} 
    public String hentSubSekvens() {return subSekvens;}
    public int hentAntallForekomster() {return antallForekomster;}
    public void settSubSekvens(String nySs) {subSekvens = nySs;}
    public void settAntallForekomster(int nyAf) {antallForekomster = nyAf;}
    public void leggTil(int ant) {antallForekomster = antallForekomster + ant;}
    @Override
    public String toString() {return subSekvens + ": " + antallForekomster;}
    
}

