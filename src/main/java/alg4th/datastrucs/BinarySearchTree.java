package alg4th.datastrucs;

/**
 * BinarySearchTree,A sample binary search tree.
 * @author  panguangze
 */
public class BinarySearchTree<Key extends Comparable<Key>,Value>{

    private Node rootNode;

    private class Node{
        public Key key;
        public Value val;
        public Node left;
        public Node right;
        //how many children nodes that the node has
        private int N;

        public Node(Key key,Value val,int N){
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    /**
     * Put the key-value pair into the binaryST.
     */
    public void put(Key key,Value val){
        if(rootNode == null){
            rootNode = new Node(key, val, 1);
            return;
        }
        Node temp = rootNode;
        while(temp != null){
            int cmp = key.compareTo(temp.key);
            if(cmp > 0){
                temp = temp.right;
            }else if(cmp < 0){
                temp = temp.left;
            }else{
                temp.val = val;
            }
            //size add
            temp.N++;
        }
        temp = new Node(key, val, 1);

    }

    public Value get(Key key){
        Node temp = rootNode;
        while(temp != null){
            int cmp = key.compareTo(temp.key);
            if(cmp > 0){
                temp = temp.right;
            }else if(cmp < 0){
                temp = temp.left;
            }else{
                break;
            }
        }
        if(temp == null) return null;
        return temp.val;
    }

    public boolean contains(Key key){
        return get(key) == null;
    }

    public boolean isEmpty(){
        return rootNode == null;
    }

    public int size(){
        return size(rootNode);
    }

    private int size(Node x){
        if(x == null) return 0;
        return x.N;
    }

    public Key min(){
        return min(rootNode).key;
    }

    private Node min(Node x){
        if(x.left == null)   return x;
        return min(x.left); 
    }

    public Key max(){
        return max(rootNode).key;
    }

    private Node max(Node x){
        if(x.right == null)   return x;
        return max(x.right);
    }

    public Key floor(Key key){
        Node x = floor(rootNode, key);
        if(x == null) return null;
        return x.key;
    }

    private Node floor(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp < 0) floor(x.left,key);
        Node temp = floor(x.right, key);
        if(temp != null) return temp;
        return x;
    }

    public Key ceiling(Key key){
        Node x = ceiling(rootNode, key);
        if(x == null) return null;
        return x.key;
    }

    private Node ceiling(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return x;
        if(cmp > 0) floor(x.right,key);
        Node temp = floor(x.left, key);
        if(temp != null) return temp;
        return x;
    }

    public int rank(Key key){
        return rank(rootNode,key);
    }

    private int rank(Node x,Key key){
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)         return 1+ rank(x.right,key) + size(x.left);
        else if(cmp < 0)    return rank(x.left,key);
        else                return size(x);
    }

    public Key select(int k){
        return select(rootNode,k).key;
    }

    private Node select(Node x,int k){
        if(x == null)   return null;
        // int tempk = rank(x.key);
        // if(tempk > k)       return select(x.left,k);
        // else if(tempk < k)  return select(x.right,k);
        // else                return x.key;
        int temp = size(x.left);
        if(temp > k)    return select(x.left, k);
        if(temp < k)    return select(x, k - temp -1);
        else            return x;
    }

    public void deleteMin(){
        rootNode = deleteMin(rootNode);
    }

    private Node deleteMin(Node x){
        if(x.left==null)    return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }

    public void deleteMax(){
        rootNode = deleteMax(rootNode);
    }

    private Node deleteMax(Node x){
        if(x.right==null)    return x.left;
        x.right = deleteMin(x.right);
        x.N = size(x.left) + size(x.right) +1;
        return x;
    }

    public void delete(Key key){
        delete(rootNode,key);
    }

    private Node delete(Node x,Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)         x.right = delete(x.right, key);
        else if(cmp < 0)    x.left = delete(x.left, key);
        else{
            if(x.right == null) return x.left;
            if(x.left == null)  return x.right;
            Node temp = x;
            x.right = deleteMin(temp.right);
            x.left = temp.left;
        }
        x.N = size(x.left) + size(x.right)+1;
        return x;
    }

    public int size(Key lo,Key hi){
        return rank(hi) - rank(lo);
    }

    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new ListQueue<Key>();
        keys(queue, lo, hi, rootNode);
        return queue;
    }

    public Iterable<Key> keys(){
        return keys(min(), max());
    }

    private void keys(Queue<Key> queue,Key lo,Key hi,Node x){
        if(x == null)   return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        //if cmplo is < 0 that means x.left-children-tree may have some nodes between lo and hi
        if(cmplo < 0)   keys(queue,lo,hi,x.left);
        if(cmplo >0 && cmphi < 0)   queue.push(x.key);
        if(cmphi > 0)   keys(queue,lo,hi,x.right);
    }
}