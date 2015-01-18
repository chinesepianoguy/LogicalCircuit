package circuits;

import signals.Clock;
import signals.Event;
import signals.Signal;

import java.util.Set;

/**
 * Created by King on 2014-12-13.
 */
public class Or extends Gate {

    /**
     * Constructor
     * Initialize the inputs, output and delay of this OR gate
     *
     * @param inputs the second input
     * @param output the output
     * @param delay  the delay
     */
    public Or(Set<Signal> inputs, Signal output, int delay) {
        super(inputs, output, delay);
    }

    @Override
    public void activate() {
        boolean val = false;
        for (Signal input : inputs) {
            val = val || input.getValue();
        }
        if (output.getValue() != val) {
            output.addEvent(new Event(Clock.top() + delay, val));
        }
    }

}
