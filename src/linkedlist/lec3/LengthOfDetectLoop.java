package linkedlist.lec3;

import linkedlist.lec1.Node;
import java.util.HashMap;
import java.util.Map;

public class LengthOfDetectLoop
{
    public int findLengthOptimal(Node head)
    {

        if (head == null || head.next == null)
        {
            return 0;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
            {
                return findLength(slow, fast);
            }
        }
        return 0;
    }
    // TC : O (N)
    // SC : O (1)

    private int findLength(Node slow, Node fast)
    {
        int count = 1;

        fast = fast.next;
        while (slow != fast)
        {
            count++;
            fast = fast.next;
        }
        return count;
    }

    private int lengthOfDetectLoop(Node head)
    {
        if (head == null || head.next == null)
        {
            return 0;
        }

        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int timer = 1;

        while (temp != null)
        {
            if (map.containsKey(temp))
            {
                return timer - map.get(temp);
            }
            map.put(temp, timer);
            temp = temp.next;
            timer++;
        }
        return 0;
    }
    // TC : O (N)
    // SC : O (N)
}
