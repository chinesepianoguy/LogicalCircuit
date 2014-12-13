package main.circuits;

import main.signals.Signal;

/**
 * Created by King on 2014-12-13.
 */
public abstract class PorteADeuxEntrees extends Porte {

    protected Signal entree1, entree2;

    /**
     * Constructor
     * Initialize the inputs, output and delay of the gate
     * @param entree1 the first input
     * @param entree2 the second input
     * @param sortie the output
     * @param retard the delay
     */
    public PorteADeuxEntrees(Signal entree1, Signal entree2, Signal sortie, int retard) {
        super(sortie, retard);
        this.entree1 = entree1;
        this.entree2 = entree2;
    }

}
