package linkedlist.lec5;

public class FlatteningLL
{
    public Node flatten(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        return merge(head, flatten(head.next));
    }
    // TC : O (N)
    // SC : O (1)
    private Node merge(Node a, Node b)
        {
            if (a == null)
            {
                return b;
            }
            if (b == null)
            {
                return a;
            }
            Node result;
            if (a.data < b.data)
            {
                result = a;
                result.child = merge(a.child, b);
            }
            else
            {
                result = b;
                result.child = merge(a, b.child);
            }
            result.next = null;
            return result;
        }
}

    class Node {
        int data;
        Node next;
        Node child;

        // Constructors to initialize the
        // data, next, and child pointers
        Node() {
            data = 0;
            next = null;
            child = null;
        }

        Node(int x) {
            data = x;
            next = null;
            child = null;
        }

        Node(int x, Node nextNode, Node childNode) {
            data = x;
            next = nextNode;
            child = childNode;
        }
    }
