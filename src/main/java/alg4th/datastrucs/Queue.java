package alg4th.datastrucs;

/**
 * Queue,an abstract super class.<br>
 * @author  panguangze 
 */
public abstract class Queue<Item> implements Iterable<Item> {

    /**
     * This method push a value into a queue.<br>
     * @param value the value you want push
     */
    public abstract void push(Item value);

    /**
     * Pop an element on the push order.<br>
     * @return  An element of type Item
     */
    public abstract Item pop();

    /**
     * Get the size of the queue.<br>
     * @return  The number of the queue
     */
    public  abstract int size();

    /**
     * If the queue is empty.<br>
     * @return  whether the queue is empty
     */
    public abstract boolean isEmpty();
}