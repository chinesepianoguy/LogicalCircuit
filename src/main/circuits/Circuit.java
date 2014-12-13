package main.circuits;

import main.signals.Horloge;
import main.signals.Signal;

import java.util.ArrayList;

/**
 * Created by King on 2014-12-13.
 */
public class Circuit {

    private ArrayList<Porte> portes;
    private ArrayList<Signal> signals;

    /**
     * Constructor
     * Initialize the portes and signals
     */
    public Circuit() {
        portes = new ArrayList<Porte>();
        signals = new ArrayList<Signal>();
    }

    /**
     * Add a signal to the circuit
     * @param s the signal to add
     */
    public void addSignal(Signal s) {
        signals.add(s);
    }

    /**
     * Add a gate to the circuit
     * @param p the gate to add
     */
    public void addPorte(Porte p) {
        portes.add(p);
    }

    /**
     * Update all the signals of the circuit
     */
    public void actualiseSignals() {
        for (Signal s : signals) {
            s.actualise();
        }
    }

    /**
     * Activate all the gates of the circuit
     */
    public void activatePortes() {
        for (Porte p : portes) {
            p.activate();
        }
    }

    /**
     * Getter of all the signals of the circuits
     * @return all signals in a list form
     */
    public ArrayList<Signal> getSignals() {
        return signals;
    }

    /**
     * Simulation of this circuit
     * @param tMax max time of simulation
     */
    public void simule(int tMax){
        Horloge.reset();
        for (int i = 0; i < tMax; i++) {
            actualiseSignals();
            activatePortes();
            System.out.print(Horloge.top());
            for (Signal s : getSignals()) {
                System.out.print("\t" + s.getValue());
            }
            System.out.println();
            Horloge.increment();
        }
    }

}
