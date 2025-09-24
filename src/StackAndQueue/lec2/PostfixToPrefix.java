package StackAndQueue.lec2;

import java.util.Stack;

public class PostfixToPrefix
{
    public static void main(String[] args)
    {
        String str = "ab*c+";
        System.out.println(postfixToPrefix(str));
    }

    private static String postfixToPrefix(String str)
    {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch))
            {
                stack.push(String.valueOf(ch));
            }
            else
            {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push(ch + op2 + op1);
            }
        }
        return stack.pop();
    }
    // TC : O(n)
    // SC : O(n)
}
