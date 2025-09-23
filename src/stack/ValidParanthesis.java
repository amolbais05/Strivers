package stack;

import java.util.Stack;

public class ValidParanthesis
{
    public static void main(String[] args)
    {
        String str = "()";
        System.out.println(isValid(str));
    }

    private static boolean isValid(String str)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[')
            {
                stack.push(ch);
            }
            else
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                else if (ch == ')' && stack.peek() == '(')
                {
                    stack.pop();
                }
                else if (ch == '}' && stack.peek() == '{')
                {
                    stack.pop();
                }
                else if (ch == ']' && stack.peek() == '[')
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
