package queue;

import java.util.Stack;

public class QueueUsingStack
{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    private void enqueue(int data)
    {
        // Step 1
        while (!stack1.isEmpty())
        {
            stack2.push(stack1.pop());
        }

        // Step 2
        stack1.push(data);

        // Step 3
        while (!stack2.isEmpty())
        {
            stack1.push(stack2.pop());
        }

    }

    private int peek()
    {
        return stack1.peek();
    }

    private int dequeue()
    {
        return stack1.pop();
    }

}
