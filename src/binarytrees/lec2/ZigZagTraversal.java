package binarytrees.lec2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import binarytrees.lec1.TreeNode;

public class ZigZagTraversal
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }

        boolean leftToRight = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++)
            {
                TreeNode node = queue.poll();

                if (leftToRight)
                {
                    level.addLast(node.val);
                }
                else
                {
                    level.addFirst(node.val);
                }

                if (node.left != null)
                {
                    queue.add(node.left);
                }
                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }
            leftToRight = !leftToRight;

            result.add(level);
        }

        return result;
    }

}
