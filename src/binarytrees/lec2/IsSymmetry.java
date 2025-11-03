package binarytrees.lec2;

import binarytrees.lec1.TreeNode;

public class IsSymmetry
{
    public boolean isSymmetric(TreeNode root)
    {

        if (root == null)
        {
            return true;
        }

        return isSymetric(root.left, root.right);
    }

    private boolean isSymetric(TreeNode left, TreeNode right)
    {
        if (left == null || right == null)
        {
            return left == right;
        }

        if (left.val != right.val)
        {
            return false;
        }

        return isSymetric(left.left, right.right) &&
            isSymetric(left.right, right.left);
    }
}
