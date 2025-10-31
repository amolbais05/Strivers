package binarytrees.lec1;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal
{
    // Left Root Right
    public List<Integer> inorderTraversal(Node root)
    {

        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    public void inOrder(Node root, List<Integer> result)
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
