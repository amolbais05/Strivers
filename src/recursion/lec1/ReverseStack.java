package recursion.lec1;

import java.util.Stack;

public class ReverseStack
{
    private static void reverseStack(Stack<Integer> stack)
    {
        if (!stack.isEmpty())
        {
            int temp = stack.pop();
            reverseStack(stack);
            insert(stack, temp);
        }
    }

    private static void insert(Stack<Integer> stack, int temp)
    {
        if (stack.isEmpty())
        {
            stack.push(temp);
        }
        else
        {
            int val = stack.pop();
            insert(stack, temp);
            stack.push(val);
        }
    }

    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }
}
