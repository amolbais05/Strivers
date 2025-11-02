package binarytrees.lec2;

import binarytrees.lec1.TreeNode;

public class SameTree
{
    public boolean isSameTree(TreeNode p, TreeNode q)
    {

        if (p == null && q == null)
        {
            return true;
        }

        if (p == null || q == null)
        {
            return false;
        }

        return ((p.val == q.val) &&
            isSameTree(p.left, q.left) &&
            isSameTree(p.right, q.right)
        );

    }
}
