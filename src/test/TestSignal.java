package test;

import main.signals.Event;
import main.signals.Horloge;
import main.signals.Signal;

/**
 * Created by King on 2014-12-12.
 */
public class TestSignal {

    /**
     * Test of signal simulation of the signal
     */
    public static void runTest(){
        // declare a signal and assignment of input stimuli
        Signal s = new Signal(false);
        s.addEvent(new Event(3, true));
        s.addEvent(new Event(5, false));
        s.addEvent(new Event(9, true));
        // simulation
        Horloge.reset();
        int n = 100;
        for (int i = 0; i < n; i++) {
            s.actualise();
            System.out.println(
                    "Au temps\t["
                    + Horloge.top() + "],\tla valeur du signal est\t["
                    + s.getValue() + "]."
            );
            Horloge.increment();
        }
    }

}
