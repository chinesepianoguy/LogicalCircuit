package main.circuits;

import main.signals.Signal;

/**
 * Created by King on 2014-12-12.
 */
public abstract class Gate {

    protected Signal output;
    protected int delay;

    /**
     * Constructor
     * Initialize the output and the delay of the gate
     *
     * @param output the output of the gate
     * @param delay  the delay of the gate
     */
    public Gate(Signal output, int delay) {
        this.output = output;
        this.delay = delay;
    }

    /**
     * An abstract method
     * Activate the gate
     */
    public abstract void activate();

}
