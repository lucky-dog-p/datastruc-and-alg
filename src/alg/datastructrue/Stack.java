package alg.datastructrue;

/**
 * This is the abstract Stack class.
 * @author  panguangze
 */
public abstract class Stack<Item> implements Iterable<Item>{

     /**
     * return size of the stack.
     * @return The size of the stack
     */
    public abstract int size();

    /**
     * Push the value into the stack.
     * @param  value The value you want add to the stack
     */
    public abstract void push(Item value);

    /**
     * Pop the value from the stack
     * @return  The last value you push into the stack
     */
    public abstract Item pop();

    /**
     * @return  If the stack is empty
     */
    public abstract boolean isEmpty();
}