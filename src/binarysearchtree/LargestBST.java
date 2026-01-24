package binarysearchtree;

public class LargestBST
{
    private TreeNode bruteForce(TreeNode root)
    {
        // Validate BST and traversal
        return null;
    }

    static class Info
    {
        boolean isBST;
        int size;   // size of largest BST in this subtree
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max)
        {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBst(TreeNode root)
    {
        return dfs(root).size;
    }

    private Info dfs(TreeNode node)
    {
        if (node == null)
        {
            // empty tree is BST of size 0
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = dfs(node.left);
        Info right = dfs(node.right);

        // check BST validity
        if (left.isBST && right.isBST && left.max < node.val && node.val < right.min)
        {
            int size = left.size + right.size + 1;
            int min = Math.min(left.min, node.val);
            int max = Math.max(right.max, node.val);
            return new Info(true, size, min, max);
        }

        // not a BST => carry largest BST size from children
        int size = Math.max(left.size, right.size);
        return new Info(false, size, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
