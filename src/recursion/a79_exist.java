package recursion;

public class a79_exist {
    char[] w;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        this.w = w;
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(int i, int j, int index) {
        //base case
        if (index == w.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || w[index] != board[i][j]) {
            return false;
        }
        //标记当前这个格子已经走过了
        char tmp = board[i][j];
        board[i][j] = 0;
        //尝试其他的格子
        boolean ans = exist(i - 1, j, index + 1) ||
                exist(i + 1, j, index + 1) ||
                exist(i, j - 1, index + 1) ||
                exist(i, j + 1, index + 1);
        board[i][j] = tmp;
        return ans;
    }


}
