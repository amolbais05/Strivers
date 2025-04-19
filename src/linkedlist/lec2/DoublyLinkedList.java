package linkedlist.lec2;

public class DoublyLinkedList
{

    private static Node convertArrayToDoublyLinkedList(int[] arr)
    {
        Node head = new Node(arr[0]);

        Node prev = head;
        for (int i = 1; i < arr.length; i++)
        {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void traverseDoublyLinkedList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {12, 4, 5, 6, 8};
        Node head = convertArrayToDoublyLinkedList(arr);
        traverseDoublyLinkedList(head);
    }
}
