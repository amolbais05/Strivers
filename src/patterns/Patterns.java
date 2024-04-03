package patterns;

public class Patterns
{
    public static void main(String[] args)
    {
        pattern34();
    }

    /**
     *     *****
     *     *****
     *     *****
     *     *****
     *     *****
     * **/
    public static void pattern1()
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
    public static void pattern2()
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

    public static void pattern3()
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

    public static void pattern4()
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
    
    public static void pattern5()
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
    public static void pattern6()
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
    public static void pattern7()
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
    public static void pattern8()
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
    public static void pattern9()
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
    public static void pattern10()
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
    public static void pattern11()
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

    public static void pattern12()
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
    public static void pattern13()
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
    public static void pattern14()
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
    public static void pattern15()
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

    public static void pattern16()
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

    /**
     *       **********
     *       ****  ****
     *       ***    ***
     *       **      **
     *       *        *
     *       *        *
     *       **      **
     *       ***    ***
     *       ****  ****
     *       **********
     *
     * **/
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

    /**
     *        *        *
     *        **      **
     *        ***    ***
     *        ****  ****
     *        **********
     *        ****  ****
     *        ***    ***
     *        **      **
     *        *        *
     *
     * **/
    public static void pattern19()
    {
        int size = 5;
        // Upper half
        for (int row = 1; row <= size; row++)
        {
            for (int col = 1; col <= row; col++)
            {
                System.out.print("*");
            }
            for (int space = 1; space <= 2 * (size - row) ; space++)
            {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half
        for (int row = 1; row <= size ; row++)
        {
            for (int col = 1; col <= size - row + 1 ; col++)
            {
                System.out.print("*");
            }
            for (int space = 1; space <= 2 * row - 2; space++)
            {
                System.out.print(" ");
            }
            for (int col = 1; col <= size - row + 1; col++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     *        ****
     *        *  *
     *        *  *
     *        *  *
     *        ****
     * **/
    public static void pattern20()
    {
        int size = 5;
        for (int row = 1; row <= 5; row++)
        {
            for (int col = 1; col < size; col++)
            {
                if ((row == 1 || row == 5) || (col == 1 || col == (size -1)))
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
     *        1
     *        2  3
     *        4  5  6
     *        7  8  9  10
     *        11 12 13 14 15
     * **/
    public static void pattern21()
    {
        int count = 1;
        int size = 6;
        for (int row = 1; row <= size ; row++)
        {
            for (int col = 1; col <= row ; col++)
            {
                System.out.print(count++ +" ");
            }
            System.out.println();
        }
    }

    /**
     *        1
     *        0 1
     *        1 0 1
     *        0 1 0 1
     *        1 0 1 0 1
     * **/
    public static void pattern22()
    {
        int size = 5;
        int print = 0;
        for (int row = 1; row <= size ; row++)
        {
            for (int col = 1; col <= row ; col++)
            {
                //print = 1 - print;
                print ^= 1;
                System.out.print(print + " ");
            }
            System.out.println();
        }
    }

    /**
     *            *      *
     *          *   *  *   *
     *        *      *      *
     * **/
    public static void pattern23()
    {
        int size = 3;
        for (int row = 1; row <= size ; row++)
        {
            for (int space = 0; space <= size - row ; space++)
            {
                System.out.print("-");
            }
            for (int col = 1; col <= row ; col++)
            {
                System.out.print("*");

                for (int space = 0; space <= col ; space++)
                {
                    System.out.print("-");
                }
            }

            System.out.println();
        }
    }


    /**
     *        *        *
     *        **      **
     *        * *    * *
     *        *  *  *  *
     *        *   **   *
     *        *   **   *
     *        *  *  *  *
     *        * *    * *
     *        **      **
     *        *        *
     * **/
    public static void pattern24()
    {
        int size = 5;
        // Upper half
        for (int row = 1; row <= size; row++)
        {
            for (int col = 1; col <= row; col++)
            {
                if (col == 1 || col == row)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            for (int space = 1; space <= 2 * (size - row) ; space++)
            {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++)
            {
                if (col == row || col == 1)
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

        // Lower half
        for (int row = 1; row <= size ; row++)
        {
            for (int col = 1; col <= size - row + 1 ; col++)
            {
                if (col == 1 || col == (size - row + 1))
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            for (int space = 1; space <= 2 * row - 2; space++)
            {
                System.out.print(" ");
            }
            for (int col = 1; col <= size - row + 1; col++)
            {
                if (col == 1 || col == (size - row + 1))
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
     *           *****
     *          *   *
     *         *   *
     *        *   *
     *       *****
     *
     * */
    public static void pattern25()
    {
        int size = 5;
        for (int row = 1; row <= size; row++)
        {
            for (int space = 1; space <= size - row; space++)
            {
                System.out.print(" ");
            }
            for (int col = 1; col <= size; col++)
            {
                if ((row == 1 || row == size) || (col == 1 || col == size))
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
     *       1 1 1 1 1 1
     *       2 2 2 2 2
     *       3 3 3 3
     *       4 4 4
     *       5 5
     *       6
     *
     * */
    public static void pattern26()
    {
        int N = 6;
        int count = 1;
        for (int row = 0; row < N ; row++)
        {
            for (int column = 1; column <= N - row; column++)
            {
                System.out.print(count + " ");
            }
            count++;
            System.out.println();
        }
    }

    /**
     *       1 2 3 4  17 18 19 20
     *         5 6 7  14 15 16
     *           8 9  12 13
     *             10 11
     * */
    public static void pattern27()
    {
        int N = 4;
        int firstHalf = 1;
        int secondHalf = (N * N) + 1;
        int numOfSpaces = 0;

        for (int row = N; row >= 1; row--)
        {
            // space
            for (int space = numOfSpaces; space >= 1; space--)
            {
                System.out.print(" ");
            }

            // first half
            for (int firstHalfCounter = 1; firstHalfCounter <= row; firstHalfCounter++)
            {
                System.out.print((firstHalf++) + " ");
            }

            // second half
            for (int secondHalfCounter = 1; secondHalfCounter <= row; secondHalfCounter++)
            {
                System.out.print((secondHalf++) + " ");
            }

            System.out.println();
            numOfSpaces += 2;

            secondHalf = (secondHalf - 1) - ((row - 1) * 2);
        }
    }



    /**
     *          *
     *         * *
     *        * * *
     *       * * * *
     *      * * * * *
     *       * * * *
     *        * * *
     *         * *
     *          *
     * **/
    public static void pattern28()
    {
        int size = 4;

        for (int row = 1; row <= (size * 2) + 1  ; row++)
        {
            for (int space = 1; space <= row; space++)
            {
                System.out.print(" ");
            }
            for (int star = 1; star <= row; star++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    /**
     *        *        *
     *        **      **
     *        ***    ***
     *        ****  ****
     *        **********
     *        ****  ****
     *        ***    ***
     *        **      **
     *        *        *
     *
     * **/
    public static void pattern29()
    {
        int size = 5;
        // Upper half
        for (int row = 1; row <= size; row++)
        {
            for (int col = 1; col <= row; col++)
            {
                System.out.print("*");
            }
            for (int space = 1; space <= 2 * (size - row) ; space++)
            {
                System.out.print(" ");
            }
            for (int col = 1; col <= row; col++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half
        for (int row = 1; row <= size ; row++)
        {
            for (int col = 1; col <= size - row + 1 ; col++)
            {
                System.out.print("*");
            }
            for (int space = 1; space <= 2 * row - 2; space++)
            {
                System.out.print(" ");
            }
            for (int col = 1; col <= size - row + 1; col++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     *             1
     *           2 1 2
     *         3 2 1 2 3
     *       4 3 2 1 2 3 4
     *     5 4 3 2 1 2 3 4 5
     *
     * **/
    public static void pattern30()
    {
        int size = 5;
        for (int row = 1 ; row <= size ; row++)
        {
            for (int space = 1; space <= size - row; space++)
            {
                System.out.print(" ");
            }
            for (int column = row; column >= 1; column--)
            {
                System.out.print(column + " ");
            }
            for (int column = 2; column <= row ; column++)
            {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    /**
     *
     *        E
     *        D E
     *        C D E
     *        B C D E
     *        A B C D E
     * */
    public static void pattern32()
    {
        int N = 5;
        for (int row = 0; row < N; row++)
        {
            char currentChar = 'E';
            for (int column = 0; column <= row ; column++)
            {
                System.out.print(currentChar + " ");
                currentChar--;
            }
            System.out.println();
        }
    }
    /**
     *
     *        a
     *        B c
     *        D e F
     *        g H i J
     *        k L m N o
     *
     * **/
    public static void pattern33()
    {
        int N = 5;
        char currentChar = 'a';
        boolean upperCase = false;
        for (int row = 0; row < N; row++)
        {
            for (int column = 0; column <= row ; column++)
            {
                if (upperCase)
                {
                    System.out.print(Character.toUpperCase(currentChar) + " ");
                }
                else
                {
                    System.out.print(currentChar + " ");
                }
                currentChar++;
                upperCase = !upperCase;
            }
            System.out.println();
        }
    }
    /**
     *        E D C B A
     *        D C B A
     *        C B A
     *        B A
     *        A
     * */
    public static void pattern34()
    {
        int N = 5;
        char startChar = 'E';
        for (int row = 0 ; row < N; row++)
        {
            char printChar = startChar;
            for (int column = 1; column <= N - row ; column++)
            {
                System.out.print((printChar--) + " ");
            }
            System.out.println();
            startChar--;
        }
    }

    /**
     *        1      1
     *        12    21
     *        123  321
     *        12344321
     * **/
    public static void pattern35()
    {
        int size = 5;
        for (int row = 1; row <= size; row++)
        {
            for (int col = 1; col <= row; col++)
            {
                System.out.print(col);
            }
            for (int space = 1; space <= 2 * (size - row) ; space++)
            {
                System.out.print(" ");
            }
            for (int col = row; col >= 1; col--)
            {
                System.out.print(col);
            }
            System.out.println();
        }
    }


}
