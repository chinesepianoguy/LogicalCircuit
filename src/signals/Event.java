package signals;

/**
 * Created by King on 2014-12-12.
 */
public class Event implements Comparable {

    private boolean value;
    private int time;

    /**
     * Constructor
     *
     * @param time  the moment when this even occurs
     * @param value the updating value of the signal
     */
    public Event(int time, boolean value) {
        this.time = time;
        this.value = value;
    }

    /**
     * Getter of value
     *
     * @return value
     */
    public boolean getValue() {
        return value;
    }

    /**
     * Getter of time
     *
     * @return time
     */
    public int getTime() {
        return time;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {    // necessary for sorting
        int time = ((Event) o).getTime();
        if (this.time > time) {
            return 1;
        } else if (this.time == time) {
            return 0;
        } else {
            return -1;
        }
    }
}