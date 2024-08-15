package recursion;

public class Print_N_to_1
{
    private static void printNum(int num)
    {
        if (num == 0)
        {
            return;
        }
        System.out.println(num);
        num = num - 1;
        printNum(num);
    }
}
