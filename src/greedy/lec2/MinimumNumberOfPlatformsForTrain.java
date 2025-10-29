package greedy.lec2;

import java.util.Arrays;

public class MinimumNumberOfPlatformsForTrain
{
    public int bruteForce(int n, int[] arr, int[] dep)
    {
        int ans = 1;

        for (int i = 0; i < n; i++)
        {
            int count = 1;
            for (int j = i + 1; j < n; j++)
            {
                if (arr[i] >= arr[j] && arr[i] <= dep[j] ||
                    arr[j] >= arr[i] && arr[j] <= dep[i])
                {
                    count++;
                }
            }
            ans = Math.max(count, ans);
        }
        return ans;
    }
    // TC : O(N^2)
    // SC : O(1)

    public int optimal(int n, int[] arr, int[] dep)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 1;
        int result = 1;
        int i = 1;
        int j = 0;

        while (i < n && j < n)
        {
            if (arr[i] <= dep[j]) // Platform needed
            {
                i++;
                platforms++;
            }
            else // Train departed, platform freed
            {
                platforms--;
                j++;
            }
            result = Math.max(result, platforms);
        }
        return result;
    }
    // TC : O(N LogN)
    // SC : O(1)
}
