package greedy.lec2;

import java.util.Arrays;

public class JobSequence
{

    private int[] maxProfit(Job[] arr)
    {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit));

        int maxi = 0;
        for (int i = 0; i < n; i++)
        {
            maxi = arr[i].deadLine;
        }

        int result[] = new int[maxi + 1];
        Arrays.fill(result, -1);

        int countJobs = 0;
        int jobProfit = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = arr[i].deadLine; j > 0; j--)
            {
                // Free slot found
                if (result[j] == -1)
                {
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }

            }

        }
        int ans[] = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;
        return ans;

    }


    class Job
    {
        private int id;
        private int deadLine;
        private int profit;

        public Job(int id, int deadLine, int profit)
        {
            this.id = id;
            this.deadLine = deadLine;
            this.profit = profit;
        }

    }
}
