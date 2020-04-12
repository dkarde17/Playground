package union_find;

public class QuickUnionUF extends UnionFind {

    private int[] id;

    public QuickUnionUF(int n) {
        id = new int[n];
        for(int i = 0; i < n; i++)
            id[i] = i;
    }

    @Override
    public void union(int x, int y) {
        int i = root(x);
        int j = root(y);
        if (i == j)
            return;
        id[i] = j;
    }

    /**
     * quick union can further be improved by path compression
     * It means that the nodes at the lower parts of the tree can be moved up to point to some parent at upper levels
     * to shorten the tree
     * There are two ways:
     * 1) Double Pass: find the root and point every node along the way from x to point to the root to flatten the tree
     * 2) single pass: point every node to point to its grand parent (just as good, with only one extra line i.e. id[i] = id[id[i]])
     *
     * quick union with path compression has the complexity of N + M lg N (M = number of Union or Find operations)
     * @param i
     * @return
     */
    private int root(int i) {
        while (i != id[i])
            i = id[i];
        return i;
    }

    @Override
    public boolean find(int x, int y) {
        return root(x) == root(y);
    }
}
