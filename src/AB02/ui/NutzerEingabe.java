package AB02.ui;


import AB02.util.EinUndAusgabe;

import java.util.Scanner;

public class NutzerEingabe {
    Scanner scanner = new Scanner(System.in);
    public EinUndAusgabe io;

    public NutzerEingabe(EinUndAusgabe ea) {
    }

    public NutzerEingabe() {

    }


    public void NutzerEingabe(EinUndAusgabe io) {
        this.io = io;
    }

    public int anzahlZellenDesSpielfeldes() {
        int zellen = 0;
        while (zellen < 5) {
            System.out.print("Geben sie die Anzahl der Zellen des Spielfeldes ein (min.5) : ");
            zellen = scanner.nextInt();
        }

        return zellen;
    }

    public int wahrscheinlichkeitDerBesiedlung() {
        int wahrscheinlichkeit = 0;
        while (wahrscheinlichkeit > 100 && wahrscheinlichkeit < 1) {
            System.out.print("Geben sie einen Wert zwischen 1 und 100 ein : ");
            wahrscheinlichkeit = scanner.nextInt();
        }
        return wahrscheinlichkeit;
    }

    public int anzahlDerSimulationsschritte() {
        int anzahl = 0;
        while (anzahl > 20 && anzahl < 1) {
            System.out.print("Geben sie die Anzahl der Simulationsschritte ein (Abbruch mit negativer Zahl) : ");
            anzahl = scanner.nextInt();
        }
        return anzahl;
    }
}
