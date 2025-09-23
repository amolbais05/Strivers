package queue;

import linkedlist.lec2.Node;

public class QueueUsingLL
{
    Node start;
    Node end;
    int size = 0;

    private void enqueue(int data)
    {
        Node newNode = new Node(data);
        if (start == null)
        {
            start = newNode;
            end = newNode;
        }
        else
        {
            end.next = newNode;
            end = newNode;
        }
        size = size + 1;
    }

    private int dequeue()
    {
        if (start == null)
        {
            System.out.println("Queue is empty");
            return -1;
        }
        Node temp = start;
        start = start.next;
        size = size - 1;
        return temp.data;
    }

    private int peek()
    {
        if (start == null)
        {
            System.out.println("Queue is empty");
            return -1;
        }
        return start.data;
    }

    int getSize()
    {
        return size;
    }
}
