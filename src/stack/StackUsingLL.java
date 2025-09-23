package stack;

import linkedlist.lec2.Node;

public class StackUsingLL
{
    Node head;
    int size = 0;

    private void push(int data)
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size = size + 1;
    }

    private int pop()
    {
        if (head == null)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        Node temp = head;
        head = head.next;
        size = size - 1;
        return temp.data;
    }

    private int peek()
    {
        if (head == null)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        return head.data;
    }

    int getSize()
    {
        return size;
    }
}


