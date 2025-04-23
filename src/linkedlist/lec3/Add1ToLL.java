package linkedlist.lec3;

import linkedlist.lec1.Node;

public class Add1ToLL
{

    private static Node addOneToLL(Node head)
    {
        Node temp = reverse(head);

        int carry = 1;
        while (temp != null)
        {
            temp.data = temp.data + carry;

            if (temp.data < 10)
            {
                carry = 0;
                break;
            }
            else
            {
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }

        if (carry == 1)
        {
            Node newNode = new Node(1);
            head = reverse(head);
            newNode.next = head;
            return newNode;
        }

        head = reverse(head);

        return head;


    }

    private static Node reverse(Node head)
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
}
