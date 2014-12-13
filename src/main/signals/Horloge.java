package main.signals;

/**
 * Created by King on 2014-12-12.
 */
public class Horloge {

    private static int simTime;

    /**
     * Reset the simulating moments
     */
    public static void reset() {
        simTime = 0;
    }

    /**
     * Get the latest simulating moment
     *
     * @return simTime
     */
    public static int top() {
        return simTime;
    }

    /**
     * An increment of the simulating time
     */
    public static void increment() {
        simTime++;
    }

}
