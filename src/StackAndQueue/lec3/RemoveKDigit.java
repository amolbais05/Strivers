package StackAndQueue.lec3;

import java.util.Stack;

public class RemoveKDigit
{
    public static void main(String[] args)
    {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));
    }

    private static String removeKdigits(String num, int k)
    {
        if (num.length() == k)
        {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray())
        {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c)
            {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k > 0)
        {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
        {
            sb.append(stack.pop());
        }


        sb.reverse();
        // remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0')
        {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
