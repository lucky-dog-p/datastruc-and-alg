package alg4th.datastrucs;

/**
 * MinPQ
 */
public class MinPQ<Key extends Comparable<Key>> extends PriorityQueue<Key>{

    private Key[] array;
    private int N;

    /**
     * Create a empty minPQ. 
     */
    public MinPQ(){}

    /**
     * Create a minPQ of initial capacity N.
     */
    public MinPQ(int N){
        array = (Key[]) new Comparable[N + 1];
    }

    /**
     * Create a minPQ from the keys in a[].
     */
    public MinPQ(Key[] array){

    }

    @Override
    public void insert(Key k) {

    }

    @Override
    public boolean isEmpty() {
        return N==0;
    }

    @Override
    public int size() {
        return N;
    }

    public Key min(){
        return array[1];
    }

    public Key delMin(){

    }

    private 
}