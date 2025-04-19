package linkedlist.lec1;

import static linkedlist.lec1.ArrayToLinkedList.convertArrayToLinkedList;

public class Traversal
{
    public static void main(String[] args)
    {
        int[] arr = {12, 4, 5, 6, 8};
        Node head = convertArrayToLinkedList(arr);

        Node temp = head;

        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
