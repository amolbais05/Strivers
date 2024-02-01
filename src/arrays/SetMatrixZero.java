package arrays;

public class SetMatrixZero
{
    public static void main(String[] args)
    {
        int [][] matrix = {
            {1,1,1},
            {1,0,1},
            {1,1,1}};


        int length = matrix.length;
        for (int row = 0 ; row < length ; row++)
        {
            for (int column = 0 ; column < length ; column++)
            {
                if (matrix[row][column] == 0)
                {
                    
                }
            }

        }


        printMatrix(length, matrix);


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

    public static void setZeroes(int[][] matrix) {

    }

}
