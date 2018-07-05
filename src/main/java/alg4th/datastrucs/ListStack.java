package alg4th.datastrucs;

import java.util.Iterator;

/**
 * Using List to implement Stack.
 * @author  panguangze
 */
public class ListStack<Item> extends Stack<Item> {
    private Node root;
    private int N = 0;

    @Override
    public int size(){
        return N;
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    private class Node{
        public Item value;
        public Node next;
        public Node(Item value){
            this.value = value;
        }
    }

    @Override
    public void push(Item value) {
        Node oldRoot = root;
        root = new Node(value);
        root.next = oldRoot;
        N++;
    }

    @Override
    public Item pop() {
        Item temp = root.value;
        root = root.next;
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
        private Node current = root;
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