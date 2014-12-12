package main.signals;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by King on 2014-12-12.
 */
public class Driver {

    private Queue<Event> events;    //FIFO

    /**
     * Constructor
     * Initialize the queue of events (FIFO)
     * */
    public Driver() {
        events = new LinkedList<Event>();
    }

    /**
     * Add/Insert an event to the queue (FIFO)
     * @param event the event to add
     * */
    public void addEvent(Event event) {
        events.offer(event);
    }

    /**
     * Consultation of the moment when the event occurs
     * @return the moment ou -1 if the event queue is empty
     * */
    public int timeOfEvent() {
        return (events.peek() == null) ? -1 : events.peek().getTime();
    }

    /**
     * Retrieve the event and delete it from the head of queue
     * @return the event retrieved from the head of queue
     * */
    public Event pollEvent() {
        return events.poll();
    }

}
