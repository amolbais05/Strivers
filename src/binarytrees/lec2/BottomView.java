package binarytrees.lec2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import binarytrees.lec1.TreeNode;

public class BottomView
{
    public List<Integer> bottomView(TreeNode root)
    {
        // List to store the result
        List<Integer> ans = new ArrayList<>();

        // Check if the tree is empty
        if (root == null)
        {
            return ans;
        }

        // Map to store the bottom view nodes
        // based on their vertical positions
        Map<Integer, Integer> mpp = new TreeMap<>();

        // Queue for BFS traversal, each
        // element is a pair containing node
        // and its vertical position
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();

        // Push the root node with its vertical
        // position (0) into the queue
        q.add(new Pair<>(root, 0));

        // BFS traversal
        while (!q.isEmpty())
        {
            // Retrieve the node and its vertical
            // position from the front of the queue
            Pair<TreeNode, Integer> pair = q.poll();
            TreeNode node = pair.getKey();
            int line = pair.getValue();

            // Update the map with the node's data
            // for the current vertical position
            mpp.put(line, node.val);

            // Process left child
            if (node.left != null)
            {
                // Push the left child with a decreased
                // vertical position into the queue
                q.add(new Pair<>(node.left, line - 1));
            }

            // Process right child
            if (node.right != null)
            {
                // Push the right child with an increased
                // vertical position into the queue
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        // Transfer values from the
        // map to the result list
        for (Map.Entry<Integer, Integer> entry : mpp.entrySet())
        {
            ans.add(entry.getValue());
        }

        return ans;
    }
}
