package arrays.hard;

public class CountReversePairs
{
    public static void main(String[] args)
    {
        int[] arr = {1, 3, 2, 3, 1};
        System.out.println(bruteForce(arr));
        System.out.println(optimal(arr));
    }

    private static int bruteForce(int[] arr)
    {
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] > 2 * arr[j])
                {
                    count++;
                }
            }
        }
        return count;
    }
    // TC : O(n^2)
    // SC : O(1)

    private static int optimal(int[] nums)
    {
        
    }

}
