package linkedlist.lec5;

import linkedlist.lec1.Node;

public class RotateLinkedList
{
    public Node bruteForce(Node head, int k)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        for (int i = 0; i < k; i++)
        {
            Node temp = head;
            while (temp.next.next != null)
            {
                temp = temp.next;
            }
            Node end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;
    }

    public Node rotateRight(Node head, int k)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        // First, count the length and find the last node
        int length = 1;
        Node temp = head;
        while (temp.next != null)
        {
            length++;
            temp = temp.next;
        }

        // Now temp is the last node
        temp.next = head; // Connect last node to head -> circular list

        k = k % length; // Handle k > length case
        int end = length - k; // Find the node just before new head

        // Move temp to that node
        while (end-- > 0)
        {
            temp = temp.next;
        }

        // New head will be temp.next
        head = temp.next;
        temp.next = null; // Break the circle

        return head;
    }

    private static Node nonCircular(Node head, int k)
    {

        if (head == null || head.next == null || k == 0)
        {
            return head;
        }

        // Step 1: Find the length of the list
        int length = 0;
        Node temp = head;
        while (temp != null)
        {
            length++;
            temp = temp.next;
        }

        // Step 2: Find the actual number of rotations needed
        k = k % length;
        if (k == 0)
        {
            return head;
        }

        // Step 3: Find the new tail: (length - k - 1)th node
        int stepsToNewTail = length - k - 1;
        Node newTail = head;
        while (stepsToNewTail-- > 0)
        {
            newTail = newTail.next;
        }

        // Step 4: Set newHead and break the list
        Node newHead = newTail.next;
        newTail.next = null;

        // Step 5: Connect old tail to old head
        Node tail = newHead;
        while (tail.next != null)
        {
            tail = tail.next;
        }
        tail.next = head;

        return newHead;
    }
    // TC : O (N)
    // SC : O (1)

}
