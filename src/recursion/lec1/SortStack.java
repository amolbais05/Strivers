package recursion.lec1;

import java.util.Stack;

public class SortStack
{
    private static void sortStack(Stack<Integer> stack)
    {
        if (!stack.isEmpty())
        {
            int temp = stack.pop();
            sortStack(stack);
            insert(stack, temp);
        }
    }

    private static void insert(Stack<Integer> stack, int value)
    {
        if (stack.isEmpty() || stack.peek() < value)
        {
            stack.push(value);
        }
        else
        {
            int val = stack.pop();
            insert(stack, value);
            stack.push(val);
        }
    }
    // TC = O(N^2)
    // SC = O(N)

    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(0);
        stack.push(2);

        sortStack(stack);
        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
    //
}
