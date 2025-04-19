package linkedlist.lec2;

public class Insert
{
    private static Node insertBeforeHead(Node head, int data)
    {
        Node newNode = new Node(data);
        head.prev = newNode;
        newNode.next = head;
        return newNode; // new head is getting return from here
    }

    private static Node insertAfterHead(Node head, int data)
    {
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
        newNode.prev = head;
        if (newNode.next != null)
        {
            newNode.next.prev = newNode;
        }
        return head;
    }

    private static Node insertBeforeTail(Node head, int data)
    {
        Node newNode = new Node(data);
        Node temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        Node prev = temp.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = temp;
        temp.prev = newNode;
        return head;
    }

    private static Node insertAfterTail(Node head, int data)
    {
        Node newNode = new Node(data);
        Node tail = head;

        while (tail.next != null)
        {
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.prev = tail;
        newNode.next = null;
        return head;
    }

    private static Node insertBeforeKthElement(Node head, int data, int position)
    {
        if (head == null || position <= 0)
        {
            return head;
        }
        if (position == 1)
        {
            return insertBeforeHead(head, data);
        }
        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            if (count == position)
            {
                break;
            }
            temp = temp.next;
        }

        Node prev = temp.prev;
        Node newNode = new Node(data);
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = temp;
        temp.prev = newNode;
        return head;
    }

    private static Node insertAfterKthElement(Node head, int data, int position)
    {
        if (head == null || position <= 0)
        {
            return head;
        }
        if (position == 1)
        {
            return insertAfterHead(head, data);
        }

        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            if (count == position)
            {
                break;
            }
            temp = temp.next;
        }

        // If we reach end before position, do nothing
        if (temp == null)
        {
            return head;
        }

        Node newNode = new Node(data);
        Node nextNode = temp.next;

        // insert after temp
        temp.next = newNode;
        newNode.prev = temp;
        newNode.next = nextNode;

        if (nextNode != null)
        {
            nextNode.prev = newNode;
        }
        return head;
    }

    private static void insertBeforeNode(Node node, int data)
    {
        Node prev = node.prev;
        Node newNode = new Node(data, node, prev);
        prev.next = newNode;
        node.prev = newNode;
    }

    static void insertAfterNode(Node node, int data)
    {
        Node next = node.next;
        Node newNode = new Node(data, next, node);
        node.next = newNode;
        next.prev = newNode;
    }
}
