package AB02.ui;

import AB02.util.Interaktionsbrett;

public class Quadrat {
    private int x;
    private int y;
    private int seitenlaenge;

    public Quadrat(int x, int y, int seitenlaenge) {
        this.x = x;
        this.y = y;
        this.seitenlaenge = seitenlaenge;
    }

    public void darstellenRahmen(Interaktionsbrett ib) {
        ib.neuesRechteck(x, y, seitenlaenge, seitenlaenge);
    }

    public void darstellenFuellung(Interaktionsbrett ib) {
        for (int i = 0; i < seitenlaenge; i++) {
            ib.neueLinie(x,y+i,x+seitenlaenge,y+i);
        }

    }

}
