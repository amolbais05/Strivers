package arrays.medium;

import java.util.Arrays;

public class SortArrayOf012
{
    public static void main(String[] args)
    {
        int[] arr = {0 , 1, 2, 0, 1, 2, 0, 1, 2, 0};
        better(arr);

    }

    private static void better(int[] arr)
    {
        int zero = 0;
        int one = 0;
        int two = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == 0)
            {
                zero++;
            }
            else if (arr[i] == 1)
            {
                one++;
            }
            else
            {
                two++;
            }
        }

        for (int i = 0 ; i < zero ; i++)
        {
            arr[i] = 0;
        }
        for (int i = zero ; i < zero + one ; i++)
        {
            arr[i] = 1;
        }
        for (int i = zero + one; i < n; i++)
        {
            arr[i] = 2;
        }
    }
    // TC : O(N)
    // SC : O(1)

}
