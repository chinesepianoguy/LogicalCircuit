package main.circuits;

import main.signals.Signal;

/**
 * Created by King on 2014-12-13.
 */
public abstract class GateWithTwoInputs extends Gate {

    protected Signal input1, input2;

    /**
     * Constructor
     * Initialize the inputs, output and delay of this gate
     *
     * @param input1 the first input
     * @param input2 the second input
     * @param output the output
     * @param delay  the delay
     */
    public GateWithTwoInputs(Signal input1, Signal input2, Signal output, int delay) {
        super(output, delay);
        this.input1 = input1;
        this.input2 = input2;
    }

}
