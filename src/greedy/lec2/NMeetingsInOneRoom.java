package greedy.lec2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInOneRoom
{
    private List<Integer> solve(int[] start, int[] end)
    {
        // Store meetings as (end_time, start_time, index)
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++)
        {
            // i+1 for 1-based index
            meetings.add(new int[] {end[i], start[i], i + 1});

        }

        // Sort by end time
        meetings.sort(Comparator.comparingInt(a -> a[0]));

        List<Integer> result = new ArrayList<>();
        int lastEnd = -1;

        // Traverse sorted meetings
        for (int[] m : meetings)
        {
            // If meeting can be scheduled
            if (m[1] > lastEnd)
            {
                // Store original index
                result.add(m[2]);
                // Update last meeting end time
                lastEnd = m[0];
            }
        }
        return result;
    }
}

