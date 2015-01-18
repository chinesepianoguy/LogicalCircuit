package circuits;

import signals.Clock;
import signals.Event;
import signals.Signal;

/**
 * Created by King on 2015-01-08.
 */
public class Generator extends Gate {

    private int period;
    private double msr;

    /**
     * Constructor
     * initialize the elements
     *
     * @param output output
     * @param period period of signal
     * @param msr    mark-space ratio
     * @param delay  delay
     */
    public Generator(Signal output, int period, double msr, int delay) {
        super(null, output, delay);
        this.period = period;
        this.msr = msr;
    }

    /**
     * Activate the gate
     */
    @Override
    public void activate() {
        if (Clock.top() != 0) {
            if (Clock.top() % period == 0 || Clock.top() % period == (int) ((1 - msr / 100) * period)) {
                output.addEvent(new Event(Clock.top() + delay, !output.getValue()));
            }
        }
    }

    public String toString() {
        return "type: " + this.getClass().getSimpleName()
                + "\toutput: " + output.getName()
                + "\tperiod:" + period
                + "\tmsr: " + msr
                + "\tdelay: " + delay;
    }

}
