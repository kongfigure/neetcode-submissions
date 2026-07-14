class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        char[][] board = new char[n][n];
        for(char[]row: board) Arrays.fill(row, '.');

        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>(); // r+c
        Set<Integer> negDiag = new HashSet<>(); // r-c

        backtrack(0, n, board, cols, posDiag, negDiag, results);
        return results;
    }

    private void backtrack (int row, int n, char[][]board, Set<Integer>cols,
                            Set<Integer> posDiag, Set<Integer> negDiag, List<List<String>> results) {
        if(row == n) {
            results.add(buildBoard(board));
            return;
        }
        for(int col = 0; col < n; col++) {
            if(cols.contains(col) || posDiag.contains(row + col) || negDiag.contains(row - col)) {
                continue;
            }
            board[row][col] = 'Q';
            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);

            backtrack(row + 1, n, board, cols, posDiag, negDiag, results);

            board[row][col] = '.';
            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
        }     
    }

    private List<String> buildBoard(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row: board) {
            result.add(new String(row));
        }
        return result;
    }
}
