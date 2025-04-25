package linkedlist.lec3;

import linkedlist.lec1.Node;
import java.util.ArrayList;

public class SortLL
{
    private static Node sort(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        Node temp = head;
        ArrayList<Integer> list = new ArrayList<>();

        while (temp != null)
        {
            list.add(temp.data);
            temp = temp.next;
        }
        list.sort(null);
        temp = head;
        int i = 0;
        while (temp != null)
        {
            temp.data = list.get(i);
            temp = temp.next;
            i++;
        }
        return head;
    }
    // TC : O (N Log N)
    // SC : O (N)

    private static Node sortOptimal(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node middlePrev = findMiddle(head);
        Node right = middlePrev.next;

        middlePrev.next = null;
        Node left = head;

        // Recursively sort the left and right halves
        left = sortOptimal(left);
        right = sortOptimal(right);

        // Merge the sorted halves using the
        // mergeTwoSortedLinkedLists function
        return mergeTwoSortedLinkedLists(left, right);

    }


    private static Node findMiddle(Node head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    private static Node mergeTwoSortedLinkedLists(Node list1, Node list2)
    {
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;

        while (list1 != null && list2 != null)
        {
            if (list1.data <= list2.data)
            {
                temp.next = list1;
                list1 = list1.next;
            }
            else
            {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        if (list1 != null)
        {
            temp.next = list1;
        }
        else
        {
            temp.next = list2;
        }

        return dummyNode.next;
    }
}
