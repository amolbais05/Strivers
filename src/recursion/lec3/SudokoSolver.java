package recursion.lec3;

public class SudokoSolver
{
    public void solveSudoku(char[][] board)
    {
        solve(board);
    }

    private boolean solve(char[][] board)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == '.')
                {
                    for (char ch = '1'; ch <= '9'; ch++)
                    {
                        if (isValid(board, i, j, ch))
                        {
                            board[i][j] = ch;

                            if (solve(board))
                            {
                                return true;
                            }
                            else
                            {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int row, int col, char ch)
    {
        for (int i = 0; i < 9; i++)
        {
            // check row
            if (board[i][col] == ch)
            {
                return false;
            }

            // check column
            if (board[row][i] == ch)
            {
                return false;
            }
            // check 3x3 subgrid
            int subRow = 3 * (row / 3) + i / 3;
            int subCol = 3 * (col / 3) + i % 3;
            if (board[subRow][subCol] == ch)
            {
                return false;
            }
        }
        return true;
    }
}
