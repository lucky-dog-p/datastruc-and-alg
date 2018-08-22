package alg4th.datastrucs;

/**
 * RedBlackTree???Implement the 2-3 node tree by RB tree.
 * @author  panguangze
 */
public class RedBlackTree<Key extends Comparable<Key>,Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node rootNode;
    private class Node{
        Key key;
        Value val;
        boolean color;
        Node left,right;
        int N;
        public Node(Key key,Value val,int N,boolean color){
            this.key = key;
            this.val = val;
            this.color = color;
            this.N = N;
        }
    }
    
    private boolean isRed(Node x){
        if(x == null)   return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.right) + size(h.left);
        return h;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.right) + size(h.left);
        return h;
    }

    private Node moveRedLeft(Node h){
        flipColor(h);
        //assert if h.right is a 3-node. if it is, move h to h.left and move one of h.right to h
        if (isRed(h.left.left)) { 
            h = rotateRight(h);
            flipColor(h);
        }
        return h;
    }

    private Node moveRedRight(Node h){
        flipColor(h);
        //assert if h.right is a 3-node. if it is, move h to h.left and move one of h.right to h
        if (isRed(h.right.left)) { 
            h = rotateLeft(h);
            flipColor(h);
        }
        return h;
    }

    private void flipColor(Node h){
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    private Node balance(Node h){
        if(isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.right) && isRed(h.left))     flipColor(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public void put(Key key,Value val){
        rootNode = put(rootNode,key, val);
        rootNode.color = BLACK;
    }

    private Node put(Node h,Key key,Value val){
        if(h == null)   return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if(cmp > 0) h.right = put(h.right,key, val);
        else if(cmp < 0)   h.left = put(h.left, key, val);
        else h.val = val;

        if(isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.right) && isRed(h.left))     flipColor(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
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

    public void delete(Key key){

    }

    private Node delete(Node x,Key key){
        if(x == null)   return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0)     x.right = delete(x.right, key);
        else if(cmp < 0)    x.left = delete(x.left, key);
        else{
            
        }
    }

    public boolean contains(Key key){
        return get(key) == null;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size(rootNode);
    }

    private int size(Node x){
        if(x == null)   return 0;
        return size(x.left) + size(x.right) +1;
    }
    public Key min(){
        return min(rootNode).key;
    }

    private Node min(Node x){
        if(x.left == null)  return x;
        return min(x.left);
    }

    public Key max(){
       return max(rootNode).key;
    }

    private Node max(Node x){
        if(x.right == null) return x;
        return max(x.right);
    }

    public Key floor(Key key){
        return floor(rootNode,key).key;
    }

    private Node floor(Node x,Key key){
        if(x == null)   return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)        return x;
        else if(cmp < 0)    return floor(x.left, key);
        Node temp = floor(x.right, key);
        if(temp != null)    return  temp;
        return x;
    }

    public Key ceiling(Key key){
        return ceiling(rootNode,key).key;
    }

    private Node ceiling(Node x,Key key){
        if(x == null)   return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)        return x;
        else if(cmp > 0)    return floor(x.right, key);
        Node temp = floor(x.left, key);
        if(temp != null)    return  temp;
        return x;
    }

    public int rank(Key key){
        return  rank(rootNode,key);
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
        if(x == null)  return null;
        int temp = size(x.left);
        if(temp > k)    return select(x.left,k);
        if(temp < k)    return select(x.right,k - temp -1);
        return x;  
    }

    public void deleteMin(){
        if(!isRed(rootNode.left) && isRed(rootNode.right))
            rootNode.color = RED;
        rootNode = deleteMin(rootNode);
        if(!isEmpty())
            rootNode.color = BLACK;
    }

    private Node deleteMin(Node x){
       if(!isRed(x.left) && !isRed(x.left.left)){
           x = moveRedLeft(x);
       }
       x.left = deleteMin(x.left);
       return balance(x);
    }

    public void deleteMax(){
        if(!isRed(rootNode.left) && !isRed(rootNode.right))
            rootNode.color = RED;
        rootNode = deleteMax(rootNode);
        if(!isEmpty())
            rootNode.color = BLACK;
    }

    private Node deleteMax(Node x){
        if(isRed(x.left))
            x = rotateRight(x);
        if(x.right == null)
            return null;

        if(!isRed(x.right) && !isRed(x.right.left)){
            x = moveRedRight(x);
        }
        x.right = deleteMax(x.right);
        return balance(x);
    }

    public int size(Key lo,Key hi){
        return rank(lo) - rank(hi);
    }

    public Iterable<Key> keys(Key lo,Key hi){
        Queue<Key> queue = new ListQueue<Key>();
        keys(rootNode, queue, lo, hi);
        return queue;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new ListQueue<Key>();
        keys(rootNode, queue, min(), max());
        return queue;
    }

    private void keys(Node x,Queue<Key> queue,Key lo,Key hi){
        if(x == null)    return;
        int cmplo = x.key.compareTo(lo);
        int cmphi = x.key.compareTo(hi);
        if(cmplo < 0)   keys(x.right, queue, lo, hi);
        if(cmplo >=0 && cmphi <=0) queue.push(x.key);
        if(cmphi > 0)   keys(x.left,queue,lo,hi);
    }
}