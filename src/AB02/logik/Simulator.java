package AB02.logik;
import AB02.ui.Steuerung;
import AB02.util.Interaktionsbrett;
import AB02.logik.BeiAenderung;

import java.util.Random;

public class Simulator implements Simulation{
    public int anzahlFelder = 0;
    public boolean[][] spielfeld;
    private BeiAenderung beiAenderung;

    public Simulator(int anzahlFelder) {
        this.anzahlFelder = anzahlFelder;
        boolean[][] spielfeld = new boolean[anzahlFelder][anzahlFelder];
    }

    public void setAnzahlFelder(int anzahlFelder) {
        this.anzahlFelder = anzahlFelder;
    }

    public void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlichkeitDerBesiedlung) {
        for (int i = 0; i < anzahlDerZellen; i++) {
            for (int j = 0; j < anzahlDerZellen; j++ ) {
                Random random = new Random();
                int rand = random.nextInt(100);
                spielfeld[i][j] = rand < wahrscheinlichkeitDerBesiedlung;
            }
        }
    }

    public void berechneFolgeGeneration(int berechnungsschritte) {
        boolean[][] newFeld = new boolean[spielfeld.length][spielfeld.length];
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                int anzahlNachbarn = zaehlen(i,j);

                if (spielfeld[i][j] && anzahlNachbarn == 2 || anzahlNachbarn == 3)
                    newFeld[i][j] = true;
                else if (spielfeld[i][j] == false && anzahlNachbarn == 3) newFeld[i][j] = true;
                else newFeld[i][j] = false;
            }
        }
        if (spielfeld == newFeld) return;
        else spielfeld = newFeld;
        if (beiAenderung != null) beiAenderung.aktualisiere(spielfeld);
    }

    public int zaehlen(int currentI, int currentJ) {
            int count = 0;
            for(int i = currentI - 1; i <= currentI + 1; i++) {
                if (i >= 0 && i < spielfeld.length) // fixed here
                    for(int j = currentJ - 1; j <= currentJ + 1; j++)
                        if (j >= 0 && j < spielfeld[i].length) // fixed here
                            if (i != currentI || j != currentJ)
                                if (spielfeld[i][j] == true)
                                    count++;
            }

            return count;
    }


    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
       this.beiAenderung = beiAenderung;
    }

}
