package arrays.medium;


public class SetMatrixZero
{
    public static void main(String[] args)
    {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        //bruteForce(arr);
        //better(arr);
        optimal(arr);
    }


    private static void bruteForce(int[][] matrix)
    {
        int length = matrix.length;
        for (int row = 0; row < length; row++)
        {
            for (int column = 0; column < length; column++)
            {
                if (matrix[row][column] == 0)
                {
                    for (int i = 0; i < length; i++)
                    {
                        if (matrix[row][i] != 0)
                        {
                            matrix[row][i] = -1;
                        }
                        if (matrix[i][column] != 0)
                        {
                            matrix[i][column] = -1;
                        }
                    }
                }
            }
        }

        for (int row = 0; row < length; row++)
        {
            for (int column = 0; column < length; column++)
            {
                if (matrix[row][column] == -1)
                {
                    matrix[row][column] = 0;
                }
            }
        }
        printMatrix(length, matrix);
    }
    // TC : O(2NM)
    // SC : O(N) + O(M)

    private static void better(int[][] matrix)
    {
        int length = matrix.length;
        int[] row = new int[length];
        int[] column = new int[length];


        // First pass to mark the rows and columns that need to be zeroed
        for (int rw = 0; rw < length; rw++)
        {
            for (int clm = 0; clm < length; clm++)
            {
                if (matrix[rw][clm] == 0)
                {
                    row[rw] = 1;
                    column[clm] = 1;
                }
            }
        }

        // Second pass to zero out the marked rows and columns
        for (int rw = 0; rw < length; rw++)
        {
            for (int clm = 0; clm < length; clm++)
            {
                if (row[rw] == 1 || column[clm] == 1)
                {
                    matrix[rw][clm] = 0;
                }
            }
        }
        printMatrix(length, matrix);
    }
    // TC : O(2NM)
    // SC : O(N) + O(M)

    private static void optimal(int[][] matrix)
    {
        int length = matrix.length;
        int col0 = 1;

        // Step 1: Mark rows and columns that need to be zeroed
        for (int row = 0; row < length; row++)
        {
            for (int column = 0; column < matrix[row].length; column++)
            {
                if (matrix[row][column] == 0)
                {
                    matrix[row][0] = 0;
                    if (column != 0)
                    {
                        matrix[0][column] = 0;
                    }
                    else
                    {
                        col0 = 0; // special case only if column is 0
                    }
                }

            }
        }
        // Step 2: Zero out the marked rows and columns
        for (int row = length - 1; row >= 0; row--)
        {
            for (int column = matrix[row].length - 1; column >= 1; column--) // skip 0th column
            {
                if (matrix[row][0] == 0 || matrix[0][column] == 0)
                {
                    matrix[row][column] = 0;
                }
            }
            if (col0 == 0)
            {
                matrix[row][0] = 0;
            }

        }

        printMatrix(length, matrix);
    }
    // TC : O(2NM)
    // SC : O(1)


    private static void printMatrix(int length, int[][] matrix)
    {
        for (int row = 0; row < length; row++)
        {
            for (int column = 0; column < length; column++)
            {
                System.out.print(" " + matrix[row][column]);
            }
            System.out.println();
        }
    }
}
