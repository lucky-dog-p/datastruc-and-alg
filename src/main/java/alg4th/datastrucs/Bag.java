package alg4th.datastrucs;

import java.util.Iterator;

/**
 * Bag is a kind of datastruct that only supposed to add,no deleting operation.<br>
 * This is a Bag implement using linl
 * @author  panguangze
 */
public class Bag<Item> implements Iterable<Item> {

    private ValueNode<Item> rootNode;
    private int N = 0;

    /**
     * Add value into the Bag.
     * @param value the value you want add
     */
    public void add(Item value){
        ValueNode<Item> oldRoot = rootNode;
        rootNode = new ValueNode<Item>(value);
        rootNode.next = oldRoot;
        this.N++;
    }

    /**
     * Return the size of the Bag.
     * @return  the size of bag
     */
    public int size(){
        return this.N;
    }

    /**
     * If the bag is empty.
     * @return boolean,if the bag is empty
     */
    public boolean isEmpty(){
        return this.rootNode == null;
    }

    /**
     * Get an iterator of the bag.
     * @return  a iterator of the bag
     */
    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item>{

        private ValueNode<Item> current = rootNode;
        @Override
        public boolean hasNext() {
            return current == null;
        }
        @Override
        public Item next() {
            Item temp = current.value;
            current = current.next;
            return temp;
        }
        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}