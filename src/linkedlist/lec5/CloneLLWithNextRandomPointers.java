package linkedlist.lec5;

import java.util.HashMap;
import java.util.Map;

public class CloneLLWithNextRandomPointers
{

    private Node bruteForce(Node head)
    {
        // Create a map to store the mapping of original nodes to their corresponding cloned nodes
        Map<Node, Node> map = new HashMap<>();

        Node temp = head;
        while (temp != null)
        {
            Node newNode = new Node(temp.data);
            map.put(temp, newNode);
            temp = temp.next;
        }

        temp = head;
        while (temp != null)
        {
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
    // TC = O(N)
    // SC = O(N)


    }

    class Node
    {
        // Data stored in the node
        int data;
        // Pointer to the next node
        Node next;
        // Pointer to a random node in the list
        Node random;

        // Constructors for Node class
        Node()
        {
            this.data = 0;
            this.next = null;
            this.random = null;
        }

        Node(int x)
        {
            this.data = x;
            this.next = null;
            this.random = null;
        }

        Node(int x, Node nextNode, Node randomNode)
        {
            this.data = x;
            this.next = nextNode;
            this.random = randomNode;
        }
    }
