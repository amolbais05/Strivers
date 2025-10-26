package heaps.lec3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MaximumSumCombination
{
    private List<Integer> bruteForce(int[] nums1, int[] nums2, int k)
    {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++)
        {
            for (int j = 0; j < nums2.length; j++)
            {
                ans.add(nums1[i] + nums2[j]);
            }
        }
        ans.sort((a, b) -> b - a);
        return ans.subList(0, k);
    }
    // TC: O(n^2)
    // SC: O(1)

    // It is similar to breadth first search
    private List<Integer> optimal(int[] nums1, int[] nums2, int k)
    {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        Set<String> visited = new HashSet<>();

        // Add the maximum sum combination to the heap
        maxHeap.offer(new int[] {nums1[n - 1] + nums2[n - 1], n - 1, n - 1});
        visited.add((n - 1) + "," + (n - 1));

        List<Integer> ans = new ArrayList<>();
        while (k > 0 && !maxHeap.isEmpty())
        {
            int[] curr = maxHeap.poll();
            ans.add(curr[0]);
            int i = curr[1];
            int j = curr[2];
            // Add the next possible sum combination to the heap
            if (i > 0 && !visited.contains((i - 1) + "," + j))
            {
                maxHeap.offer(new int[] {nums1[i - 1] + nums2[j], i - 1, j});
                visited.add((i - 1) + "," + j);
            }
            if (j > 0 && !visited.contains(i + "," + (j - 1)))
            {
                maxHeap.offer(new int[] {nums1[i] + nums2[j - 1], i, j - 1});
                visited.add(i + "," + (j - 1));
            }
            k--;
        }
        return ans;
    }
    // TC: O(k log k)
    // SC: O(k)


}
