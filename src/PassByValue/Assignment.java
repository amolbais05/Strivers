package PassByValue;

public class Assignment
{
    public static void main(String[] args)
    {
        final int[] x = {10};

        Runnable r = () -> x[0]++;
        r.run();
    }
}
