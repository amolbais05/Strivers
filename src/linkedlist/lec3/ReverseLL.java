package linkedlist.lec3;

import linkedlist.lec1.Node;
import java.util.Stack;

public class ReverseLL
{
    private static Node iterative(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node temp = head;
        Stack<Integer> stack = new Stack<>();

        while (temp != null)
        {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (!stack.isEmpty())
        {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }

}
