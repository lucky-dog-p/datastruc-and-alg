package alg4th.datastrucs;

import java.util.Iterator;

/**
 * CircularQueue,implement a queue using array.<br>
 * This is a size limited queue
 * @author  panguangze
 */
public class CircularQueue<Item> extends Queue<Item>{

    private Item[] array;
    private int head;
    private int tail;
    private int maxSize;
    /**
     * @param N the initial size of the queue.
     */
    public CircularQueue(int N){
        this.maxSize = N;
        this.array = (Item[]) new Object[N];
        this.head = 0;
        this.tail = 0;
    }

    @Override
    public int size() {
        return (tail - head+maxSize)%maxSize;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void push(Item value) {
        if(size() == maxSize){
            return;
        }
        array[tail] = value;
        tail = (tail + 1)%maxSize;
    }

    @Override
    public Item pop() {
        if(head == tail){
            return null;
        }
        Item temp = array[head];
        head = (head + 1)%maxSize;
        return temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new CircularQueueIterator();
    }

    private class CircularQueueIterator implements Iterator<Item>{

        private int qHead = head;
        private int qTail = tail;
        @Override
        public boolean hasNext() {
            return qHead != qTail;
        }

        @Override
        public Item next() {
            if(qTail >= maxSize -1 ){
                tail = 1;
            }
            return array[qTail++];
        }

        @Override
        public void remove() {

        }
    }
}