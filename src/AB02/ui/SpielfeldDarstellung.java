package AB02.ui;

import AB02.util.Interaktionsbrett;

public class SpielfeldDarstellung {
    private Interaktionsbrett ib;
    private final int wert = 50;
    private final int margin = 1;

    public SpielfeldDarstellung(Interaktionsbrett ib) {
        this.ib = ib;

    }

    public void spielfeldDarstellen(boolean[][] spielfeld) {
        int seitenlaenge = wert / spielfeld.length;
        for (int i = 0; i < spielfeld.length; i++) {
            for (int j = 0; j < spielfeld[i].length; j++) {
                Quadrat q = new Quadrat(wert * i + margin, j * wert + margin, wert);
                if (spielfeld[i][j]) {
                    q.darstellenFuellung(ib);
                } else {
                    q.darstellenRahmen(ib);
                }
            }
        }
    }

    public void abwischen() {
        ib.abwischen();
    }
}
