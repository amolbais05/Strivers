package binarytrees.lec1;

public class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data)
    {
        this.val = data;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
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
