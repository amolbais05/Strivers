package linkedlist.lec3;

import linkedlist.lec1.Node;
import java.util.HashMap;
import java.util.Map;

public class StartingPointOfLoopLL
{
    private static Node startingOfLoop(Node head)
    {
        if (head == null || head.next == null)
        {
            return null;
        }

        Node temp = head;
        Map<Node, Integer> map = new HashMap<>();

        while (temp != null)
        {
            if (map.containsKey(temp))
            {
                return temp;
            }
            else
            {
                map.put(temp, 1);
            }
            temp = temp.next;
        }
        return null;
    }
    // TC : O (N)
    // SC : O (N)

    private static Node optimal(Node head)
    {
        if (head == null || head.next == null)
        {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
            {
                slow = head;

                while (slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }

        }
        return null;

    }
    // TC : O (N)
    // SC : O (1)
}
