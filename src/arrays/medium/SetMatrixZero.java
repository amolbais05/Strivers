package arrays.medium;


public class SetMatrixZero
{
    public static void main(String[] args)
    {
        int[][] arr = {{1,1,1},{1,0,1},{1,1,1}};
        bruteForce(arr);

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
    }


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
