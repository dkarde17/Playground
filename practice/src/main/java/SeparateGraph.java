import java.util.List;

public class SeparateGraph {
    int count;

    public Counts solve(Node root) {
        Counts res = new Counts();
        if (root.children != null && root.children.size() > 0) {
            root.children.forEach(node -> {
                Counts counts = solve(node);
                if (counts.red == 0 || counts.blue == 0)
                    ++count;
                res.red += counts.red;
                res.blue += counts.blue;
            });
        } else {
            if (root.color == 1)
                ++res.red;
            else if (root.color == 2)
                ++res.blue;
        }
        return res;
    }

    private static class Node {
        int color;
        List<Node> children;
    }

    private static class Counts {
        int red;
        int blue;
    }
}
