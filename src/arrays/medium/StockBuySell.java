package arrays.medium;

public class StockBuySell
{
    public static void main(String[] args)
    {
        int arr[] = {7, 1, 5, 3, 6, 4};
        System.out.println(bruteForce(arr));
        System.out.println(better(arr));
    }


    private static int bruteForce(int arr[])
    {
        int n = arr.length;
        int maxProfit = 0;
        for (int i = 0 ; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (arr[i] < arr[j])
                {
                    maxProfit = Math.max(maxProfit, arr[j] - arr[i]);
                }
            }
        }
        return maxProfit;
    }
    // TC : O(N^2)
    // SC : O(1)

    private static int better(int arr[])
    {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++)
        {
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }
        return maxProfit;
    }
    // TC : O(N)
    // SC : O(1)
}
