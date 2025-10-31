package binarytrees.lec1;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal
{
    // Left Right Root
    public List<Integer> postorderTraversal(Node root)
    {

        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    public void postOrder(Node root, List<Integer> result)
    {
        if (root == null)
        {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }
}
