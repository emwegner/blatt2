package AB02.ui;

import AB02.util.Interaktionsbrett;

public class SpielfeldDarstellung {
    private Interaktionsbrett ib;
    public final int wert = 30;
    public final int margin = 1;

    public SpielfeldDarstellung(Interaktionsbrett ib) {
        this.ib = ib;

    }

    public void spielfeldDarstellen(boolean[][] spielfeld) {

        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                Quadrat q = new Quadrat(wert * i + margin, j * wert + margin);
                if (spielfeld[i][j]) {
                    q.darstellenRahmen(ib);
                } else {
                    q.darstellenFuellung(ib);
                }
            }
        }
    }

    public void abwischen() {
        ib.abwischen();
    }
}
