package recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueen
{
    public static void main(String[] args)
    {
        int n = 4;
        char[][] board = new char[n][n];
        List<List<String>> ans = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                board[i][j] = '.';
            }
        }
        solve(0, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);
    }

    // TC : O (n!)
    // SC : O (n^2)
    private static void solve(int col, char[][] board, List<List<String>> ans, int[] leftRow, int[] lowerDiagonal,
        int[] upperDiagonal, int n)
    {
        if (col == n)
        {
            ans.add(construct(board));
            return;
        }
        for (int row = 0; row < n; row++)
        {
            if (isSafe(col, leftRow, lowerDiagonal, upperDiagonal, n, row))
            {
                // place the queen
                placeQueen(col, board, leftRow, lowerDiagonal, upperDiagonal, n, row);

                // recursive call
                solve(col + 1, board, ans, leftRow, lowerDiagonal, upperDiagonal, n);

                // backtrack
                backTrack(col, board, leftRow, lowerDiagonal, upperDiagonal, n, row);
            }
        }
    }

    private static void backTrack(int col, char[][] board, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal, int n,
        int row)
    {
        board[row][col] = '.';
        leftRow[row] = 0;
        lowerDiagonal[row + col] = 0;
        upperDiagonal[n - 1 + col - row] = 0;
    }

    private static void placeQueen(int col, char[][] board, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal, int n,
        int row)
    {
        board[row][col] = 'Q';
        leftRow[row] = 1;
        lowerDiagonal[row + col] = 1;
        upperDiagonal[n - 1 + col - row] = 1;
    }

    private static boolean isSafe(int col, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal, int n, int row)
    {
        return leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0;
    }

    private static List<String> construct(char[][] board)
    {
        List<String> res = new ArrayList<>();
        for (char[] chars : board)
        {
            String s = new String(chars);
            res.add(s);
        }
        return res;
    }
}
