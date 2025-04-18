package linkedlist;

import static linkedlist.ArrayToLinkedList.convertArrayToLinkedList;

public class MyLinkedList
{
    Node head;
    int size;

    public MyLinkedList()
    {
        head = null;
        size = 0;
    }

    public static Node deleteHead(Node head)
    {
        if (head == null)
        {
            return head;
        }
        head = head.next;
        return head;
    }

    public static Node deleteTail(Node head)
    {
        if (head == null || head.next == null)
        {
            return null;
        }

        Node temp = head;
        while (temp.next.next != null)
        {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node removeElement(Node head, int value)
    {
        if (head == null)
        {
            return head;
        }
        if (head.data == value)
        {
            return head.next;
        }

        Node temp = head;
        Node prev = null;
        while (temp != null)
        {

            if (temp.data == value)
            {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node deleteTarget(Node head, int target)
    {
        if (head == null)
        {
            return head;
        }
        if (target == 1)
        {
            return head.next;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while (temp != null)
        {
            count++;
            if (count == target)
            {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }


    public static Node deleteTargetRecursive(Node head, int target)
    {
        if (head == null || target <= 0)
        {
            return head;
        }

        if (target == 1)
        {
            return head.next;
        }

        head.next = deleteTargetRecursive(head.next, target - 1);
        return head;
    }

    public static Node deleteTarget2(Node head, int target) {
        if (head == null || target <= 0) {
            return head;
        }

        if (target == 1) {
            return head.next;
        }

        int count = 1;
        Node current = head;

        while (current != null && count < target - 1) {
            current = current.next;
            count++;
        }

        // If current is null or the next node is null, target is out of bounds
        if (current == null || current.next == null) {
            return head;
        }

        current.next = current.next.next;

        return head;
    }



    public boolean search(Node head, int target)
    {
        Node temp = head;
        while (temp != null)
        {
            if (temp.data == target)
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int length(Node head)
    {
        int count = 0;
        Node temp = head;

        while (temp != null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static void traversal(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public static void main(String[] args)
    {
        int[] arr = {12, 4, 5, 6, 8};
        Node head = convertArrayToLinkedList(arr);

        head = removeElement(head, 8);

        traversal(head);
    }
}
