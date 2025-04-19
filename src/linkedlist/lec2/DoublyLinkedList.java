package linkedlist.lec2;

public class DoublyLinkedList
{

    private static Node convertArrayToDoublyLinkedList(int[] arr)
    {
        Node head = new Node(arr[0]);

        Node prev = head;
        for (int i = 1; i < arr.length; i++)
        {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void traverseDoublyLinkedList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    private static Node deleteHead(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        Node pre = head;
        head = head.next;
        head.prev = null;
        pre.next = null;
        return head;
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
    // Time Complexity: O(n)
    // Space Complexity: O(1)

    public static void main(String[] args)
    {
        int[] arr = {12, 4, 5, 6, 8};
        Node head = convertArrayToDoublyLinkedList(arr);

        head = deleteAtPosition(head, 5);

        traverseDoublyLinkedList(head);
    }
}
