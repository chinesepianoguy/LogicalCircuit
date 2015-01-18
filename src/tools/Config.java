package tools;

import circuits.And;
import circuits.Circuit;
import circuits.Generator;
import circuits.Or;
import signals.Signal;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by King on 2015-01-17.
 */
public class Config {

    private Circuit circuit;
    private FileHandler fileHandler;

    /**
     * Constructor
     * Initialize the elements
     *
     * @param circuit the circuit to configure
     */
    public Config(Circuit circuit) {
        this.circuit = circuit;
        fileHandler = new FileHandler();
    }

    /**
     * Load the settings from a file
     *
     * @param filename filename required
     */
    public void loadSettings(String filename) {
        String[] ext = fileHandler.extract(filename);
        if (ext == null) return;
        for (String line : ext) {
            String[] seg = line.split("\t");
            Set<Signal> iss = new HashSet<>();
            Signal os;
            int delay;
            switch (seg[0].split(":")[1].trim().toLowerCase()) {
                case "and":
                    for (String s : seg[1].split(":")[1].split(",")) {
                        Signal is;
                        if (!circuit.signalExist(s.trim())) {
                            is = new Signal(s.trim(), false);
                            circuit.addSignal(is);
                        } else {
                            is = circuit.getSignalByName(s.trim());
                        }
                        iss.add(is);
                    }
                    if (!circuit.signalExist(seg[2].split(":")[1].trim())) {
                        os = new Signal(seg[2].split(":")[1].trim(), false);
                        circuit.addSignal(os);
                    } else {
                        os = circuit.getSignalByName(seg[2].split(":")[1].trim());
                    }
                    delay = Integer.parseInt(seg[3].split(":")[1].trim());
                    circuit.addGate(new And(iss, os, delay));
                    break;
                case "or":
                    for (String s : seg[1].split(":")[1].split(",")) {
                        Signal is;
                        if (!circuit.signalExist(s.trim())) {
                            is = new Signal(s.trim(), false);
                            circuit.addSignal(is);
                        } else {
                            is = circuit.getSignalByName(s.trim());
                        }
                        iss.add(is);
                    }
                    if (!circuit.signalExist(seg[2].split(":")[1].trim())) {
                        os = new Signal(seg[2].split(":")[1].trim(), false);
                        circuit.addSignal(os);
                    } else {
                        os = circuit.getSignalByName(seg[2].split(":")[1].trim());
                    }
                    delay = Integer.parseInt(seg[3].split(":")[1].trim());
                    circuit.addGate(new Or(iss, os, delay));
                    break;
                case "generator":
                    if (!circuit.signalExist(seg[1].split(":")[1].trim())) {
                        os = new Signal(seg[1].split(":")[1].trim(), false);
                        circuit.addSignal(os);
                    } else {
                        os = circuit.getSignalByName(seg[1].split(":")[1].trim());
                    }
                    int period = Integer.parseInt(seg[2].split(":")[1].trim());
                    float msr = Float.parseFloat(seg[3].split(":")[1].trim());
                    delay = Integer.parseInt(seg[4].split(":")[1].trim());
                    circuit.addGate(new Generator(os, period, msr, delay));
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Save the settings to a file
     *
     * @param filename filename required
     */
    public void saveSettings(String filename) {
        fileHandler.clear(filename);
        fileHandler.write(filename, circuit.toString().split("\r\n"));
    }

    /**
     * Save stimuli data to a file
     *
     * @param filename filename required
     */
    public void saveStimuli(String filename) {
        fileHandler.clear(filename);
        fileHandler.write(
                filename,
                circuit.getStimuli().toArray(new String[circuit.getStimuli().size()])
        );
    }

}
