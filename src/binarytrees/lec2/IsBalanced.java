package binarytrees.lec2;

import binarytrees.lec1.TreeNode;

public class IsBalanced
{
    public boolean isBalanced(TreeNode root)
    {

        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1)
        {
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1)
        {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1)
        {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
    // O (n)

    private boolean isBalanceBruteForce(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanceBruteForce(root.left) && isBalanceBruteForce(root.right))
        {
            return true;
        }
        return false;
    }

    private int getHeight(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }


}
