package circuits;

import signals.Signal;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by King on 2014-12-13.
 */
public class Circuit {

    private ArrayList<Gate> gates;
    private ArrayList<Signal> signals;
    private ArrayList<String> stimuli;

    /**
     * Constructor
     * Initialize gates and signals
     */
    public Circuit() {
        gates = new ArrayList<>();
        signals = new ArrayList<>();
        stimuli = new ArrayList<>();
    }

    /**
     * Getter of all signals of the circuit
     *
     * @return a set of signals
     */
    public ArrayList<Signal> getSignals() {
        return signals;
    }

    /**
     * Fetch a signal by it's name
     *
     * @param name name required
     * @return signal required or null if not exists
     */
    public Signal getSignalByName(String name) {
        for (Signal s : signals) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Detect the existence of a signal by a name
     *
     * @param name name of signal required
     * @return true if exists or false if not
     */
    public boolean signalExist(String name) {
        for (Signal s : signals) {
            if (s.getName().equals(name))
                return true;
        }
        return false;
    }

    /**
     * Getter of all gates of the circuit
     *
     * @return a set of gates
     */
    public ArrayList<Gate> getGates() {
        return gates;
    }

    /**
     * Getter of all stimuli of the circuit
     *
     * @return all stimuli in a list form
     */
    public ArrayList<String> getStimuli() {
        return stimuli;
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
     * @param g the gate to add
     */
    public void addGate(Gate g) {
        gates.add(g);
    }

    public void addStimuli(String s) {
        stimuli.add(s);
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

    @Override
    public String toString() {
        String str = "";
        Iterator<Gate> iterator = gates.iterator();
        while (iterator.hasNext()) {
            str += iterator.next() + (iterator.hasNext() ? "\r\n" : "");
        }
        return str;
    }

}
