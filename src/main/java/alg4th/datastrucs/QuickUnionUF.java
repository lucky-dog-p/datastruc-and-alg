package alg4th.datastrucs;

/**
 * QuickUnionUF
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
        int pId = id[p];
        int qId = id[q];

        if(pId == qId) return;
        for(int i = 0;i < id.length;i++){
            if(id[i] == pId) id[i] = qId;
        }
        /*The number of components  reduce 1*/
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}