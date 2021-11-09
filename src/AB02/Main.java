package AB02;

import AB02.logik.Simulator;
import AB02.ui.Quadrat;
import AB02.ui.SpielfeldDarstellung;
import AB02.ui.Steuerung;
import AB02.util.Interaktionsbrett;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Willkommen zu dem Spiel des Lebens von Convay!");
        Simulator simulator = new Simulator();
        Steuerung steuerung = new Steuerung(simulator);
        steuerung.StartDesSpiels();
        int folgen = 1;
        while (folgen > 0) {
            folgen = steuerung.getNutzerEingabe().anzahlDerSimulationsschritte();
            simulator.berechneFolgeGeneration(folgen);
        }
        System.out.println("Spiel zuende");
    }
}

