package alg4th.datastrucs;

/**
 * WeightedQuickUnionUF with path compression.
 * @author  panguangze
 */
public class WeightedQuickUnionUF extends  UnionFind{

    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N){
        id = new int[N];
        sz = new int[N];
        count = N;
        /*initialize the id array,that makes each elements' roots be itself */
        for(int i =0;i<N;i++){
            id[i] = i;
        }
        for(int i = 0;i<N;i++){
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot) return;
        if(sz[pRoot] < sz[qRoot]){
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else{
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
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