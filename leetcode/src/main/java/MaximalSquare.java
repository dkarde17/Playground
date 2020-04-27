public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0 )
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxSide = 0;
        for(int i = 0; i < n; i++) {
            int j = 0;
            dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
            if(dp[i][j] > maxSide)
                maxSide = dp[i][j];
        }
        for(int j = 0; j < m; j++) {
            int i = 0;
            dp[i][j] = matrix[i][j] == '1' ? 1 : 0;
            if(dp[i][j] > maxSide)
                maxSide = dp[i][j];
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(matrix[i][j] == '1')
                    dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                else dp[i][j] = 0;
                if(dp[i][j] > maxSide)
                    maxSide = dp[i][j];
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] matrix = {{'1'}};
        System.out.println(maximalSquare.maximalSquare(matrix));
    }
}
