package linkedlist;

public class ArrayToLinkedList
{
    public static void main(String[] args)
    {
        int[] arr = {12, 4, 5, 6, 8};
        Node head = convertArrayToLinkedList(arr);
        System.out.println(head.data);
    }

    private static Node convertArrayToLinkedList(int[] arr)
    {
        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++)
        {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp; // mover = mover.next is also acceptable
        }
        return head;
    }
    // TC : O (n)
}
