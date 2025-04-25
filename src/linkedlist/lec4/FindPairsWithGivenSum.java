package linkedlist.lec4;


import linkedlist.lec2.Node;
import java.util.ArrayList;

public class FindPairsWithGivenSum
{
    private ArrayList<Pair<Integer, Integer>> findPair(Node head, int target)
    {
        ArrayList<Pair<Integer, Integer>> ans = new ArrayList<>();

        if (head == null || head.next == null)
        {
            return ans;
        }

        Node right = findTail(head);
        Node left = head;

        while (left.data <= right.data)
        {
            int sum = left.data + right.data;
            if (sum == target)
            {
                ans.add(new Pair<>(left.data, right.data));
                left = left.next;
                right = right.prev;
            }
            else if (sum < target)
            {
                left = left.next;
            }
            else
            {
                right = right.prev;
            }
        }

        return ans;
    }

    private Node findTail(Node head)
    {
        Node temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        return temp;
    }

}

class Pair<T, U>
{
    private final T first;
    private final U second;

    public Pair(T first, U second)
    {
        this.first = first;
        this.second = second;
    }

    public T getFirst()
    {
        return first;
    }

    public U getSecond()
    {
        return second;
    }

    @Override
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        Pair<?, ?> other = (Pair<?, ?>) obj;
        return (first == null ? other.first == null : first.equals(other.first)) &&
            (second == null ? other.second == null : second.equals(other.second));
    }

    @Override
    public int hashCode()
    {
        int result = first == null ? 0 : first.hashCode();
        result = 31 * result + (second == null ? 0 : second.hashCode());
        return result;
    }
}
