package greedy.lec2;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval
{
    public int[][] insert(int[][] intervals, int[] newInterval)
    {

        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // Step 1 : Add no overlaps intervals
        while (i < n && newInterval[0] > intervals[i][1])
        {
            res.add(intervals[i++]);
        }

        // Step 2 : Merge with whoever overlap
        while (i < n && newInterval[1] >= intervals[i][0])
        {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Step 3: Add final merge intervals
        res.add(newInterval);

        // Step 4: Add remaing
        while (i < n)
        {
            res.add(intervals[i++]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
