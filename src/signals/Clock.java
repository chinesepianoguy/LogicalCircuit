package signals;

/**
 * Created by King on 2014-12-12.
 */
public class Clock {

    private static int time;

    /**
     * Reset the simulating moments
     */
    public static void reset() {
        time = 0;
    }

    /**
     * Get the latest simulating moment
     *
     * @return time
     */
    public static int top() {
        return time;
    }

    /**
     * An increment of the simulating time
     */
    public static void increment() {
        time++;
    }

}
