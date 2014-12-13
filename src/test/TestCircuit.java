package test;

import main.circuits.And;
import main.circuits.Circuit;
import main.circuits.Or;
import main.circuits.Porte;
import main.signals.Event;
import main.signals.Horloge;
import main.signals.Signal;

/**
 * Created by King on 2014-12-13.
 */
public class TestCircuit {

    public static void runTest(){
        Circuit c = new Circuit();
        Signal  s1 = new Signal(false),
                s2 = new Signal(false),
                s3 = new Signal(false),
                s4 = new Signal(false),
                s5 = new Signal(false);

        s1.addEvent(new Event(3, true));
        s2.addEvent(new Event(7, true));
        s4.addEvent(new Event(4, true));

        c.addSignal(s1);
        c.addSignal(s2);
        c.addSignal(s3);
        c.addSignal(s4);
        c.addSignal(s5);

        Porte p1 = new And(s1, s2, s3, 1);
        Porte p2 = new Or(s3, s4, s5, 2);

        c.addPorte(p1);
        c.addPorte(p2);

        int tMax = 100;

        Horloge.reset();
        for (int i = 0; i < tMax; i++) {
            c.actualiseSignals();
            c.activatePortes();
            System.out.print(Horloge.top());
            for (Signal s : c.getSignals()) {
                System.out.print("\t" + s.getValue());
            }
            System.out.println();
            Horloge.increment();
        }
    }

}
