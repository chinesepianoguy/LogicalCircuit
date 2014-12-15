package simulators;

import circuits.And;
import circuits.Circuit;
import circuits.Gate;
import circuits.Or;
import signals.Event;
import signals.Signal;

/**
 * Created by King on 2014-12-13.
 */
public class TestCircuit {

    /**
     * Run the simulation of the circuit
     */
    public static void main(String[] args){
        // definition of a circuit and declaration of the signals
        Circuit c = new Circuit();
        Signal  s1 = new Signal(false),
                s2 = new Signal(false),
                s3 = new Signal(false),
                s4 = new Signal(false),
                s5 = new Signal(false);

        // definition of the stimuli in the signals of inputs s1, s2 and s4
        s1.addEvent(new Event(3, true));
        s2.addEvent(new Event(7, true));
        s4.addEvent(new Event(4, true));
        // ...add some others events

        // add signals to the circuit
        c.addSignal(s1);
        c.addSignal(s2);
        c.addSignal(s3);
        c.addSignal(s4);
        c.addSignal(s5);

        // declaration of gates
        Gate    g1 = new And(s1, s2, s3, 1),
                g2 = new Or(s3, s4, s5, 1);

        // add gates to the circuit
        c.addGate(g1);
        c.addGate(g2);

        // simulation
        int tMax = 100;
        c.simulate(tMax);
    }

}
