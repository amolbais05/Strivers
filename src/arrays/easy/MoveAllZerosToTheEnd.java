package arrays.easy;

public class MoveAllZerosToTheEnd
{
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 0, 1, 0, 4, 0};
        int n = arr.length;
        int[] result = bruteForce(arr, n);
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }

    private static int[] bruteForce(int arr[], int n)
    {
        int temp[] = new int[n];

        int tempIndex = 0;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] != 0)
            {
                temp[tempIndex] = arr[i];
                tempIndex++;
            }

        }
        return temp;
    }
    // SC : O(N)
    // TC : O(N)

    private static int[] optimalMoveZeros(int arr[], int n)
        {
        int j = 0;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] != 0)
            {
                if (i != j)
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
        return arr;
    }
    // TC : O(N)
    // SC : O(1)

}
