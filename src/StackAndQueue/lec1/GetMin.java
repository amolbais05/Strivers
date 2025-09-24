package StackAndQueue.lec1;

import java.util.Stack;


public class GetMin
{
    Stack<Pair<Integer, Integer>> stack = new Stack<>();


    private void push(int data)
    {
        int min = data;
        if (!stack.isEmpty())
        {
            min = Math.min(stack.peek().second, min);
        }
        stack.push(new Pair<>(data, min));
    }

    private int pop()
    {
        return stack.pop().first;
    }

    private int getMin()
    {
        return stack.peek().second;
    }

    private int peek()
    {
        return stack.peek().first;
    }


    public static class Pair<T, E>
    {
        T first;
        E second;

        Pair(T first, E second)
        {
            this.first = first;
            this.second = second;
        }
    }
}

