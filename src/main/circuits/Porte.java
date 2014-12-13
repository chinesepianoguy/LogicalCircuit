package main.circuits;

import main.signals.Signal;

/**
 * Created by King on 2014-12-12.
 */
public abstract class Porte {

    protected Signal sortie;
    protected int retard;

    /**
     * Constructor
     * Initialize the output and the delay of the gate
     * @param sortie the output of the gate
     * @param retard the delay of the gate
     */
    public Porte(Signal sortie, int retard) {
        this.sortie = sortie;
        this.retard = retard;
    }

    /**
     * An abstract method
     * Activate the gate
     */
    public abstract void activate();

}
