import java.io.FileNotFoundException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;


public class LabGUI {
    protected static Labyrint l;

    protected static int utveierLabel = 0;
    protected static int loesning = 0;

    protected static JLabel antall;
    protected static JLabel loesningLabel;

    protected static ArrayList<RuteRute> ruter;

    protected static ArrayList<ArrayList<RuteRute>> nett;

    protected static ArrayList<ArrayList<Tuppel>> utveier;

    protected static JButton neste; 
    protected static JButton forrige; 

    public static void main(String[] args) {
        ruter = new ArrayList<RuteRute>();
        nett = new ArrayList<ArrayList<RuteRute>>();

        JFileChooser velger = new JFileChooser();
        int resultat = velger.showOpenDialog(null);
        if(resultat != JFileChooser.APPROVE_OPTION) {
            System.exit(1);
        }
        File f = velger.getSelectedFile();
        try {
            l = new Labyrint(f);
        }
        catch (FileNotFoundException e) {
            System.exit(1);
        }
      
        JFrame vindu = new JFrame("Labyrint");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        vindu.add(panel);

        loesningLabel = new JLabel("Løsning: " + loesning + "     ");
        
        JPanel rutenett = new JPanel();
        rutenett.setLayout(new GridLayout(l.antallRader, l.antallKolonner));

        neste = new JButton(" neste ");
        neste.setEnabled(false);
        class VisNeste implements ActionListener {
            @Override
            public void actionPerformed (ActionEvent e) {
                if(loesning == utveier.size()-1) {
                    loesning = 0;
                }
                else {
                    loesning++;
                }
                loesningLabel.setText("Løsning: " + (loesning+1) + "/" + utveier.size());
                for(RuteRute r : LabGUI.getRuter()) {
                if(r.type == 1 || r.type == 3) {
                    r.setOpaque(true);
                    r.setBackground(Color.WHITE);
                    }
                }
                
                
                for(Tuppel tuppel : LabGUI.getUtveier().get(LabGUI.getLoesning())) {
                    RuteRute rute = LabGUI.getNett().get(tuppel.rad).get(tuppel.kolonne);
                    
                    if(rute.type == 3) {
                        rute.setOpaque(true);
                        rute.setBackground(Color.MAGENTA);
                    }
                    else if(rute.type == 1 && rute != LabGUI.getNett().get(LabGUI.getUtveier().get(LabGUI.getLoesning()).get(0).rad).get(LabGUI.getUtveier().get(LabGUI.getLoesning()).get(0).kolonne)){
                        rute.setOpaque(true);
                        rute.setBackground(Color.BLUE);
                    }
                    else {
                        rute.setOpaque(true);
                        rute.setBackground(Color.CYAN);
                    }
                }
            }
        }
        neste.addActionListener(new VisNeste());

        forrige = new JButton(" forrige ");
        forrige.setEnabled(false);
        class VisForrige implements ActionListener {
            @Override
            public void actionPerformed (ActionEvent e) {
                if(loesning == 0) {
                    loesning = utveier.size()-1;
                }
                else {
                    loesning--;
                }
                
                loesningLabel.setText("Løsning: " + (loesning+1) + "/" + utveier.size());
                for(RuteRute r : LabGUI.getRuter()) {
                if(r.type == 1 || r.type == 3) {
                    r.setOpaque(true);
                    r.setBackground(Color.WHITE);
                    }
                }
               
                for(Tuppel tuppel : LabGUI.getUtveier().get(LabGUI.getLoesning())) {
                    RuteRute rute = LabGUI.getNett().get(tuppel.rad).get(tuppel.kolonne);
                    
                    if(rute.type == 3 ) {
                        //System.out.println("ÅPNING!");
                        rute.setOpaque(true);
                        rute.setBackground(Color.MAGENTA);
                    }
                    
                    else if(rute.type == 1 && rute != LabGUI.getNett().get(LabGUI.getUtveier().get(LabGUI.getLoesning()).get(0).rad).get(LabGUI.getUtveier().get(LabGUI.getLoesning()).get(0).kolonne)){
                        //System.out.println("HVIT");
                        rute.setOpaque(true);
                        rute.setBackground(Color.BLUE);
                    }
                    else{
                        rute.setOpaque(true);
                        rute.setBackground(Color.CYAN);
                    }
                }
            }
        }
        forrige.addActionListener(new VisForrige());

        for(int i = 0; i < l.antallRader; i++) {
            nett.add(new ArrayList<RuteRute>());
        }
        int posRad = 0;
        for(ArrayList<Rute> list : l.rutenett) {
            
            int posKolonne = 0;
            for(Rute r : list) {
                
                if(r instanceof Aapning) {
                    RuteRute nyRuteRuteAapning = new RuteRute(3, posRad, posKolonne);
                    ruter.add(nyRuteRuteAapning);
                    nyRuteRuteAapning.initGUI();
                    rutenett.add(nyRuteRuteAapning);

                    nett.get(posRad).add(nyRuteRuteAapning);
                }
                else if(r instanceof HvitRute) {
                    RuteRute nyRuteRuteHvit = new RuteRute(1, posRad, posKolonne);
                    ruter.add(nyRuteRuteHvit);
                    nyRuteRuteHvit.initGUI();
                    rutenett.add(nyRuteRuteHvit);

                    nett.get(posRad).add(nyRuteRuteHvit);
                }
                else if(r instanceof SortRute) {
                    RuteRute nyRuteRuteSort = new RuteRute(2, posRad, posKolonne);
                    ruter.add(nyRuteRuteSort);
                    nyRuteRuteSort.initGUI();
                    nyRuteRuteSort.setOpaque(true);
                    nyRuteRuteSort.setBackground(Color.BLACK);
                    rutenett.add(nyRuteRuteSort);

                    nett.get(posRad).add(nyRuteRuteSort);
                }
                posKolonne++;
            }
            posRad++;
        }
        
        panel.add(rutenett);
        panel.add(forrige);
        panel.add(neste);
        panel.add(loesningLabel);

        vindu.pack();
        vindu.setVisible(true);
    }

    static Labyrint getLab() {
        return l;
    }
    static ArrayList<ArrayList<RuteRute>> getNett() {
        return nett;
    }

    static void setTeller(int i) {
        utveierLabel = i;
    }
    static int getTeller() {return utveierLabel;}
    static int getLoesning() {return loesning;}
    static void setLoesning(int i) {loesning = i;}
    static JLabel getLabel() {return antall;}
    static JLabel getLoesningLabel() {return loesningLabel;}
    static ArrayList<RuteRute> getRuter() {return ruter;}
    static void setUtveier(ArrayList<ArrayList<Tuppel>> utvei) {utveier = utvei;}
    static ArrayList<ArrayList<Tuppel>> getUtveier() {return utveier;}
    static JButton getNeste() {return neste;}
    static JButton getForrige() {return forrige;}

}

class RuteRute extends JButton {
    int type;
    // 1: hvit
    // 2: sort
    // 3: Åpning
    int posX;
    int posY;

    RuteRute(int type, int x, int y) {
        super(" ");
        this.type = type;
        posX = x;
        posY = y;
        
    }
    
    class Velger implements ActionListener {
        @Override
        public void actionPerformed (ActionEvent e) {
            for(RuteRute r : LabGUI.getRuter()) {
                if(r.type == 1 || r.type == 3) {
                    r.setOpaque(true);
                    r.setBackground(Color.WHITE);
                }
            }

            if(type == 1) {
                setOpaque(true);
                setBackground(Color.CYAN);
            }
            ArrayList<ArrayList<Tuppel>> utveier = LabGUI.getLab().finnUtveiFra(posX, posY, false);
            LabGUI.setUtveier(utveier);
            LabGUI.setLoesning(0);
            if(utveier.size() > 0) {
                LabGUI.getLoesningLabel().setText("Løsning: " + (LabGUI.getLoesning()+1) + "/" + utveier.size());
                LabGUI.getNeste().setEnabled(true);
                LabGUI.getForrige().setEnabled(true);
            }
            else {
                LabGUI.getLoesningLabel().setText("Ingen utveier");
                LabGUI.getNeste().setEnabled(false);
                LabGUI.getForrige().setEnabled(false);

            }
            
            for(Tuppel tuppel : utveier.get(LabGUI.getLoesning())) {
                RuteRute rute = LabGUI.getNett().get(tuppel.rad).get(tuppel.kolonne);
                
                if(rute.type == 3) {
                    //System.out.println("ÅPNING!");
                    rute.setOpaque(true);
                    rute.setBackground(Color.MAGENTA);
                }
                else if(rute.type == 1){
                    //System.out.println("HVIT");
                    rute.setOpaque(true);
                    rute.setBackground(Color.BLUE);
                }
            }
            
            if(type == 1){
                setOpaque(true);
                setBackground(Color.CYAN);
                
            }
            else if(type == 2) {  
            }
            else if(type == 3) {
            }

            int antallUtveierInt = 0;
            for(int i = 0; i < utveier.size(); i++) {
                antallUtveierInt++;
            }
            LabGUI.setTeller(antallUtveierInt);
        }
    }

    void initGUI() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setFont(new Font("Monospaced", Font.BOLD, 10));
        if(LabGUI.getLab().antallRader < 30 && LabGUI.getLab().antallKolonner < 50) {
            setPreferredSize(new Dimension(50, 50));
        }
        else if(LabGUI.getLab().antallRader < 80 && LabGUI.getLab().antallKolonner < 110){
            setPreferredSize(new Dimension(9, 9));
        }
        else {
            setPreferredSize(new Dimension(3, 3));
        }

        setForeground(Color.BLACK);
        addActionListener(new Velger());
    }

    public String toString() {
        return "Rad: " + posX + " Kolonne: " + posY + " TYPE: " + type;
    }
}
