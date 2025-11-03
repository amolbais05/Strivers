package binarytrees.lec2;

import java.util.ArrayList;
import java.util.List;
import binarytrees.lec1.TreeNode;

public class RightLeftView
{
    // SC O(n)
    // TC O(n)

    public List<Integer> rightSideView(TreeNode root)
    {

        List<Integer> result = new ArrayList<>();
        recursionRight(root, 0, result);
        return result;
    }

    public List<Integer> leftSideView(TreeNode root)
    {

        List<Integer> result = new ArrayList<>();
        recursionLeft(root, 0, result);
        return result;
    }

    private void recursionRight(TreeNode root, int level, List<Integer> result)
    {
        if (root == null)
        {
            return;
        }

        if (level == result.size())
        {
            result.add(root.val);

        }
        recursionRight(root.right, level + 1, result);

        recursionRight(root.left, level + 1, result);
    }

    private void recursionLeft(TreeNode root, int level, List<Integer> result)
    {
        if (root == null)
        {
            return;
        }

        if (level == result.size())
        {
            result.add(root.val);

        }
        recursionLeft(root.left, level + 1, result);

        recursionLeft(root.right, level + 1, result);
    }
}
