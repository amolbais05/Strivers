package binarytrees.lec2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import binarytrees.lec1.TreeNode;

public class BoundaryTraversal
{
    private List<Integer> boundaryTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }

        if (!isLeaf(root))
        {
            result.add(root.val);
        }

        addLeftBoundary(root, result);
        addLeaves(root, result);
        addRightBoundary(root, result);

        return result;
    }
    // TC : O(n)
    // SC : O(n)

    private boolean isLeaf(TreeNode root)
    {
        return root.left == null && root.right == null;
    }

    private void addLeftBoundary(TreeNode root, List<Integer> result)
    {
        TreeNode curr = root.left;

        while (curr != null)
        {
            if (!isLeaf(curr))
            {
                result.add(curr.val);
            }

            if (curr.left != null)
            {
                curr = curr.left;
            }
            else
            {
                curr = curr.right;
            }
        }
    }

    private void addRightBoundary(TreeNode root, List<Integer> result)
    {
        TreeNode curr = root.right;
        List<Integer> temp = new ArrayList<>();

        while (curr != null)
        {
            if (!isLeaf(curr))
            {
                temp.add(curr.val);
            }

            if (curr.right != null)
            {
                curr = curr.right;
            }
            else
            {
                curr = curr.left;
            }
        }
        Collections.reverse(temp);
        result.addAll(temp);
    }

    private void addLeaves(TreeNode root, List<Integer> result)
    {

        if (isLeaf(root))
        {
            result.add(root.val);
            return;
        }

        if (root.left != null)
        {
            addLeaves(root.left, result);
        }

        if (root.right != null)
        {
            addLeaves(root.right, result);
        }
    }

}
