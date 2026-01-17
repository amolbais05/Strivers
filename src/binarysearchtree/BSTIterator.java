package binarysearchtree;

import java.util.Stack;

public class BSTIterator
{
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root)
    {
        pushLeftChain(root);
    }

    public int next()
    {
        TreeNode tempNode = stack.pop();
        pushLeftChain(tempNode.right);
        return tempNode.val;
    }

    public boolean hasNext()
    {
        return !stack.isEmpty();
    }

    private void pushLeftChain(TreeNode node)
    {
        while (node != null)
        {
            stack.push(node);
            node = node.left;
        }
    }
}
