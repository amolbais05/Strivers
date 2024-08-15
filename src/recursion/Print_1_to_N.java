package recursion;

public class Print_1_to_N
{
    public static void main(String[] args)
    {
        printNum(1, 10);
    }

    private static void printNum(int index, int num)
    {
        if (index > num)
        {
            return;
        }
        System.out.println(index);
        printNum(index + 1, num);
    }

    // SC O(1)
    // TC O(1)

}
