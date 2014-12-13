package main.circuits;

import main.signals.Signal;

/**
 * Created by King on 2014-12-12.
 */
public abstract class Porte {

    private Signal entree1, entree2, sortie;

    public Porte(Signal entree1, Signal entree2, Signal sortie){
        this.entree1 = entree1;
        this.entree2 = entree2;
        this.sortie = sortie;
    }

    public abstract void calSortie();

}
