package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue
{
    Queue<Integer> queue = new LinkedList<>();

    void push(int x)
    {
        queue.add(x);
        int size = queue.size();
        for (int i = 1; i < size; i++)
        {
            queue.add(queue.remove());
        }
    }

    int pop()
    {
        if (queue.isEmpty())
        {
            System.out.println("Stack is empty");
            return -1;
        }
        return queue.remove();
    }

    int top()
    {
        if (queue.isEmpty())
        {
            System.out.println("Stack is empty");
            return -1;
        }
        return queue.peek();
    }

    int size()
    {
        return queue.size();
    }
}
