package circuits;

import signals.Clock;
import signals.Signal;

import java.util.ArrayList;

/**
 * Created by King on 2014-12-13.
 */
public class Circuit {

    private ArrayList<Gate> gates;
    private ArrayList<Signal> signals;

    /**
     * Constructor
     * Initialize gates and signals
     */
    public Circuit() {
        gates = new ArrayList<Gate>();
        signals = new ArrayList<Signal>();
    }

    /**
     * Add a signal to the circuit
     *
     * @param s the signal to add
     */
    public void addSignal(Signal s) {
        signals.add(s);
    }

    /**
     * Add a gate to the circuit
     *
     * @param p the gate to add
     */
    public void addGate(Gate p) {
        gates.add(p);
    }

    /**
     * Update all signals of the circuit
     */
    public void actualizeSignals() {
        for (Signal signal : signals) {
            signal.actualize();
        }
    }

    /**
     * Activate all gates of the circuit
     */
    public void activateGates() {
        for (Gate gate : gates) {
            gate.activate();
        }
    }

    /**
     * Getter of all signals of the circuits
     *
     * @return all signals in a list form
     */
    public ArrayList<Signal> getSignals() {
        return signals;
    }

    /**
     * Simulation of this circuit
     *
     * @param tMax max time of simulation
     */
    public void simulate(int tMax) {
        Clock.reset();
        for (int i = 0; i < tMax; i++) {
            actualizeSignals();
            activateGates();
            System.out.print(Clock.top());
            for (Signal s : getSignals()) {
                System.out.print("\t" + s.getValue());
            }
            System.out.println();
            Clock.increment();
        }
    }

}
