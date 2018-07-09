package alg4th.datastrucs;

import java.util.Iterator;

/**
 * ListQueue,implement by linklist.<br>
 * @author  panguangze
 */
public class ListQueue<Item> extends Queue<Item>{

    private ValueNode<Item> headNode;
    private ValueNode<Item> tailNode;
    private int N;

    @Override
    public int size() {
        return N;
    }

    @Override
    public boolean isEmpty() {
        return tailNode == null;
    }

    @Override
    public void push(Item value) {
        ValueNode<Item> temp = new ValueNode<Item>(value);
        if(headNode == tailNode){
            tailNode = temp;
            headNode = temp;
            N = 1;
            return;
        }
        headNode = headNode.next;
        N++;
    }

    @Override
    public Item pop() {
        if(tailNode == null){
            return null;
        }
        Item temp = tailNode.value;
        tailNode = tailNode.next;
        return temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListQueueIterator();
    }

    private class ListQueueIterator implements Iterator<Item>{

        private ValueNode<Item> currentTail = tailNode;
        @Override
        public boolean hasNext() {
            return currentTail != null;
        }

        @Override
        public Item next() {
            Item temp = currentTail.value;
            currentTail = currentTail.next;
            return temp;
        }

        @Override
        public void remove() {
        }
    }
}