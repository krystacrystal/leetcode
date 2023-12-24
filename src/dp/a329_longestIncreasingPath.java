package dp;

public class a329_longestIncreasingPath {

    int[][] matrix;
    int[][] dp;

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        this.matrix = matrix;
        this.dp = dp;
        int maxPath = 0;
        //尝试从每一个格子出发
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxPath = Math.max(longestIncreasingPath(i, j), maxPath);
            }
        }
        return maxPath;
    }

    //从(i,j)这个格子出发，走出的最长路径返回
    public int longestIncreasingPath(int i, int j) {
        int next = 0;
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        //往左走
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            next = Math.max(next, longestIncreasingPath(i, j - 1));
        }
        //往上走
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            next = Math.max(next, longestIncreasingPath(i - 1, j));
        }
        //往右走
        if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            next = Math.max(next, longestIncreasingPath(i, j + 1));
        }
        //往下走
        if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            next = Math.max(next, longestIncreasingPath(i + 1, j));
        }
        dp[i][j] = next + 1;
        return next + 1;
    }
}
