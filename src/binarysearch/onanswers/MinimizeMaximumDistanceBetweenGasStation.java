package binarysearch.onanswers;

public class MinimizeMaximumDistanceBetweenGasStation
{
    public static void main(String[] args)
    {
        int[] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 9;
        System.out.println(bruteForce(stations, k));
        //System.out.println(better(stations, k));
        //System.out.println(optimal(stations, k));
    }

    private static double bruteForce(int[] arr, int k)
    {
        int n = arr.length;
        int[] howMany = new int[n - 1];

        for (int gasStation = 1; gasStation <= k; gasStation++)
        {
            //Find the maximum section
            //and insert the gas station:
            double maxSection = -1;
            int maxInd = -1;

            for (int i = 0; i < n - 1; i++)
            {
                double diff = arr[i + 1] - arr[i];
                double sectionLength = diff / (double) (howMany[i] + 1);

                if (sectionLength > maxSection)
                {
                    maxSection = sectionLength;
                    maxInd = i;
                }
            }
            //insert the current gas station:
            howMany[maxInd]++;
        }

        //Find the maximum distance i.e. the answer:
        double maxAns = -1;
        for (int i = 0; i < n - 1; i++)
        {
            double diff = arr[i + 1] - arr[i];
            double sectionLength = diff / (double) (howMany[i] + 1);
            maxAns = Math.max(maxAns, sectionLength);
        }
        return maxAns;
    }
    /*Time Complexity: O(k*n) + O(n), n = size of the given array, k = no. of gas stations to be placed.
Reason: O(k*n) to insert k gas stations between the existing stations with maximum distance. Another O(n) for finding the answer i.e. the maximum distance.

Space Complexity: O(n-1) as we are using an array to keep track of placed gas stations.*/
}
