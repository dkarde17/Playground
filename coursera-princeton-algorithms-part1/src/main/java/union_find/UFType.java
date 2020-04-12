package union_find;

public enum UFType {
    QUICK_FIND("QF"),
    QUICK_UNION("QU"),
    WEIGHTED_QUICK_UNION("WQU")
    ;

    String value;

    UFType(String qu) {
        value = qu;
    }

    public static UFType ofValue(String type) {
        UFType answer = null;
        for (UFType ufType :
                UFType.values()) {
            if (type.equals(ufType.value)) {
                answer = ufType;
                break;
            }
        }
        return answer;
    }

    public UnionFind getUF(int numberOfNodes) {
        UnionFind unionFind = null;
        switch (value) {
            case "QF":
                unionFind = new QuickFindUF(numberOfNodes);
                break;
            case "QU":
                unionFind = new QuickUnionUF(numberOfNodes);
                break;
            case "WQU":
                unionFind = new WeightedQuickUnionUF(numberOfNodes);
                break;
            default:
                throw new IllegalStateException("invalid type of value = " + value);
        }
        return unionFind;
    }
}
