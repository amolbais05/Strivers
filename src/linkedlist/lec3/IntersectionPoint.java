package linkedlist.lec3;

import linkedlist.lec1.Node;
import java.util.HashMap;
import java.util.Map;

public class IntersectionPoint
{
    private static Node intersectionPoint(Node head1, Node head2)
    {
        if (head1 == null || head2 == null)
        {
            return null;
        }
        Node temp1 = head1;
        Node temp2 = head2;

        Map<Node, Integer> map = new HashMap<>();

        while (temp1 != null)
        {
            map.put(temp1, 1);
            temp1 = temp1.next;
        }
        while (temp2 != null)
        {
            if (map.containsKey(temp2))
            {
                return temp2;
            }
            temp2 = temp2.next;
        }
        return null;
    }
    // TC : O (N + M)
    // SC : O (N)

    private static Node optimal(Node headA, Node headB)
    {
        if (headA == null || headB == null)
        {
            return null;
        }

        int n1 = length(headA);
        int n2 = length(headB);


        if (n1 > n2)
        {
            return intersectionPoint(headA, headB, n1 - n2); // headA is bigger
        }
        else
        {
            return intersectionPoint(headB, headA, n2 - n1); // headB is bigger
        }

    }

    private static Node intersectionPoint(Node bigger, Node smaller, int diff)
    {
        Node temp1 = bigger;
        Node temp2 = smaller;
        while (diff > 0)
        {
            temp1 = temp1.next;
            diff--;
        }
        while (temp1 != null && temp2 != null)
        {
            if (temp1 == temp2)
            {
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }

    private static int length(Node head)
    {
        int count = 0;
        Node temp = head;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
