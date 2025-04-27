package linkedlist.lec5;

import linkedlist.lec1.Node;

public class ReverseNodesKGroup
{
    private static Node reverseKGroup(Node head, int k)
    {
        Node temp = head;
        Node prevNode = null;
        while (temp != null)
        {
            Node kthNode = findKthNode(temp, k);
            if (kthNode == null)
            {
                if (prevNode != null)
                {
                    prevNode.next = temp;
                }
                break;
            }

            Node nextNode = kthNode.next;
            kthNode.next = null;
            Node reverseHead = reverse(temp);
            if (temp == head)
            {
                head = reverseHead;
            }
            else
            {
                prevNode.next = reverseHead;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
    // TC : O (N)
    // SC : O (1)

    private static Node findKthNode(Node temp, int k)
    {
        while (temp != null && k > 1)
        {
            temp = temp.next;
            k--;
        }
        return temp;
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
