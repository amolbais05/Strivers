package binarytrees.lec2;

import java.util.LinkedList;
import java.util.Queue;
import binarytrees.lec1.TreeNode;

public class MaximunDepthOfTree
{
    public int levelOrder(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();

                if (node.left != null)
                {
                    queue.add(node.left);
                }
                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return level;
    }

    public int getHeight(TreeNode root)
    {
        // Base case: if the current node is NULL,
        // return 0 (height of an empty tree)
        if (root == null)
        {
            return 0;
        }

        // Recursively calculate the height
        // of left and right subtrees
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Return the maximum height of left and right subtrees
        // plus 1 (to account for the current node)
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
