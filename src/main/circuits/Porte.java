package main.circuits;

import main.signals.Signal;

/**
 * Created by King on 2014-12-12.
 */
public abstract class Porte {

    protected Signal sortie;
    protected int retard;

    public Porte(Signal sortie, int retard){
        this.sortie = sortie;
        this.retard = retard;
    }

    public abstract void activate();

}
