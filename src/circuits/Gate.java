package circuits;

import signals.Signal;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by King on 2014-12-12.
 */
public abstract class Gate {

    protected Set<Signal> inputs;
    protected Signal output;
    protected int delay;

    /**
     * Constructor
     * Initialize the inputs / output and the delay of this gate
     *
     * @param inputs the input signals
     * @param output the output signal
     * @param delay  delay
     */
    public Gate(Set<Signal> inputs, Signal output, int delay) {
        this.inputs = inputs;
        this.output = output;
        this.delay = delay;
    }

    /**
     * An abstract method
     * Activate the gate
     */
    public abstract void activate();

    @Override
    public String toString() {
        String iNames = "";
        Iterator<Signal> iterator = inputs.iterator();
        while (iterator.hasNext()) {
            iNames += iterator.next().getName() + (iterator.hasNext() ? ", " : "");
        }
        return "type: " + this.getClass().getSimpleName()
                + "\tinputs: " + iNames
                + "\toutput: " + output.getName()
                + "\tdelay: " + delay;
    }

}
