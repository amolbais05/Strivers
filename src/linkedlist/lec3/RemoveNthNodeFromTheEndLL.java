package linkedlist.lec3;

import linkedlist.lec1.Node;

public class RemoveNthNodeFromTheEndLL
{
    private static Node bruteForce(Node head, int n)
    {
        if (head == null)
        {
            return head;
        }

        int length = 0;
        Node temp = head;

        while (temp != null)
        {
            temp = temp.next;
            length++;
        }

        if (length == n)
        {
            return head.next;
        }
        temp = head;

        for (int i = 1; i < length - n; i++)
        {
            temp = temp.next;
            temp.next = temp.next.next;
            return head;
        }
        return head;
    }
    // TC : O (n)
    // SC : O (1)

    private static Node optimal(Node head, int n)
    {
        Node dummy = new Node(0);
        dummy.next = head;

        Node fast = dummy;
        Node slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
    // TC : O (n)
    // SC : O (1)



}
