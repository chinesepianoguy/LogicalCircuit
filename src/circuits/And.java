package circuits;

import signals.Clock;
import signals.Event;
import signals.Signal;

import java.util.Set;

/**
 * Created by King on 2014-12-13.
 */
public class And extends Gate {

    /**
     * Constructor
     * Initialize the inputs, output and delay of this AND gate
     *
     * @param inputs the inputs
     * @param output the output
     * @param delay  the delay
     */
    public And(Set<Signal> inputs, Signal output, int delay) {
        super(inputs, output, delay);
    }

    /**
     * Calculate the output of this AND gate
     */
    @Override
    public void activate() {
        boolean val = true;
        for (Signal input : inputs) {
            val = val && input.getValue();
        }
        if (output.getValue() != val) {
            output.addEvent(new Event(Clock.top() + delay, val));
        }
    }

}
