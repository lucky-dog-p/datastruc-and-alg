package alg.datastructrue;
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
    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N;i++){
            temp[i] = this.array[i];
        }
        this.array = temp;
    }

    public void push(Item value){
        if(N == this.array.length){
            resize(2*this.array.length);
        }
        this.array[N++] = value;
    }

    public Item pop(){
        Item temp = this.array[--N];
        array[N] = null;
        if(N > 0&&N == this.array.length/4){
            resize(this.array.length/2);
        }
        return temp;
    }

    public Iterator<Item> iterator(){
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item>{
        private int N;
        public boolean hasNext(){return N >0;}
        public Item next(){return array[--N];}
        public void remove(){}
    }
    public static void main(String[] args) {
        ResizingArrayStack<Integer> rs = new ResizingArrayStack<Integer>();
        rs.push(3);
    }
}