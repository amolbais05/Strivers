package greedy.lec2;

import java.util.Arrays;

public class ShortestJobFinder
{
    private int sjf(int[] arr)
    {
        int n = 0;
        Arrays.sort(arr);
        int time = 0, waitTime = 0;

        for (int i : arr)
        {
            waitTime += time;
            time += i;
        }
        return (waitTime / n);
    }
    // TC : O(n) + O (nLogN)
    // SC : O (1)
}
