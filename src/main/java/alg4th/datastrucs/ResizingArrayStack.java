package alg.datastructrue;
import java.util.Iterator;
/**
 * This is a Stack class that using array to implemment.
 * @author  panguangze
 */
public class ResizingArrayStack<Item> extends Stack<Item>{
    private Item[] array = (Item[]) new Object[1];
    private int N = 0;

    @Override
    public int size(){
        return N;
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    /*Resizing the array */
    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N;i++){
            temp[i] = this.array[i];
        }
        this.array = temp;
    }

    @Override
    public void push(Item value){
        if(N == this.array.length){
            resize(2*this.array.length);
        }
        this.array[N++] = value;
    }

    @Override
    public Item pop(){
        Item temp = this.array[--N];
        array[N] = null;
        if(N > 0&&N == this.array.length/4){
            resize(this.array.length/2);
        }
        return temp;
    }

    /**
     * @return  An iterator of the stack
     */
    @Override
    public Iterator<Item> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext(){
            return i >0;
        }

        @Override
        public Item next(){
            return array[--i];
        }

        @Override
        public void remove(){}
    }
}