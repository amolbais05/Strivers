package binarytrees.lec1;

public class Node
{
    int val;
    Node left;
    Node right;

    public Node(int data)
    {
        this.val = data;
    }

    public static void main(String[] args)
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
    }
    /*
     *      1
     *    /   \
     *   2    3
     *       /
     *      5
     *
     * */
}
