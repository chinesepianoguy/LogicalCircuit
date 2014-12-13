package main.circuits;

import main.signals.Clock;
import main.signals.Event;
import main.signals.Signal;

/**
 * Created by King on 2014-12-13.
 */
public class And extends GateWithTwoInputs {

    /**
     * Constructor
     * Initialize the inputs, output and delay of this AND gate
     *
     * @param input1 the first input
     * @param input2 the second input
     * @param output the output
     * @param delay  the delay
     */
    public And(Signal input1, Signal input2, Signal output, int delay) {
        super(input1, input2, output, delay);
    }

    /**
     * Calculate the output of this AND gate
     */
    @Override
    public void activate() {
        if (output.getValue() != input1.getValue() && input2.getValue()) {
            output.addEvent(
                    new Event(
                            Clock.top() + delay,
                            input1.getValue() && input2.getValue()
                    )
            );
        }
    }

}
