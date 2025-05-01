package linkedlist.lec5;

public class FlatteningLL
{
    public MyNode flatten(MyNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        return merge(head, flatten(head.next));
    }
    // TC : O (N)
    // SC : O (1)
    private MyNode merge(MyNode a, MyNode b)
        {
            if (a == null)
            {
                return b;
            }
            if (b == null)
            {
                return a;
            }
            MyNode result;
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

    class MyNode
    {
        int data;
        MyNode next;
        MyNode child;

        // Constructors to initialize the
        // data, next, and child pointers
        MyNode() {
            data = 0;
            next = null;
            child = null;
        }

        MyNode(int x) {
            data = x;
            next = null;
            child = null;
        }

        MyNode(int x, MyNode nextMyNode, MyNode childMyNode) {
            data = x;
            next = nextMyNode;
            child = childMyNode;
        }
    }
