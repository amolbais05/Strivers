package linkedlist;

import static linkedlist.ArrayToLinkedList.convertArrayToLinkedList;

public class LengthOfLinkedList
{
    public static void main(String[] args)
    {
        int[] arr = {12, 4, 5, 6, 8};
        Node head = convertArrayToLinkedList(arr);

        Node temp = head;

        int count = 0;
        while (temp != null)
        {
            temp = temp.next;
            count++;
        }
        System.out.println("Length : " + count);
    }
}
