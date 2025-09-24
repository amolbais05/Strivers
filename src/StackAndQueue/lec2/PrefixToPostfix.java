package StackAndQueue.lec2;

import java.util.Stack;

public class PrefixToPostfix
{
    public static void main(String[] args)
    {
        String str = "++*ab+cde";
        System.out.println(prefixToPostfix(str));
    }

    private static String prefixToPostfix(String str)
    {
        Stack<String> stack = new Stack<>();
        for (int i = str.length() - 1; i >= 0; i--)
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
                stack.push(op1 + op2 + ch);
            }
        }
        return stack.pop();
    }
    // TC : O(n)
    // SC : O(n)
}
