package binarysearch.onanswers;

import java.util.PriorityQueue;

public class MinimizeMaximumDistanceBetweenGasStation
{
    public static void main(String[] args)
    {
        int[] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 9;
        System.out.println(bruteForce(stations, k));
        System.out.println(better(stations, k));
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

    private static double better(int[] arr, int k)
    {
        int n = arr.length;
        int[] howMany = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> Double.compare(b.first, a.first));

        // Inserting the initial gaps and finding the maximum gap:
        for (int i = 0; i < n - 1; i++)
        {
            pq.add(new Pair(arr[i + 1] - arr[i], i));
        }

        for (int gasStation = 1; gasStation <= k; gasStation++)
        {
            // Find the maximum section
            // and inset the gas station
            Pair top = pq.poll();
            int secInd = top.second;

            // insert the current gas staion
            howMany[secInd]++;

            double iniDiff = arr[secInd + 1] - arr[secInd];
            double newSection = iniDiff / ((double) howMany[secInd] + 1);

            pq.add(new Pair(newSection, secInd));

        }
        return pq.peek().first;
    }
    /*Time Complexity: O(nlogn + klogn),  n = size of the given array, k = no. of gas stations to be placed.
Reason: Insert operation of priority queue takes logn time complexity. O(nlogn) for inserting all the indices with distance values and O(klogn) for placing the gas stations.

Space Complexity: O(n-1)+O(n-1)
Reason: The first O(n-1) is for the array to keep track of placed gas stations and the second one is for the priority queue.*/


    public static class Pair
    {
        double first;
        int second;
        Pair(double first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

}
