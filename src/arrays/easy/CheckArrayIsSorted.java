package arrays.easy;

public class CheckArrayIsSorted
{
    public static void main(String[] args)
    {
        System.out.println(isSorted(new int[]{1,2,3,4,5}));

    }

    private static boolean isSorted(int[] arr)
    {
        int N = arr.length;
        for (int i = 1 ; i < N; i++)
        {
            if (arr[i] < arr[i - 1])
            {
                return false;
            }
        }
        return true;
    }
}
