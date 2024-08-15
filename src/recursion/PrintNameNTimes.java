package recursion;

public class PrintNameNTimes
{
    public static void main(String[] args)
    {
        printName(5, "Achyut Balaram");
    }

    static void printName(int times, String name)
    {
        if (times == 0)
        {
            return;
        }
        System.out.println(name);
        printName(--times, name);
    }
    // SC O(1)
    // TC O(1)
}
