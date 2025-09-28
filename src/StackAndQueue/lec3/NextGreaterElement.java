package StackAndQueue.lec3;

import java.util.Stack;

public class NextGreaterElement
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
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
        {
            if (stack.isEmpty())
            {
                ans[i] = -1;
            }
            else if (stack.peek() > arr[i])
            {
                ans[i] = stack.peek();
            }
            else
            {
                while (!stack.isEmpty() && stack.peek() <= arr[i])
                {
                    stack.pop();
                }
                if (stack.isEmpty())
                {
                    ans[i] = -1;
                }
                else
                {
                    ans[i] = stack.peek();
                }
            }
            stack.push(arr[i]);

        }
        return ans;
    }
    // TC : O(n)
    // SC : O(n)
}
