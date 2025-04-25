package linkedlist.lec4;

import linkedlist.lec2.Node;

public class DeleteAllOccurrencesDLL
{
    public Node deleteAllOccurrences(Node head, int target) {

        if (head == null || head.next == null)
        {
            return head;
        }

        Node temp = head;

        while (temp != null)
        {
            if (temp.data == target)
            {
                if (temp == head)
                {
                    head = head.next;
                }
                else
                {
                    Node next = temp.next;
                    Node prev = temp.prev;

                    if (next != null)
                    {
                        next.prev = prev;
                    }
                    if (prev != null)
                    {
                        prev.next = next;
                    }
                    temp = temp.next;
                }
            }
            else
            {
                temp = temp.next;
            }
        }
        return head;

    }
}
