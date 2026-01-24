package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST
{
    private boolean bruteForce(TreeNode root, int k)
    {
        List<Integer> inorder = new ArrayList<>();

        inOrder(root, inorder);
        // Two pointers for searching in sorted list
        int left = 0;
        int right = inorder.size() - 1;

        // Loop until pointers meet
        while (left < right)
        {
            // Calculate sum of current pair
            int sum = inorder.get(left) + inorder.get(right);

            // If sum equals k, return true
            if (sum == k)
            {
                return true;
            }
            // If sum smaller, move left pointer
            else if (sum < k)
            {
                left++;
            }
            // If sum larger, move right pointer
            else
            {
                right--;
            }
        }

        // If no pair found, return false
        return false;

    }

    private void inOrder(TreeNode root, List<Integer> result)
    {
        if (root == null)
        {
            return;
        }
        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
}
