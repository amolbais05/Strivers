package binarysearchtree;

public class TwoSumBSTOptimal
{
    public boolean findTarget(TreeNode root, int k)
    {
        // If root is null, tree is empty, return false
        if (root == null)
        {
            return false;
        }

        // Create two iterators: one from smallest, one from largest
        MyBSTIterator l = new MyBSTIterator(root, false);
        MyBSTIterator r = new MyBSTIterator(root, true);

        // Get the first values
        int i = l.next();
        int j = r.next();

        // Loop until two values meet
        while (i < j)
        {
            // If sum is exactly k, return true
            if (i + j == k)
            {
                return true;
            }
            // If sum is smaller, move left iterator forward
            else if (i + j < k)
            {
                i = l.next();
            }
            // If sum is bigger, move right iterator backward
            else
            {
                j = r.next();
            }
        }

        // If no such pair found, return false
        return false;

    }
}

class MyBSTIterator
{
    // Stack is used to keep track of nodes while traversing
    private java.util.Stack<TreeNode> stack;
    // This flag tells us whether we move forward (inorder) or backward (reverse inorder)
    private boolean reverse;

    // Constructor initializes the iterator with root and traversal mode
    MyBSTIterator(TreeNode root, boolean isReverse)
    {
        stack = new java.util.Stack<>();
        reverse = isReverse;
        // Push nodes from one side into the stack
        pushAll(root);
    }

    // This function checks if there are still nodes to visit
    boolean hasNext()
    {
        // If stack is not empty, then we still have nodes left
        return !stack.isEmpty();
    }

    // This function returns the next node?s value in the chosen order
    int next()
    {
        // Get the node on top of the stack
        TreeNode tmpNode = stack.pop();

        // If we are not in reverse mode, move to the right child
        if (!reverse)
        {
            pushAll(tmpNode.right);
        }
        // If we are in reverse mode, move to the left child
        else
        {
            pushAll(tmpNode.left);
        }

        // Return the value of the node we just processed
        return tmpNode.val;
    }

    // Helper function pushes nodes from current down to edge (left or right)
    private void pushAll(TreeNode node)
    {
        // Keep going until node becomes null
        while (node != null)
        {
            // Push this node into stack
            stack.push(node);
            // If reverse is true, move to right child
            if (reverse)
            {
                node = node.right;
            }
            // Otherwise, move to left child
            else
            {
                node = node.left;
            }
        }
    }
}