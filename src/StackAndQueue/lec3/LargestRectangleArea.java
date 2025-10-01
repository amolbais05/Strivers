package StackAndQueue.lec3;

import java.util.Stack;

public class LargestRectangleArea
{
    public static void main(String[] args)
    {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    private static int largestRectangleArea(int[] heights)
    {
        int n = heights.length;
        int[] nse = getNSE(heights, n);
        int[] pse = getPSE(heights, n);
        int res = 0;
        for (int i = 0; i < n; i++)
        {
            res = Math.max(res, heights[i] * (nse[i] - pse[i] - 1));
        }
        return res;
    }

    private static int[] getNSE(int[] arr, int n)
    {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--)
        {
            if (stack.isEmpty())
            {
                result[i] = n;
            }
            else if (!stack.isEmpty() && arr[stack.peek()] < arr[i])
            {
                result[i] = stack.peek();
            }
            else if (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
            {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                {
                    stack.pop();
                }
                result[i] = stack.isEmpty() ? n : stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    private static int[] getPSE(int[] arr, int n)
    {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++)
        {
            if (stack.isEmpty())
            {
                result[i] = -1;
            }
            else if (!stack.isEmpty() && arr[stack.peek()] < arr[i])
            {
                result[i] = stack.peek();
            }
            else if (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
            {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i])
                {
                    stack.pop();
                }
                result[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    public int largestRectangleAreaOptimized(int[] heights)
    {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++)
        {
            int h = (i == n ? 0 : heights[i]);
            while (!stack.isEmpty() && h < heights[stack.peek()])
            {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
