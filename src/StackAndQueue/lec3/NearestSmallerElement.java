package StackAndQueue.lec3;

import java.util.Stack;

public class NearestSmallerElement
{
    // nearest smaller element to the left
    public static void main(String[] args)
    {
        int[] arr = {4, 5, 2, 10, 8};
        int[] ans = nearestSmallerElementToLeft(arr);
        for (int i : ans)
        {
            System.out.print(i + " ");
        }
    }

    private static int[] nearestSmallerElementToLeft(int[] arr)
    {
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++)
        {
            if (stack.isEmpty())
            {
                ans[i] = -1;
            }
            else if (stack.peek() < arr[i])
            {
                ans[i] = stack.peek();
            }
            else
            {
                while (!stack.isEmpty() && stack.peek() >= arr[i])
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
