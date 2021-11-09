package AB02;

import AB02.logik.Simulator;
import AB02.ui.Quadrat;
import AB02.ui.SpielfeldDarstellung;
import AB02.ui.Steuerung;
import AB02.util.Interaktionsbrett;

public class Main {

    public static void main(String[] args) {
        System.out.println("Willkommen zu dem Spiel des Lebens von Convay!");
        Steuerung steuerung = new Steuerung();
        steuerung.StartDesSpiels();

    }
}
