package AB02.ui;

import AB02.logik.BeiAenderung;
import AB02.logik.Simulation;
import AB02.logik.Simulator;
import AB02.util.EinUndAusgabe;
import AB02.util.Interaktionsbrett;

public class Steuerung implements BeiAenderung {
    private NutzerEingabe nutzerEingabe;
    private Simulator simulator;
    private SpielfeldDarstellung spielfeldDarstellung;


    public Steuerung(Simulator simulator) {
        this.simulator = simulator;
    }

    public void StartDesSpiels() {
        initialisierung();
        simulator.berechneAnfangsGeneration(nutzerEingabe.anzahlZellenDesSpielfeldes(), nutzerEingabe.wahrscheinlichkeitDerBesiedlung());
        spielfeldDarstellung.spielfeldDarstellen(simulator.getSpielfeld());
        }

    public NutzerEingabe getNutzerEingabe() {
        return nutzerEingabe;
    }

    public void initialisierung() {
        Interaktionsbrett ib = new Interaktionsbrett();
        EinUndAusgabe ea = new EinUndAusgabe();
        nutzerEingabe = new NutzerEingabe(ea);
        spielfeldDarstellung = new SpielfeldDarstellung(ib);
        simulator.anmeldenFuerAktualisierungBeiAenderung(this);


    }
    public void aktualisiere(boolean[][] neueGeneration) {
      spielfeldDarstellung.spielfeldDarstellen(neueGeneration);
    }
}
