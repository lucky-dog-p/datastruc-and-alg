package alg4th.datastrucs;

/**
 * maxPQ,max priority queue
 */
public class ArrayMaxPQ<Key extends Comparable<Key>> extends PriorityQueue<Key>{

    private Key[] array;
    private int N;

    /**
     * Create a maxPQ of initial capacity N.
     */
    public ArrayMaxPQ(int N){
        array = (Key[]) new Comparable[N + 1];
    }

    /**
     * Create a maxPQ from the keys in array[].
     */
    public ArrayMaxPQ(Key[] array){
        this.array = (Key[]) new Comparable[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            this.array[i+1] = array[i];
        }
        for(int i = this.array.length/2; i >=1;i--){
            sink(i);
        }
    }

    @Override
    public void insert(Key k) {

        array[++N] = k;
        swim(N);
    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    public Key m(){
        return array[1];
    }

    public Key delmax(){
        Key temp = array[1];
        exchange(1,N--);
        array[N+1] = null;
        sink(1);
        return temp;
    }

    private void swim(int i){
        while(i > 1 && less(i/2, i)){
            exchange(i, i/2);
            i = i/2;
        }
    }

    private void sink(int i){
        while(2*i <= N){
            int j = 2*i;
            //choose the smaller child node
            if(j<N && less(j, j+1)) j++;
            //if current node is less than its children nodes,break
            if(!less(i, j)) break;
            //else change the value and go on sinking.
            exchange(i, j);
            i = j;
        }
    }

    private void exchange(int i,int j){
        Key temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    private boolean less(int i,int j){
        return array[i].compareTo(array[j]) < 0;
    }
}