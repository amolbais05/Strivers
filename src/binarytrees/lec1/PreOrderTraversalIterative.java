package binarytrees.lec1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversalIterative
{
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null)
        {
            return preOrder;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            root = stack.pop();
            preOrder.add(root.val);

            if (root.right != null)
            {
                stack.add(root.right);
            }
            if (root.left != null)
            {
                stack.add(root.left);
            }
        }
        return preOrder;
    }
}
