package linkedlist.lec4;

import linkedlist.lec2.Node;

public class RemoveDuplicatesFromSorted
{
    public Node deleteDuplicates(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node temp = head;
        while (temp != null && temp.next != null)
        {
            Node next = temp.next;

            while (next != null && temp.data == next.data)
            {
                next = next.next;
            }
            temp.next = next;
            temp = temp.next;
            if (next != null)
            {
                next.prev = temp;
            }
        }
        return head;
    }
    // TC : O (N)
    // SC : O (1)
}
