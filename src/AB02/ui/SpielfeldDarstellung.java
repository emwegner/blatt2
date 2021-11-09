package AB02.ui;

import AB02.util.Interaktionsbrett;

public class SpielfeldDarstellung {
    public Interaktionsbrett ib;
    public int wert = 300;
    public int margin;
    public void spielfeldDarstellung(Interaktionsbrett ib) {

    }

    public void spielfeldDarstellen(boolean[][] spielfeld) {
        /*
        fügen Sie eine ganzzahlige Konstante für die Seitenlängen des
        Darstellungsbereichs auf dem Interaktionsbrett ein. Ist dieser Wert bspw. 300 und soll das
        Spielfeld  10*10  Zellen  betragen,  dann  wird  jede  Zelle  als  Quadrat-Objekt  mit  einer
        Ausdehnung von 30*30 angezeigt. Fügen Sie zudem eine ganzzahlige Konstante Margin
        ein,  um  einen  Abstand  zwischen  dem  Spielfeld  und  dem  Zeichenbereich  des
        Interaktionsbretts einzuführen. Diese konstanten Werte sind beim Zeichnen der Quadrat-
        Objekte zu berücksichtigen.
         */

        for(int i = 0; i < spielfeld.length;i++) {
            for(int j = 0; j < spielfeld[i].length; j++) {
                if(spielfeld[i][j] == true) {
                   Quadrat q = new Quadrat(i,j);
                   q.darstellenRahmen(ib);
                } else {
                    Quadrat q = new Quadrat(i,j);
                    q.darstellenFuellung(ib);
                }
            }
        }
    }

    public void abwischen() {
        ib.abwischen();
    }
}
