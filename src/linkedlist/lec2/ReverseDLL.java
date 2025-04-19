package linkedlist.lec2;

import java.util.Stack;

import static linkedlist.lec2.DoublyLinkedList.convertArrayToDoublyLinkedList;
import static linkedlist.lec2.DoublyLinkedList.traverseDoublyLinkedList;

public class ReverseDLL
{

    private static Node reverseBySwapping(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node prev = null;
        Node curr = head;

        while (curr != null)
        {
            prev = curr.prev;

            curr.prev = curr.next;
            curr.next = prev;

            curr = curr.prev;

        }
        return prev.prev;
    }
    //  TC : O (n)
    //  SC : O (1)

    private static Node reverseUsingStack(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Stack<Integer> stack = new Stack<>();
        Node temp = head;

        while (temp != null)
        {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null)
        {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }
    // TC : O (2n)
    // SC : O (n)

    public static void main(String[] args)
    {
        int[] arr = {12, 4, 5, 6, 8};
        Node head = convertArrayToDoublyLinkedList(arr);

        head = reverseBySwapping(head);

        traverseDoublyLinkedList(head);
    }
}
