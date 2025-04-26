package linkedlist.lec3;

import linkedlist.lec1.ArrayToLinkedList;
import linkedlist.lec1.Node;
import linkedlist.lec1.Traversal;
import java.util.Stack;

public class ReverseLL
{
    private static Node iterative(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node temp = head;
        Stack<Integer> stack = new Stack<>();

        while (temp != null)
        {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (!stack.isEmpty())
        {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }
    // TC : O (n)
    // SC : O (n)

    private static Node better(Node head)
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
    // TC : O (N)
    // SC : O (1)

    private static Node reverseRecursive(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node newNode = reverseRecursive(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newNode;
    }
    // TC : O (N)
    // SC : O (N)

    public static void main(String[] args)
    {
        Node head = ArrayToLinkedList.convertArrayToLinkedList(new int[]{1, 3, 5, 7 ,9});
        head = reverseRecursive(head);
        printLL(head);
    }


    private static void printLL(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    

}
