package binarytrees.lec1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalIterative
{

    public List<Integer> postorderTraversal(TreeNode root)
    {

        List<Integer> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;

        while (curr != null || !stack.isEmpty())
        {
            if (curr != null)
            {
                stack.push(curr);
                curr = curr.left; // go left as far as possible
            }
            else
            {
                TreeNode peekNode = stack.peek();
                // if right child exists and not visited yet, go right
                if (peekNode.right != null && lastVisited != peekNode.right)
                {
                    curr = peekNode.right;
                }
                else
                {
                    result.add(peekNode.val);
                    lastVisited = stack.pop();
                }
            }
        }

        return result;
    }

    public List<Integer> postorderTraversalUsing2stack(TreeNode root)
    {

        List<Integer> postOrder = new ArrayList<>();
        if (root == null)
        {
            return postOrder;
        }

        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty())
        {
            root = st1.pop();
            st2.add(root);

            if (root.left != null)
            {
                st1.push(root.left);
            }
            if (root.right != null)
            {
                st1.push(root.right);
            }
        }

        while (!st2.isEmpty())
        {
            postOrder.add(st2.pop().val);
        }

        return postOrder;
    }
}
