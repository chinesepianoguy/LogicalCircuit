package signals;

/**
 * Created by King on 2014-12-12.
 */
public class Signal {

    private String name;
    private boolean value;
    private Driver driver;

    /**
     * Constructor
     * Initialize the current value of a signal and its driver
     *
     * @param value the value of current stimuli
     */
    public Signal(String name, boolean value) {
        this.name = name;
        this.value = value;
        driver = new Driver();
    }

    /**
     * Getter of name
     *
     * @return name
     */
    public String getName() {
        return name;
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
    public void actualize() {
        if (driver.timeOfEvent() != -1 && driver.timeOfEvent() == Clock.top()) {
            value = driver.pollEvent().getValue();
        }
    }

    @Override
    public String toString() {
        return name + ": " + value;
    }

}
