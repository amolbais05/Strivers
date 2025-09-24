package StackAndQueue.lec2;

import java.util.Stack;

public class InfixToPostfix
{
    // 1 + 2 * 3 -> 1 2 3 * +

    public static String infixToPostfix(String str)
    {
        Stack<String> stack = new Stack<>();
        String ans = "";

        char[] chars = str.toCharArray();
        for (char ch : chars)
        {
            if (ch == '(')
            {
                stack.push(String.valueOf(ch));
            }
            else if (ch == ')')
            {
                while (!stack.isEmpty() && !stack.peek().equals("("))
                {
                    ans = ans + stack.pop();
                }
                stack.pop();
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            {
                while (!stack.isEmpty() && precedence(ch, stack.peek().charAt(0)))
                {
                    ans = ans + stack.pop();
                }
                stack.push(String.valueOf(ch));
            }
            else
            {
                ans = ans + ch;
            }
        }

        while (!stack.isEmpty())
        {
            ans = ans + stack.pop();
        }

        return ans;
    }
    // TC : O(n)
    // SC : O(n)

    private static boolean precedence(char curr, char top)
    {
        int p1 = priority(curr);
        int p2 = priority(top);
        if (p1 == p2 && curr == '^')
        {
            return false; // Right-associative
        }
        return p1 <= p2;
    }

    private static int priority(char ch)
    {
        switch (ch)
        {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return -1;
        }
    }
}
