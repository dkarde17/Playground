public class QuickFindUF extends UnionFInd{
    private int[] id;
    public QuickFindUF(int n) {
        id = new int[n];
        initializeArray(id, n);
    }

    private void initializeArray(int[] ar, int n) {
        for (int i = 0; i < n; i++) {
            ar[i] = i;
        }
    }

    //quick-find
    public boolean find(int x, int y) {
        return id[x] == id[y];
    }

    public void union(int x, int y) {
        int idx = id[x];
        int idy = id[y];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idx)
                id[i] = idy;
        }
    }
}
