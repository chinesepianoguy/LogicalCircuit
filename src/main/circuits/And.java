package main.circuits;

import main.signals.Event;
import main.signals.Horloge;
import main.signals.Signal;

/**
 * Created by King on 2014-12-13.
 */
public class And extends PorteADeuxEntrees {

    /**
     * Constructor
     * Initialize the inputs, output and delay of this AND gate
     * @param entree1
     * @param entree2
     * @param sortie
     * @param retard
     */
    public And(Signal entree1, Signal entree2, Signal sortie, int retard) {
        super(entree1, entree2, sortie, retard);
    }

    /**
     * Calculate the output of this AND gate
     */
    @Override
    public void activate() {
        if (sortie.getValue() != entree1.getValue() && entree2.getValue()) {
            sortie.addEvent(
                    new Event(
                            Horloge.top() + retard,
                            entree1.getValue() && entree2.getValue()
                    )
            );
        }
    }

}
