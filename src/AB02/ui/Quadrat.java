package AB02.ui;

import AB02.util.Interaktionsbrett;

public class Quadrat {
    int x;
    int y;
    int seitenlaenge;

    public Quadrat(int x, int y) {
        this.x = x;
        this.y = y;
        seitenlaenge = aktualisiereSeitenlaenge();
    }

    public void setX(int x) {
        this.x = x;
        seitenlaenge = aktualisiereSeitenlaenge();
    }

    public void setY(int y) {
        this.y = y;
        seitenlaenge = aktualisiereSeitenlaenge();
    }

    public int aktualisiereSeitenlaenge() {
        int temp;
        if( x < y) temp = y-x;
        else temp = x-y;
        return temp;
    }

    public void darstellenRahmen(Interaktionsbrett ib) {
        ib.neuesRechteck(x, y, seitenlaenge, seitenlaenge);
    }

    public void darstellenFuellung(Interaktionsbrett ib) {
        for (int i = 0; i < seitenlaenge; i++) {
            ib.neueLinie(x,i,y,i);
        }

    }

}
