package alg4th.datastrucs;

import java.util.Iterator;

/**
 * Using List to implement Stack.
 * @author  panguangze
 */
public class ListStack<Item> extends Stack<Item> {
    private ValueNode<Item> rootNode;
    private int N = 0;

    @Override
    public int size(){
        return N;
    }

    @Override
    public boolean isEmpty() {
        return rootNode==null;
    }

    @Override
    public void push(Item value) {
        ValueNode<Item> oldRoot = rootNode;
        rootNode = new ValueNode<Item>(value);
        rootNode.next = oldRoot;
        N++;
    }

    @Override
    public Item pop() {
        Item temp = rootNode.value;
        rootNode = rootNode.next;
        N--;
        return temp;
    }

    /**
     * @return  An iterator of the stack
     */
    @Override
    public Iterator<Item> iterator() {
        return new ListStackIterator();
    }

    private class ListStackIterator implements Iterator<Item>{

        /*copy the root */
        private ValueNode<Item> current = rootNode;
        @Override
        public boolean hasNext() {
            return !(current == null);
        }

        @Override
        public Item next() {
            Item temp = current.value;
            current = current.next;
            return temp;
        }

        @Override
        public void remove() {}
    }
}