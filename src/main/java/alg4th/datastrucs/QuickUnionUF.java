package alg4th.datastrucs;

/**
 * QuickUnionUF with path compression.
 * @author  panguangze
 */
public class QuickUnionUF extends UnionFind{

    private int[] id;
    private int count;

    public QuickUnionUF(int N){
        id = new int[N];
        count = N;
        /*initialize the id array,that makes each elements' roots be itself */
        for(int i =0;i<N;i++){
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    @Override
    public int find(int p) {
        int temp = p;
        while(p != id[p]) p = id[p];

        int j;
        while(temp!=p){
            j = id[temp];
            id[temp] = p;
            temp = j;
        }
        return p;
    }

    @Override
    public int count() {
        return count;
    }
}