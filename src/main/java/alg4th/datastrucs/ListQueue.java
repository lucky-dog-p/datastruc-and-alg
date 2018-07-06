package alg4th.datastrucs;

import java.util.Iterator;

/**
 * ListQueue,implement by linklist.<br>
 * @author  panguangze
 */
public class ListQueue<Item> extends Queue<Item>{

    private ValueNode rootNode;
    private int N;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void push(Item value) {
        
    }

    @Override
    public Item pop() {
        return null;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ListQueueIterator implements Iterator<Item>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}