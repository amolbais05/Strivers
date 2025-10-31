package binarytrees.lec1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversalIterative
{
    // Left Root Right
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> inOrder = new ArrayList<>();
        if (root == null)
        {
            return inOrder;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (true)
        {
            if (node != null)
            {
                stack.push(node);
                node = node.left;
            }
            else
            {
                if (stack.isEmpty())
                {
                    break;
                }
                node = stack.pop();
                inOrder.add(node.val);
                node = node.right;
            }
        }
        return inOrder;
    }
}
