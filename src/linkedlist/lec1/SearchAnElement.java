package linkedlist.lec1;

import static linkedlist.lec1.ArrayToLinkedList.convertArrayToLinkedList;

public class SearchAnElement
{
    public static void main(String[] args)
    {
        int[] arr = {12, 4, 5, 6, 8};
        Node head = convertArrayToLinkedList(arr);

        Node temp = head;

        int toSearch = 5;
        while (temp != null)
        {
            if (toSearch == temp.data)
            {
                System.out.println("Element found");
                return;

            }
            temp = temp.next;
        }
    }
}
