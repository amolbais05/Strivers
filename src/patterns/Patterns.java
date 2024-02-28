package patterns;

public class Patterns
{
    public static void main(String[] args)
    {
        eleven();
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


}
