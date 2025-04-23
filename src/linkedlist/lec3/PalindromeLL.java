package linkedlist.lec3;

import linkedlist.lec1.Node;
import java.util.Stack;

public class PalindromeLL
{

    private static boolean better(Node head)
    {
        if (head == null || head.next == null)
        {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        Node temp = head;

        while (temp != null)
        {
            stack.add(temp.data);
            temp = temp.next;
        }

        temp = head;

        while(!stack.isEmpty())
        {
            if (temp.data != stack.peek())
            {
                return false;
            }

            stack.pop();
            temp = temp.next;
        }
        return true;
    }
    // TC : O (2N)
    // SC : O (N)


}
