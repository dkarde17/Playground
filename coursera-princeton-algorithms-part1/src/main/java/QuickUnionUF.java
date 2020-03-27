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
        id[i] = j;
    }

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
