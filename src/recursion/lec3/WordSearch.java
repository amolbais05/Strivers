package recursion.lec3;

public class WordSearch
{
    public static void main(String[] args)
    {
        char[][] board = {{'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}};

        String word = "ABCCED";

        boolean res = exist(board, word);
        System.out.println(res);
    }

    private static boolean exist(char[][] board, String word)
    {
        int rowNr = board.length;
        int colNr = board[0].length;

        int index = 0;

        for (int row = 0; row < rowNr; row++)
        {
            for (int col = 0; col < colNr; col++)
            {
                if (board[row][col] == word.charAt(0))
                {
                    if (search(board, word, row, col, index, rowNr, colNr))
                    {
                        return true;
                    }

                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, String word, int row, int col, int index, int rowNr, int colNr)
    {
        // if index reaches at the end that means we have found the word
        if (index == word.length())
        {
            return true;
        }

        // Checking the boundaries if the character at which we are placed is not the required character
        if (row < 0 || col < 0 || row == rowNr || col == colNr || board[row][col] != word.charAt(index) || board[row][col] == '!')
        {
            return false;
        }

        // this is to prevent reusing of the same character
        char c = board[row][col];
        board[row][col] = '!';

        // top, right, bottom, left
        boolean top = search(board, word, row - 1, col, index + 1, rowNr, colNr);
        boolean right = search(board, word, row, col + 1, index + 1, rowNr, colNr);
        boolean bottom = search(board, word, row + 1, col, index + 1, rowNr, colNr);
        boolean left = search(board, word, row, col - 1, index + 1, rowNr, colNr);

        board[row][col] = c; // backtrack

        return top || right || bottom || left;

    }
}
