package AB02.ui;

import AB02.logik.BeiAenderung;
import AB02.logik.Simulation;
import AB02.logik.Simulator;
import AB02.util.EinUndAusgabe;
import AB02.util.Interaktionsbrett;

public class Steuerung implements BeiAenderung {
    NutzerEingabe nutzerEingabe;
    Simulator simulator;
    SpielfeldDarstellung spielfeldDarstellung;

    public void Steuerung() {}

    public void Steuerung(NutzerEingabe nutzerEingabe,Simulator simulator,SpielfeldDarstellung spielfeldDarstellung) {
        this.nutzerEingabe = nutzerEingabe;
        this.simulator = simulator;
        this.spielfeldDarstellung = spielfeldDarstellung;
    }

    public void StartDesSpiels() {
        simulator.setAnzahlFelder(nutzerEingabe.anzahlZellenDesSpielfeldes());
        simulator.berechneAnfangsGeneration(simulator.anzahlFelder, nutzerEingabe.wahrscheinlichkeitDerBesiedlung());

        }

    public void initialisierung() {
        Interaktionsbrett ib = new Interaktionsbrett();
        EinUndAusgabe ea = new EinUndAusgabe();
        NutzerEingabe nutzerEingabe2 = new NutzerEingabe(ea);
        SpielfeldDarstellung spielfeldDarstellung2 = new SpielfeldDarstellung(ib);
        nutzerEingabe = nutzerEingabe2;
        spielfeldDarstellung = spielfeldDarstellung2;
    //    simulator.anmeldenFuerAktualisierungBeiAenderung();

/*
In  dieser  Methode  meldet  sich  das
Steuerung-Objekt  zudem  beim  Simulation-Objekt  an,  um  über  Änderungen  informiert  zu
werden.
 */

    }
    public void aktualisiere(boolean[][] neueGeneration) {
      spielfeldDarstellung.spielfeldDarstellen(neueGeneration);
    }
}
