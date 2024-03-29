package patterns;

public class Patterns
{
    public static void main(String[] args)
    {
        pattern18();
    }

    /**
     *     *****
     *     *****
     *     *****
     *     *****
     *     *****
     * **/
    public static void one()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("****");
        }
    }

    /**
     *     *
     *     **
     *     ***
     *     ****
     *     *****
     *
     * **/
    public static void two()
    {
        for (int row = 0 ; row <= 5 ; row++)
        {
            for (int column = 0; column < row; column++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     *     *****
     *     ****
     *     ***
     *     **
     *     *
     **/

    public static void three()
    {
        for (int row = 5; row >= 0; row--)
        {
            for (int column = row; column >= 0 ; column--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     *     1
     *     1 2
     *     1 2 3
     *     1 2 3 4
     *     1 2 3 4 5
     **/

    public static void four()
    {
        for (int row = 1; row <= 5; row++)
        {
            for (int column = 1; column <= row ; column++)
            {
                System.out.print(column);
            }
            System.out.println();
        }
    }

    /**
     *     *
     *     **
     *     ***
     *     ****
     *     *****
     *     ****
     *     ***
     *     **
     *     *
     **/
    
    public static void five()
    {
        for (int row = 0; row < 10; row++)
        {
            for (int coulmn = 0; coulmn < row && row <=5; coulmn++)
            {
                System.out.print("*");
            }

            for (int column = 0; column < (10 - row) && row > 5; column++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     *          *
     *         **
     *        ***
     *       ****
     *      *****
     **/
    public static void six()
    {
        int N = 5;
        for (int row = 1; row <= N; row++)
        {
            for (int space = 1; space <= (N - row) ; space++)
            {
                System.out.print(" ");
            }

            for (int coulmn = 1; coulmn <= row ; coulmn++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     *      *****
     *       ****
     *        ***
     *         **
     *          *
     **/
    public static void seven()
    {
        int N = 5;
        for (int row = N; row >= 0; row--)
        {
            for (int spcae = 0; spcae < (N - row); spcae++)
            {
                System.out.print(" ");
            }
            for (int column = row; column >= 0; column--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     *         *
     *        ***
     *       *****
     *      *******
     *     *********
     **/
    public static void eight()
    {
        int N = 5;
        for (int row = 1; row <= N; row++)
        {
            for (int spaces = row; spaces <= N; spaces++)
            {
                System.out.print(" ");
            }
            for (int stars = 1; stars <= 2 * row - 1; stars++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }


    /**
     *     *********
     *      *******
     *       *****
     *        ***
     *         *
     **/
    public static void nine()
    {
        int N = 6;
        for (int row = N; row >= 1; row--)
        {
            for (int space = 0; space <= (N - row); space++)
            {
                System.out.print(" ");
            }

            for (int stars = 1; stars <= 2 * row - 1; stars++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     *          *
     *         * *
     *        * * *
     *       * * * *
     *      * * * * *
     **/
    public static void ten()
    {
        int N = 6;

        for (int row = 1; row <= N; row++)
        {
            for (int spaces = 1  ; spaces <= N - row; spaces++)
            {
                System.out.print(" ");
            }

            for (int column = 1; column <= row; column++)
            {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /**
     *      * * * * *
     *       * * * *
     *        * * *
     *         * *
     *          *
     *          *
     * */
    public static void eleven()
    {
        int N = 6;

        for (int row = N; row >= 1; row--)
        {
            for (int spaces = 0  ; spaces <= N - row; spaces++)
            {
                System.out.print(" ");
            }

            for (int column = row; column >= 1; column--)
            {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    /**
     *      * * * * *
     *       * * * *
     *        * * *
     *         * *
     *          *
     *          *
     *         * *
     *        * * *
     *       * * * *
     *      * * * * *
     * */

    public static void tweleve()
    {
        int N = 6;

        for (int row = N; row >= 1; row--)
        {
            for (int spaces = 0  ; spaces <= N - row; spaces++)
            {
                System.out.print(" ");
            }

            for (int column = row; column >= 1; column--)
            {
                System.out.print("* ");
            }

            System.out.println();
        }
        for (int row = 1; row <= N; row++)
        {
            for (int spaces = 1  ; spaces <= N - row; spaces++)
            {
                System.out.print(" ");
            }

            for (int column = 1; column <= row; column++)
            {
                System.out.print(" *");
            }

            System.out.println();
        }
    }

    /**
     *          *
     *         * *
     *        *   *
     *       *     *
     *      *********
     *
     * **/
    public static void thirteen()
    {
        int N = 5;
        for (int row = 1; row <= N ; row++)
        {
            for (int space = 0; space <= (N - row); space++)
            {
                System.out.print(" ");
            }
            for (int coulmn = 1; coulmn <= (2 * row - 1); coulmn++)
            {

                if (coulmn == 1 || row == N || coulmn == (2 * row - 1))
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    /**
     *      *********
     *       *     *
     *        *   *
     *         * *
     *          *
     *
     * **/
    public static void fourteen()
    {
        int N = 5;
        for (int row = N; row >= 1 ; row--)
        {
            for (int space = 0; space <= (N - row); space++)
            {
                System.out.print(" ");
            }
            for (int coulmn = (2 * row - 1); coulmn >= 1; coulmn--)
            {

                if (coulmn == 1 || row == N || coulmn == (2 * row - 1))
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    /**
     *          *
     *         * *
     *        *   *
     *       *     *
     *       *      *
     *        *   *
     *         * *
     *          *
     *
     * **/
    public static void fifteen()
    {
        int N = 5;
        for (int row = 1; row <= N ; row++)
        {
            for (int space = 0; space <= (N - row); space++)
            {
                System.out.print(" ");
            }
            for (int coulmn = 1; coulmn <= (2 * row - 1); coulmn++)
            {

                if (coulmn == 1 || coulmn == (2 * row - 1))
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
        for (int row = N; row >= 1 ; row--)
        {
            for (int space = 0; space <= (N - row); space++)
            {
                System.out.print(" ");
            }
            for (int coulmn = (2 * row - 1); coulmn >= 1; coulmn--)
            {

                if (coulmn == 1 || coulmn == (2 * row - 1))
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    /**
    *                1
     *             1   1
     *           1   2   1
     *         1   3   3   1
     *       1   4   6   4   1
    *
    * */

    public static void sixteen()
    {
        int N = 5;
        int[][] triangle = new int[N][N];

        for (int i = 0; i < N; i++) {
            triangle[i][0] = 1; // First column is always 1
            triangle[i][i] = 1; // Last column is always 1

            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        for (int row = 0; row < N; row++)
        {
            for (int space = 0; space <= (N - row); space++)
            {
                System.out.print(" ");
            }
            for (int col = 0; col <= row; col++) {
                System.out.printf("%4d", triangle[row][col]); // Adjust spacing as needed
            }
            System.out.println();

        }
    }

    /**
     *          1
     *         212
     *        32123
     *       4321234
     *        32123
     *         212
     *          1
     *
     * */
    public static void pattern17()
    {
        int N = 4;
        for (int row = 1; row <= 2 * N - 1; row++)
        {

            int num = row <= N ? row : 2 * N - row;

            for (int space = 1; space <= N - num; space++)
            {
                System.out.print("  ");
            }
            for (int column = num; column >= 1; column--)
            {
                System.out.print(column + " ");
            }
            for (int column = 2 ; column <= num ; column++)
            {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public static void pattern18()
    {
        int size = 5;
        // Upper half
        for (int row = 1; row <= size; row++)
        {
            for (int col = 1; col <= size - row  + 1; col++)
            {
                System.out.print("*");
            }
            for (int space = 0; space < 2 * row - 2; space++)
            {
                System.out.print(" ");
            }
            for (int col = 1; col <= size - row + 1; col++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half
        for (int row = 1; row <= size ; row++)
        {
            for (int col = 1; col <= row ; col++)
            {
                System.out.print("*");
            }
            for (int space = 1; space <= 2 * (size - row); space++)
            {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }


}
