public class WeightedQuickUnionUF extends UnionFind {
    private int[] id;
    private int[] size;

    public WeightedQuickUnionUF(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    @Override
    public void union(int x, int y) {
        int i = root(x);
        int j = root(y);
        if (i == j)
            return;
        if(size[i] < size[j]) {
            id[i] = j;
            size[j] += size[i];
        } else {
            id[j] = i;
            size[i] += size[j];
        }
    }

    @Override
    public boolean find(int x, int y) {
        return root(x) == root(y);
    }

    /**
     * Weighted quick union can further be improved by path compression
     * It means that the nodes at the lower parts of the tree can be moved up to point to some parent at upper levels
     * to shorten the tree
     * There are two ways:
     * 1) Double Pass: find the root and point every node along the way from x to point to the root to flatten the tree
     * 2) single pass: point every node to point to its grand parent (just as good, with only one extra line i.e. id[i] = id[id[i]])
     *
     * weighted quick union with path compression has the complexity of N + M lg* N (M = number of Union or Find operations)
     * @param i
     * @return
     */
    private int root(int i) {
        while(i != id[i])
            i = id[i];
        return i;
    }
}
