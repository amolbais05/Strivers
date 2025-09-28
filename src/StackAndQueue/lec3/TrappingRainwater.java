package StackAndQueue.lec3;

public class TrappingRainwater
{
    public static void main(String[] args)
    {
        int[] arr = {3, 0, 0, 2, 0, 4};
        System.out.println(trappingRainwater(arr));
    }

    private static int trappingRainwater(int[] height)
    {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;

        while (left < right)
        {
            if (height[left] < height[right])
            {
                if (height[left] >= leftMax)
                {
                    leftMax = height[left];
                }
                else
                {
                    ans += leftMax - height[left];
                }
                left++;
            }
            else
            {
                if (height[right] >= rightMax)
                {
                    rightMax = height[right];
                }
                else
                {
                    ans += rightMax - height[right];
                }
                right--;
            }
        }
        return ans;
    }
    // TC : O(n)
    // SC : O(1)

    public int approach2(int[] height)
    {
        int n = height.length;
        if (n == 0)
        {
            return 0;
        }

        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        int water = 0;

        // 1. Build prefix max
        prefixMax[0] = height[0];
        for (int i = 1; i < n; i++)
        {
            prefixMax[i] = Math.max(prefixMax[i - 1], height[i]);
        }

        // 2. Build suffix max
        suffixMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--)
        {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }

        // 3. Calculate water
        for (int i = 0; i < n; i++)
        {
            water += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }
        return water;
    }
    // TC : O(n)
    // SC : O(n)
}
