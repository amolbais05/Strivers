package arrays.easy;

public class RotateByKElements
{
    public static void main(String[] args)
    {
        int arr[] = {1,2,3,4,5,6,7};
        int k = 3;
        bruteForce(arr, k);
        /*System.out.println();

        int arr2[] = {1, 2, 3, 4, 5};
        optimal(arr2, k);*/
    }


    private static int[] bruteForce(int nums[], int k)
    {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++)
        {
            temp[i] = nums[n - k + i];
        }
        for (int i = n - 1; i >= k; i--)
        {
            nums[i] = nums[i - k];
        }
        for (int i = 0; i < k; i++)
        {
            nums[i] = temp[i];
        }
        return nums;
    }

    private static int[] optimal(int nums[], int k)
    {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1); // reverse whole array
        reverse(nums, 0, k - 1); // reverse first k elements
        reverse(nums, k, n - 1); // reverse remaining n-k elements

        for (int i = 0; i < n; i++)
        {
            System.out.print(nums[i] + " ");
        }
        return nums;
    }

    private static void reverse(int arr[], int start, int end)
    {
        while (start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
