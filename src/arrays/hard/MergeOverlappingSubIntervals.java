package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingSubIntervals
{
    public static void main(String[] args)
    {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = bruteForce(intervals);
        int[][] ans2 = optimal(intervals);
        for (int[] arr : ans2)
        {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[][] bruteForce(int[][] intervals)
    {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // O(N logN)

        List<int[]> ans = new ArrayList<>(); // Corrected type

        for (int i = 0; i < n; i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1)[1])
            {
                continue;
            }

            for (int j = i + 1; j < n; j++)
            {
                if (intervals[j][0] <= end)
                {
                    end = Math.max(end, intervals[j][1]);
                }
                else
                {
                    break;
                }
            }

            ans.add(new int[]{start, end}); // Corrected storage type
        }

        // Convert List<int[]> to int[][]
        return ans.toArray(new int[0][]);
    }
    // TC : O(N LogN) + O(2N)
    // SC : O(n)

    private static int[][] optimal(int[][] intervals)
    {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // O(N logN)
        List<int[]> ans = new ArrayList<>(); // Corrected type
        for (int i = 0; i < n; i++)
        {
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1])
            {
                ans.add(intervals[i]);
            }
            else
            {
                ans.get(ans.size() - 1)[1] =
                        Math.max(ans.get(ans.size() - 1)[1],
                                intervals[i][1]);
            }
        }
        return ans.toArray(new int[0][]);
    }
    // TC : O(N LogN) + O(N) -> O(N logN)
    // SC : O(n)
}
