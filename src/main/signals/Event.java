package main.signals;

/**
 * Created by King on 2014-12-12.
 */
public class Event {

    private boolean value;
    private int time;

    /**
     * Constructor
     * @param time the moment when this even occurs
     * @param value the updating value of the signal
     */
    public Event(int time, boolean value) {
        this.time = time;
        this.value = value;
    }

    /**
     * Getter of value
     * @return value
     */
    public boolean getValue() {
        return value;
    }

    /**
     * Getter of time
     * @return time
     */
    public int getTime() {
        return time;
    }

}