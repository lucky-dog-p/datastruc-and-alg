package alg4th.datastrucs;

/**
 * UnionFind,The abstract super class of all unionfinds class.<br>
 * @author  panguangze
 */
public abstract class UnionFind {

    /**
     * Union two elements.
     * @param p element you want union
     * @param q another one you want union
     */
    public abstract void union(int p, int q);
    /**
     * Component identifier for p.
     * @param p element you want find
     * @return  The identifier of p
     */
    public abstract int find(int p);
    /**
     * if the p and q is connected.
     * @return  whether p and q is connected
     */
    public abstract boolean connected(int p, int q);
    /**
     * number of components
     * @return number of components in the UF set
     */
    public abstract int count();
}