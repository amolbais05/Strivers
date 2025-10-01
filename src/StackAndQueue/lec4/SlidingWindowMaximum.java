package StackAndQueue.lec4;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum
{
    public static void main(String[] args)
    {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(arr, k);
        for (int i : result)
        {
            System.out.print(i + " ");
        }
    }

    private static int[] maxSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int j = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
        {
            if (!dq.isEmpty() && dq.peek() == i - k)
            {
                dq.poll();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
            {
                dq.pollLast();
            }
            dq.offer(i);
            if (i >= k - 1)
            {
                ans[j++] = nums[dq.peek()];
            }
        }
        return ans;
    }
}
