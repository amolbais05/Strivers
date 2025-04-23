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

    private static boolean isPalindrome(Node head)
    {
        if (head == null || head.next == null)
        {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node newHead = reverse(slow);

        Node first = head;
        Node second = newHead;

        while (second != null)
        {
            if (first.data != second.data)
            {
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }
    // TC : O (N)
    // SC : O (1)


    private static Node reverse(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null)
        {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

}
