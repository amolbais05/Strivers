package StackAndQueue.lec3;

import java.util.Stack;

public class NextSmallerElement
{
    private static int[] nextSmalletElement(int[] arr)
    {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];

        // Traverse from right to left
        for (int i = arr.length - 1; i >= 0; i--)
        {
            // Pop elements greater or equal to current element
            while (!stack.isEmpty() && stack.peek() >= arr[i])
            {
                stack.pop();
            }

            // If stack empty -> no smaller element on right
            ans[i] = stack.isEmpty() ? -1 : stack.peek();

            // Push current element to stack
            stack.push(arr[i]);
        }

        return ans;
    }
}
