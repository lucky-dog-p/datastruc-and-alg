package alg4th.datastrucs;

/**
<<<<<<< HEAD
 * PriorityQueue,The abstract super class of queues.<br>
 * @author  panguangze
 */
public abstract class PriorityQueue {

    public abstract void insert();
=======
 * PriorityQueue,A datastructrue that always get the min or max value.<br>
 * the Key must implement Comparable interface
 * @author  panguangze
 */
public abstract class PriorityQueue<Key extends Comparable<Key>>{

    /**
     * Insert a key into PQ.
     * @param k the key you want insert
     */
    public abstract void insert(Key k);

    /**
     * If the PQ is empty.
     * @return  whether the PQ is empty
     */
    public abstract boolean isEmpty();

    /**
     * The number of key in the PQ.
     * @return  the number of key in the PQ
     */
    public abstract int size();
>>>>>>> 3942ea52283f42edc11e1783bd30e87d03d8654e
}