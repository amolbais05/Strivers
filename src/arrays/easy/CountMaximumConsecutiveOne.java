package arrays.easy;

public class CountMaximumConsecutiveOne
{
    public static void main(String[] args)
    {
        int arr[] = {1, 1, 0, 1, 1, 1};
        System.out.println(bruteForce(arr));
        //System.out.println(optimal(arr));
    }

    private static int bruteForce(int arr[])
    {
        int count = 0;
        int maxCount = 0;

        for (int j : arr)
        {
            if (j == 1)
            {
                count++;
                maxCount = Math.max(count, maxCount);
            }
            else
            {
                count = 0;
            }

        }
        return maxCount;
    }
    // TC : O(N)
    // SC : O(1)

}
