package linkedlist.lec3;

import linkedlist.lec1.Node;

public class Sort012
{
    private static Node sortLL(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node zeroDummy = new Node(-1);
        Node zero = zeroDummy;

        Node oneDummy = new Node(-1);
        Node one = oneDummy;

        Node twoDummy = new Node(-1);
        Node two = twoDummy;

        Node temp = head;

        while (temp != null)
        {
            if (temp.data == 0)
            {
                zeroDummy.next = temp;
                zero = zero.next;
            }
            else if (temp.data == 1)
            {
                oneDummy.next = temp;
                one = one.next;
            }
            else
            {
                twoDummy.next = temp;
                two = two.next;
            }

            temp = temp.next;
        }

        zero.next = (oneDummy.next != null) ? oneDummy.next : twoDummy.next;
        one.next = twoDummy.next;
        two.next = null;

        return zeroDummy.next;

    }
}
