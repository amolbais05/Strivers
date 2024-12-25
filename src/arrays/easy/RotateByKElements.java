package arrays.easy;

public class RotateByKElements
{
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3, 4, 5};
        int k = 2;
        bruteForce(arr, k);
        System.out.println();

        int arr2[] = {1, 2, 3, 4, 5};
        optimal(arr2, k);
    }


    private static int[] bruteForce(int arr[], int k)
    {
        int n = arr.length;
        k = k % n;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++)
        {
            temp[i] = arr[i];
        }
        for (int i = k; i < n; i++)
        {
            arr[i - k] = arr[i];
        }
        for (int i = n - k; i < n; i++)
        {
            arr[i] = temp[i - (n - k)];
        }
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    private static int[] optimal(int arr[], int k)
    {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, k - 1); // reverse first k elements
        reverse(arr, k, n - 1); // reverse last n-k elements
        reverse(arr, 0, n - 1); // reverse whole array
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        return arr;
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
