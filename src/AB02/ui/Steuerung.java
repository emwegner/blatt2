package AB02.ui;

import AB02.logik.BeiAenderung;
import AB02.logik.Simulation;
import AB02.util.EinUndAusgabe;
import AB02.util.Interaktionsbrett;

public class Steuerung implements BeiAenderung {
    public void StartDesSpiels() {
        NutzerEingabe nutzerEingabe = new NutzerEingabe();
        nutzerEingabe.anzahlZellenDesSpielfeldes();
        nutzerEingabe.wahrscheinlichkeitDerBesiedlung();
/*
Das Steuerung-Objekt ruft dann die Methode
berechneAnfangsGeneration(anzahlZellen,
wahrscheinlichkeitDerBesiedlung)  der  Instanzvariable  vom  Typ
Simulation auf
 */

        }

    public void initialisierung() {
        Interaktionsbrett ib = new Interaktionsbrett();
        EinUndAusgabe ea = new EinUndAusgabe();
/*
und übergibt diese an die Konstruktoren der
NutzerEingabe  bzw.  SpielfeldDarstellung.  In  dieser  Methode  meldet  sich  das
Steuerung-Objekt  zudem  beim  Simulation-Objekt  an,  um  über  Änderungen  informiert  zu
werden.
 */

    }
    public void aktualisiere(boolean[][] neueGeneration) {
        SpielfeldDarstellung sd = new SpielfeldDarstellung();
        sd.spielfeldDarstellen(neueGeneration);
    }
}
