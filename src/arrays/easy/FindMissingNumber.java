package arrays.easy;

public class FindMissingNumber
{
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 4, 5};
        System.out.println(optimal2(arr));
    }

    private static int bruteForce(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i <= n; i++)
        {
            boolean flag = false;
            for (int j = 0; j < n; j++)
            {
                if (arr[j] == i)
                {
                    flag = true;
                    break;
                }
            }
            if (!flag)
            {
                return i;
            }
        }
        return -1;
    }
    // TC : O(N^2)
    // SC : O(1)

    private static int optimal(int arr[])
    {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n - 1; i++)
        {
            sum += arr[i];
        }
        int sumOfNNumbers = (n * (n + 1)) / 2;
        return sumOfNNumbers - sum;
    }
    // TC : O(N)
    // SC : O(1)

    private static int optimal2(int arr[])
    {
        int n = arr.length;
        int xor1 = 0; // XOR of numbers from 0 to n
        int xor2 = 0; // XOR of numbers in the array

        // XOR all numbers from 0 to n
        for (int i = 0; i <= n; i++) {
            xor1 = xor1 ^ i;
        }

        // XOR all elements in the arr array
        for (int num : arr) {
            xor2 = xor2 ^ num;
        }

        // Missing number is the XOR of these two
        return xor1 ^ xor2;
    }
}
