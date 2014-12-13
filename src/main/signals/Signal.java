package main.signals;

/**
 * Created by King on 2014-12-12.
 */
public class Signal {

    private boolean value;
    private Driver driver;

    /**
     * Constructor
     * Initialize the current value of a signal and its driver
     *
     * @param value the value of current stimuli
     */
    public Signal(boolean value) {
        this.value = value;
        driver = new Driver();
    }

    /**
     * Getter of value.
     */
    public boolean getValue() {
        return value;
    }

    /**
     * Add an event to driver.
     *
     * @param event the specified event to add
     */
    public void addEvent(Event event) {
        driver.addEvent(event);
    }

    /**
     * Update the value of the signal if an event occurs.
     */
    public void actualise() {
        if (driver.timeOfEvent() != -1 && driver.timeOfEvent() == Clock.top()) {
            value = driver.pollEvent().getValue();
        }
    }

}
