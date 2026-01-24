package binarysearchtree;

public class FindCeil
{
    private int findCeil(TreeNode root, int key)
    {
        int ceil = -1;

        while (root != null)
        {
            if (root.val == key)
            {
                ceil = root.val;
                return ceil;
            }

            if (key > root.val)
            {
                root = root.right;
            }
            else
            {
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }
    // TC : O(LogN))
    // SC : O(1)
}
