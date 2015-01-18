package simulators;

import circuits.*;
import signals.Clock;
import signals.Event;
import signals.Signal;
import tools.Config;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by King on 2014-12-13.
 */
public class TestCircuit {

    private static Circuit c;

    /**
     * Run the simulation of the circuit
     */
    public static void main(String[] args) {
        // definition of a circuit and declaration of the signals
        c = new Circuit();

        Signal s1 = new Signal("s1", false),
                s2 = new Signal("s2", false),
                s3 = new Signal("s3", false),
                s4 = new Signal("s4", false),
                s5 = new Signal("s5", false);
        //System.out.println(s1);

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
        Set<Signal> iAnd = new HashSet<Signal>();
        iAnd.add(s1);
        iAnd.add(s2);

        Set<Signal> iOr = new HashSet<Signal>();
        iOr.add(s3);
        iOr.add(s4);

        Gate g1 = new And(iAnd, s3, 1),
                g2 = new Or(iOr, s5, 1),
                g3 = new Generator(s1, 4, 25, 1),
                g4 = new Generator(s2, 3, 33.3, 1),
                g5 = new Generator(s4, 6, 27.7, 1);
        //System.out.println(g5);

        // add gates to the circuit
        c.addGate(g1);
        c.addGate(g2);
        c.addGate(g3);
        c.addGate(g4);
        c.addGate(g5);

        // simulation
        Config config = new Config(c);
        if (new File("src/data/customize.cfg").exists()) {
            config.loadSettings("src/data/customize.cfg");
        } else {
            config.loadSettings("src/data/default.cfg");
            config.saveSettings("src/data/customize.cfg");    //save default settings to a customized one
        }
        int tMax = 100;
        simulate(tMax);
        config.saveStimuli("src/data/stimuli.dat");
    }

    /**
     * Simulation of this circuit
     *
     * @param tMax max time of simulation
     */
    public static void simulate(int tMax) {
        Clock.reset();
        //readData("config.dat");
        for (int i = 0; i < tMax; i++) {
            c.actualizeSignals(); // actualization of all signals
            c.activateGates();    // activation of all gates
            System.out.print(Clock.top());
            String str = "" + i;
            for (Signal s : c.getSignals()) {
                System.out.print("\t" + s);
                str += "\t" + s;
            }
            c.addStimuli(str);
            System.out.println();
            Clock.increment();
        }
        //writeConfig();
    }

}
