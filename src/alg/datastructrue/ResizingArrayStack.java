package alg.datastructrue;
import java.util.Iterator;
/**
 * This is a Stack class that using array to implemment.
 * @author  panguangze
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] array = (Item[]) new Object[1];
    private int N = 0;
    /**
     * @return  the size of stack
     */
    public int size(){
        return N;
    }
    /*Resizing the array */
    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N;i++){
            temp[i] = this.array[i];
        }
        this.array = temp;
    }

    /**
     * Push the value into the stack.
     * @param  value The value you want add to the stack
     */
    public void push(Item value){
        if(N == this.array.length){
            resize(2*this.array.length);
        }
        this.array[N++] = value;
    }

    /**
     * Pop the value from the stack
     * @return  The last value you push into the stack
     */
    public Item pop(){
        Item temp = this.array[--N];
        array[N] = null;
        if(N > 0&&N == this.array.length/4){
            resize(this.array.length/2);
        }
        return temp;
    }

    /**
     * @return  The iterator of the stack
     */
    public Iterator<Item> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
        private int N;
        public boolean hasNext(){return N >0;}
        public Item next(){return array[--N];}
        public void remove(){}
    }
}