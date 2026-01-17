package binarysearchtree;

class TreeNode
{
    // Value of the node
    int val;

    // Pointer to the left child node
    TreeNode left;

    // Pointer to the right child node
    TreeNode right;

    // Constructor to initialize the node with a
    // value and set left and right pointers to null
    TreeNode(int x)
    {
        val = x;
        left = null;
        right = null;
    }
}