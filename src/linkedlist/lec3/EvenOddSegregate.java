package linkedlist.lec3;

import linkedlist.lec1.Node;

public class EvenOddSegregate
{

    private Node segregateEvenOdd(Node head)
    {
        // creating Heads of Odd and Even LinkedLists
        Node oddHead = new Node(-1), oddTail = oddHead;
        Node evenHead = new Node(-1), evenTail = evenHead;
        Node curr = head, temp;
        while (curr != null)
        {
            // Breaking the Link of the curr Node.
            temp = curr;
            curr = curr.next;
            temp.next = null;

            if (temp.data % 2 != 0) // If odd Node,append to odd LinkedList
            {
                oddTail.next = temp;
                oddTail = temp;
            }
            else // If Even Node,append to even LinkedList
            {
                evenTail.next = temp;
                evenTail = temp;
            }
        }
        evenTail.next = oddHead.next;
        // Appending Odd LinkedList at end of EvenLinkedList
        return evenHead.next;
    }
    // TC : 0 (n)

}
