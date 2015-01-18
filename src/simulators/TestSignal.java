package simulators;

import signals.Clock;
import signals.Event;
import signals.Signal;

/**
 * Created by King on 2014-12-12.
 */
public class TestSignal {

    /**
     * Test of signal simulation of the signal
     */
    public static void main(String[] args) {
        // declare a signal and assignment of input stimuli
        Signal s = new Signal("s", false);
        s.addEvent(new Event(5, false));
        s.addEvent(new Event(3, true));
        s.addEvent(new Event(9, true));
        // simulation
        Clock.reset();
        int n = 10;
        for (int i = 0; i < n; i++) {
            s.actualize();
            System.out.println(
                    "Au temps " + Clock.top() + ", la valeur du signal est " + s.getValue()
            );
            Clock.increment();
        }
    }

}
