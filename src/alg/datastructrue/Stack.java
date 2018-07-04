package alg.datastructrue;

/**
 * This is the abstract Stack class.
 * @author  panguangze
 */
public abstract class Stack<Item> implements Iterable<Item>{

    private int N;
    public int size(){return N;};
    public abstract void push(Item value);
    public abstract Item pop();
    /**
     * @return  If the stack is empty
     */
    public boolean isEmpty(){
        return N==0;
    }
}