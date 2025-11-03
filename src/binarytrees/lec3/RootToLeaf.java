package binarytrees.lec3;

import java.util.ArrayList;
import java.util.List;
import binarytrees.lec1.TreeNode;

public class RootToLeaf
{
    public List<Integer> solve(TreeNode root, int x)
    {
        // Initialize result list
        List<Integer> arr = new ArrayList<>();

        // If tree is empty
        if (root == null)
        {
            return arr;
        }

        // Call helper function
        getPath(root, arr, x);
        return arr;
    }

    private boolean getPath(TreeNode root, List<Integer> arr, int x)
    {
        if (root == null)
        {
            return false;
        }

        arr.add(root.val);

        if (root.val == x)
        {
            return true;
        }

        if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
        {
            return true;
        }

        // Back track
        arr.remove(arr.size() - 1);
        return false;
    }
    // SC O (n)
    // TC O (n)
}
