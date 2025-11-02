package binarytrees.lec2;

import binarytrees.lec1.TreeNode;

public class Diameter
{
    // brute force
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root)
    {

        calculateHeight(root);
        return diameter;
    }

    int calculateHeight(TreeNode node)
    {
        if (node == null)
        {
            return 0;
        }

        // Recursively calculate the
        // height of left and right subtrees
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Calculate the diameter at the current
        // node and update the global variable
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return the height
        // of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
    // TC : o n^2
    // SC : o (1)

    // optimal
    
}
