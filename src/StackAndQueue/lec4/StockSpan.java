package StackAndQueue.lec4;

import java.util.Stack;

public class StockSpan
{
    // Similar problem Leetcode 739


    Stack<Pair<Integer, Integer>> stack = new Stack<>();


    public int next(int price)
    {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().getFirst() <= price)
        {
            span += stack.pop().getSecond();
        }
        stack.push(new Pair<>(price, span));
        return span;
    }

    class Pair<K, V>
    {
        private final K first;
        private final V second;

        public Pair(K first, V second)
        {
            this.first = first;
            this.second = second;
        }

        public K getFirst()
        {
            return first;
        }

        public V getSecond()
        {
            return second;
        }
    }
}
