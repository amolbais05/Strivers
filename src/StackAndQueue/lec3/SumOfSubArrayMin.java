package StackAndQueue.lec3;

import java.util.Stack;

public class SumOfSubArrayMin
{
    public static void main(String[] args)
    {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));
    }

    private static int sumSubarrayMins(int[] arr)
    {

        int n = arr.length;
        long mod = (long) 1e9 + 7;
        long sum = 0;

        int[] nsl = getNSL(arr, n);
        int[] nsr = getNSR(arr, n);


        for (int i = 0; i < n; i++)
        {
            long left = i - nsl[i];
            long right = nsr[i] - i;

            long totalWays = left * right;

            long totalSum = arr[i] * totalWays;

            sum = (sum + totalSum) % mod;

        }
        return (int) sum;
    }
    // TC : O(n)
    // SC : O(n)

    private static int[] getNSL(int[] arr, int n) // next smaller to left
    {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++)
        {
            if (stack.isEmpty())
            {
                result[i] = -1;
            }
            else
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
    // TC : O(n)

    private static int[] getNSR(int[] arr, int n)
    {
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--)
        {
            if (stack.isEmpty())
            {
                result[i] = n;
            }
            else
            {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                {
                    stack.pop();
                }
                result[i] = stack.isEmpty() ? n : stack.peek();
            }
            stack.push(i);
        }
        return result;
    }
    // TC : O(n)
}
