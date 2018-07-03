import java.util.Iterator;
/**
 * 
 * public
 *      push
 *      pop
 *      isEmpty
 *      size
 *      iterator
 * private
 *      resizing
 *      
 * 
 */
public class ResizingArrayStack<Item> implements Iterable<Item>{
    private Item[] array = (Item[]) new Object[1];
    private int N = 0;

    public int size(){
        return N;
    }
    private resize(){
        Item[] temp = (Item[]) new Object[2*this.array.length];
        for(int i = 0; i < this.array.length;i++){
            temp[i] = this.array[i];
        }
        this.array = temp;
    }

    public void push(Item value){
        if(size() >= this.array.length-1){
            resize();
        }
        this.array[size()+1] = value;
    }

    public Item pop(){
        
        return this.array[size()];
    }

    public Iterator iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
        private int N;
        public boolean hasNext(){return N >0;}
        public Item Next(){return array[--N];}
    }
}