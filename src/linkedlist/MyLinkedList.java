package linkedlist;

public class MyLinkedList
{
    Node head;
    int size;

    public MyLinkedList()
    {
        head = null;
        size = 0;
    }

    public boolean search(Node head, int target)
    {
        Node temp = head;
        while (temp != null)
        {
            if (temp.data == target)
            {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int length(Node head)
    {
        int count = 0;
        Node temp = head;

        while (temp != null)
        {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void traversal(Node head)
    {
        Node temp = head;
    }
}
