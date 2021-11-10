package AB02.logik;
import AB02.ui.Steuerung;
import AB02.util.Interaktionsbrett;
import AB02.logik.BeiAenderung;

import java.util.Random;

public class Simulator implements Simulation{
    private int anzahlFelder = 0;
    private boolean[][] spielfeld;
    private BeiAenderung beiAenderung;

    public void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlichkeitDerBesiedlung) {
        spielfeld = new boolean[anzahlDerZellen][anzahlDerZellen];
        Random random = new Random();
        anzahlFelder = anzahlDerZellen;
        for (int i = 0; i < anzahlDerZellen; i++) {
            for (int j = 0; j < anzahlDerZellen; j++ ) {
                int rand = random.nextInt(100);
                spielfeld[i][j] = rand < wahrscheinlichkeitDerBesiedlung;
            }
        }
    }

    public void berechneFolgeGeneration(int berechnungsschritte){
        for (int folgen = 0; folgen < berechnungsschritte; folgen++) {
            boolean[][] newFeld = new boolean[spielfeld.length][spielfeld.length];
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    int anzahlNachbarn = zaehlen(i, j);

                    if (anzahlNachbarn == 2) newFeld[i][j] = spielfeld[i][j];
                    else if (anzahlNachbarn == 3) newFeld[i][j] = true;
                    else newFeld[i][j] = false;
                }
            }
            if (spielfeld == newFeld) return;
            else spielfeld = newFeld;
            if (beiAenderung != null) beiAenderung.aktualisiere(spielfeld);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.err.println("Fehler bei Thread.sleep");
            }
        }
    }

    public int zaehlen(int currentI, int currentJ) {
            int count = 0;
            for(int i = currentI - 1; i <= currentI + 1; i++) {
                if (i >= 0 && i < spielfeld.length)
                    for(int j = currentJ - 1; j <= currentJ + 1; j++)
                        if (j >= 0 && j < spielfeld[i].length)
                            if (i != currentI || j != currentJ)
                                if (spielfeld[i][j] == true)
                                    count++;
            }
            return count;
    }


    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
       this.beiAenderung = beiAenderung;
    }

    public boolean[][] getSpielfeld() {
        return spielfeld;
    }

}
