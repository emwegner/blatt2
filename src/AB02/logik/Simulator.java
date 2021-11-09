package AB02.logik;
import AB02.ui.Steuerung;
import AB02.util.Interaktionsbrett;

import java.util.Random;

public class Simulator implements Simulation{
    public int anzahlFelder = 0;
    public boolean[][] spielfeld;
    public Simulator() {
    }

    public void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlichkeitDerBesiedlung) {
        for (int i = 0; i < anzahlDerZellen; i++) {
            for (int j = 0; j < anzahlDerZellen; j++ ) {
                Random random = new Random();
                int rand = random.nextInt(100 - 1 + 1) + 1;
                if (rand > wahrscheinlichkeitDerBesiedlung) {
                    spielfeld[i][j] = false;
                } else {
                    spielfeld[i][j] = true;
                }
            }
        }
    }

    public void berechneFolgeGeneration(int berechnungsschritte) {
        for (int step = 0; step < berechnungsschritte; step++) {
            boolean[][] newFeld = new boolean[spielfeld.length][spielfeld.length];
            for (int i = 0; i < spielfeld.length; i++) {
                for (int j = 0; j < spielfeld[i].length; j++) {
                    int anzahlNachbarn = 0;
                    if (i == 0) {
                        if (j == 0) {
                            if (spielfeld[i][j + 1] == true) anzahlNachbarn++;
                            if (spielfeld[i + 1][j + 1] == true) anzahlNachbarn++;
                            if (spielfeld[i + 1][j] == true) anzahlNachbarn++;
                        } else if (j == spielfeld[i].length) {
                            if (spielfeld[i][j - 1] == true) anzahlNachbarn++;
                            if (spielfeld[i + 1][j - 1] == true) anzahlNachbarn++;
                            if (spielfeld[i + 1][j] == true) anzahlNachbarn++;
                        } else {
                            if (spielfeld[i][j - 1] == true) anzahlNachbarn++;
                            if (spielfeld[i][j + 1] == true) anzahlNachbarn++;
                            if (spielfeld[i + 1][j + 1] == true) anzahlNachbarn++;
                            if (spielfeld[i + 1][j - 1] == true) anzahlNachbarn++;
                            if (spielfeld[i + 1][j] == true) anzahlNachbarn++;
                        }
                    }
                    if (i == spielfeld.length) {
                        if (j == 0) {
                            if (spielfeld[i - 1][j + 1] == true) anzahlNachbarn++;
                            if (spielfeld[i - 1][j] == true) anzahlNachbarn++;
                            if (spielfeld[i][j + 1] == true) anzahlNachbarn++;
                        } else if (j == spielfeld[i].length) {
                            if (spielfeld[i][j - 1] == true) anzahlNachbarn++;
                            if (spielfeld[i - 1][j - 1] == true) anzahlNachbarn++;
                            if (spielfeld[i - 1][j] == true) anzahlNachbarn++;
                        } else {
                            if (spielfeld[i][j - 1] == true) anzahlNachbarn++;
                            if (spielfeld[i][j + 1] == true) anzahlNachbarn++;
                            if (spielfeld[i - 1][j + 1] == true) anzahlNachbarn++;
                            if (spielfeld[i - 1][j - 1] == true) anzahlNachbarn++;
                            if (spielfeld[i - 1][j] == true) anzahlNachbarn++;
                        }
                    } else if (i != 0 && i != spielfeld.length && j == 0) {
                        if (spielfeld[i][j + 1] == true) anzahlNachbarn++;
                        if (spielfeld[i + 1][j + 1] == true) anzahlNachbarn++;
                        if (spielfeld[i + 1][j] == true) anzahlNachbarn++;
                        if (spielfeld[i - 1][j] == true) anzahlNachbarn++;
                        if (spielfeld[i - 1][j + 1] == true) anzahlNachbarn++;
                    } else if (i != 0 && i != spielfeld.length && j == spielfeld[i].length) {
                        if (spielfeld[i][j - 1] == true) anzahlNachbarn++;
                        if (spielfeld[i + 1][j] == true) anzahlNachbarn++;
                        if (spielfeld[i + 1][j - 1] == true) anzahlNachbarn++;
                        if (spielfeld[i - 1][j] == true) anzahlNachbarn++;
                        if (spielfeld[i - 1][j - 1] == true) anzahlNachbarn++;
                    } else if (i != 0 && j != 0) {
                        if (spielfeld[i][j - 1] == true) anzahlNachbarn++;
                        if (spielfeld[i][j + 1] == true) anzahlNachbarn++;
                        if (spielfeld[i + 1][j + 1] == true) anzahlNachbarn++;
                        if (spielfeld[i + 1][j - 1] == true) anzahlNachbarn++;
                        if (spielfeld[i + 1][j] == true) anzahlNachbarn++;
                        if (spielfeld[i - 1][j + 1] == true) anzahlNachbarn++;
                        if (spielfeld[i - 1][j - 1] == true) anzahlNachbarn++;
                        if (spielfeld[i - 1][j] == true) anzahlNachbarn++;

                    }

                    if (spielfeld[i][j] == true && anzahlNachbarn == 2 || anzahlNachbarn == 3)
                        newFeld[i][j] = true;
                    else if (spielfeld[i][j] == false && anzahlNachbarn == 3) newFeld[i][j] = true;
                    else newFeld[i][j] = false;
                }
            }
            if (spielfeld == newFeld) return;
            else spielfeld = newFeld;
            Steuerung steuerung = new Steuerung();
            steuerung.aktualisiere(spielfeld);
            //die  Geschwindigkeit  der  Darstellung
            // kann  bspw.  über Thread.sleep(150) gesteuert werden

        }
    }



    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        /*
??? wtf is anmelden haha
         */

    }

}
