package linkedlist.lec3;

import linkedlist.lec1.Node;

public class MiddleOfLL
{
    private static Node middle(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        int count = 0;
        Node temp = head;

        while (temp != null)
        {
            count++;
            temp = temp.next;
        }

        temp = head;

        int mid = count / 2 + 1;

        while (temp != null)
        {
            mid--;

            if (mid == 0)
            {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }
    // TC : O (N + N/2)
    // SC : O (1)

    private static Node optimal(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null )
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
