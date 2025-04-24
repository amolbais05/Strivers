package linkedlist.lec3;

import linkedlist.lec1.Node;

public class DeleteMiddle
{
    private static Node deleteMiddle(Node head)
    {
        if (head == null || head.next == null)
        {
            return null;
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
    // TC : O (N)
    // SC : O (1)

    private static Node deleteMiddleBrute(Node head)
    {
        if (head == null || head.next == null)
        {
            return null;
        }
        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        int mid = count / 2;
        temp = head;
        while (mid > 1)
        {
            temp = temp.next;
            mid--;
        }
        temp.next = temp.next.next;
        return head;

    }
    // TC : O (N)
    // SC : O (1)
}
