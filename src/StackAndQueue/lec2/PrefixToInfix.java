package StackAndQueue.lec2;

import java.util.Stack;

public class PrefixToInfix
{
    public static void main(String[] args)
    {
        String str = "++*ab+cde";
        System.out.println(prefixToInfix(str));
    }

    private static String prefixToInfix(String str)
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
                stack.push("(" + op1 + ch + op2 + ")");
            }
        }
        return stack.pop();
    }
    // TC : O(n)
    // SC : O(n)
}
