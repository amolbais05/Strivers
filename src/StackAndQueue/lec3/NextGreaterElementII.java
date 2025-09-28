package StackAndQueue.lec3;

import java.util.Stack;

public class NextGreaterElementII
{
    public static void main(String[] args)
    {
        int[] arr = {1, 3, 2, 4};
        int[] ans = nextGreaterElement(arr);
        for (int i : ans)
        {
            System.out.print(i + " ");
        }
    }

    private static int[] nextGreaterElement(int[] arr)
    {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] ans = new int[arr.length];
        for (int i = 2 * n - 1; i >= 0; i--) // Circular array / Mentally double the array
        {
            int index = i % n;  // wrap around using modulo
            while (!stack.isEmpty() && stack.peek() <= arr[index])
            {
                stack.pop();
            }
            if (i < n)
            { // fill answers only in first pass
                ans[index] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(arr[index]);

        }
        return ans;
    }
}
