package linkedlist.lec3;

import linkedlist.lec1.Node;

public class AddTwoNumbers
{
    private static Node addTwoNumbers(Node head1, Node head2)
    {
        Node dummy = new Node(-1);
        Node curr = dummy;

        Node temp1 = head1;
        Node temp2 = head2;

        int carry = 0;

        while (temp1 != null || temp2 != null)
        {
            int sum = carry;

            if (temp1 != null)
            {
                sum += temp1.data;
            }
            if (temp2 != null)
            {
                sum += temp2.data;
            }

            Node newNode = new Node(sum % 10);
            curr.next = newNode;
            curr = curr.next;

            carry = sum / 10;
            if (temp1 != null)
            {
                temp1 = temp1.next;
            }
            if (temp2 != null)
            {
                temp2 = temp2.next;
            }
        }

        if (carry != 0)
        {
            Node newNode = new Node(carry);
            curr.next = newNode;
        }

        return dummy.next;
    }
    // TC = O(max(n, m))
    // SC = O(max(n, m))
}
