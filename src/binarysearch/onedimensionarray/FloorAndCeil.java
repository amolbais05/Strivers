package binarysearch.onedimensionarray;

public class FloorAndCeil
{

    private int floor(int[] arr, int target)
    {
        int n = arr.length;
        int ans = -1;
        int low = 0;
        int high = n - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= target)
            {
                ans = arr[mid];
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return ans;
    }

    private int findCeil(int[] arr, int target)
    {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            // maybe an answer
            if (arr[mid] >= target)
            {
                ans = arr[mid];
                //look for smaller index on the left
                high = mid - 1;
            }
            else
            {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }
}
