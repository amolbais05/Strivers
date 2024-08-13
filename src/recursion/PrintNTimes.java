package recursion;

public class PrintNTimes
{
    public static void main(String[] args)
    {
        printNTimes(5);
    }

    private static void printNTimes(int number)
    {
        if (number == 0){
            return;
        }
        System.out.println(number);
        printNTimes(--number);
    }
}
