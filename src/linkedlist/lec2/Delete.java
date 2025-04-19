package linkedlist.lec2;

public class Delete
{
    private static Node deleteHead(Node head)
    {
        if (head == null)
        {
            return null;
        }

        // Only one node
        if (head.next == null)
        {
            return null;
        }

        Node newHead = head.next;
        newHead.prev = null;
        head.next = null; // Unlink old head

        return newHead;
    }

    private static Node deleteTail(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        Node tail = head;

        while (tail.next != null)
        {
            tail = tail.next;
        }
        tail.prev.next = null;
        tail.prev = null;
        return head;
    }

    private static Node deleteAtPosition(Node head, int position)
    {
        if (head == null)
        {
            return head;
        }

        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            if (count == position)
            {
                break;
            }
            temp = temp.next;
        }

        Node prev = temp.prev;
        Node next = temp.next;

        if (next == null && prev == null)
        {
            return null;
        }
        else if (prev == null)
        {
            return deleteHead(head);
        }
        else if (next == null)
        {
            return deleteTail(head);
        }

        prev.next = next;
        next.prev = prev;

        temp.next = null;
        temp.prev = null;

        return head;
    }

    private static void deleteNode(Node temp)
    {
        Node prev = temp.prev;
        Node next = temp.next;

        if (next == null)
        {
            prev.next = null;
            temp.prev = null;
            return;
        }
        prev.next = next;
        next.prev = prev;

        temp.next = temp.prev = null;
    }
}
