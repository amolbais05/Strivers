package StackAndQueue.lec2;

public class InfixToPrefix
{

    public static void main(String[] args)
    {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPrefix(str));
    }

    private static String infixToPrefix(String str)
    {
        StringBuilder sb = new StringBuilder(str);

        // Step 1 : reverse the string
        sb.reverse();

        // Step 2 : replace ( with ) and vice versa
        reverseParentheses(sb);

        // Step 3 : convert infix to postfix
        String postfix = InfixToPostfix.infixToPostfix(sb.toString());

        return new StringBuilder(postfix).reverse().toString();
    }
    // TC : O(2N)
    // SC: O(N)

    //method to replace ( with ) and vice versa
    private static void reverseParentheses(StringBuilder sb)
    {
        int n = sb.length();
        for (int i = 0; i < n; i++)
        {
            if (sb.charAt(i) == '(')
            {
                sb.setCharAt(i, ')');
            }
            else if (sb.charAt(i) == ')')
            {
                sb.setCharAt(i, '(');
            }
        }
    }

}
