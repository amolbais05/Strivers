package linkedlist.lec3;

import linkedlist.lec1.Node;
import java.util.HashMap;
import java.util.Map;

public class DetectLoop
{
    public boolean hasCycle(Node head)
    {

        if (head == null || head.next == null)
        {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
            {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleBrute(Node head)
    {
        if (head == null || head.next == null)
        {
            return false;
        }

        Map<Node, Boolean> map = new HashMap<>();
        Node temp = head;

        while (temp != null)
        {
            if (map.containsKey(temp))
            {
                return true;
            }
            map.put(temp, true);
            temp = temp.next;
        }
        return false;

    }
}
