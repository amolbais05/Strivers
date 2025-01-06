package arrays.medium;

import java.util.ArrayList;

public class RearrangeArrayElementsBySign
{
    public static void main(String[] args)
    {
        int arr[] = {3, 1, -2, -5, 2, -4};
        int ans[] = better(arr);
        for (int i = 0; i < ans.length; i++)
        {
            System.out.print(ans[i] + " ");

        }
    }

    private static int[] better(int arr[])
    {
        int n = arr.length;
        int[] ans = new int[n];
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int num : arr)
        {
            if (num > 0)
            {
                pos.add(num);
            }
            else
            {
                neg.add(num);
            }
        }
        for (int i = 0; i < n/2; i++)
        {
            ans[2 * i] = pos.get(i);
            ans[2 * i + 1] = neg.get(i);
        }
        return ans;
    }
    // TC : O(N)
    // SC : O(N)

    private static int[] optimal(int arr[])
    {
        int n = arr.length;
        int ans[] = new int[n];
        int posIndex = 0;
        int negIndex = 1;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] > 0)
            {
                ans[posIndex] = arr[i];
                posIndex += 2;
            }
            else
            {
                ans[negIndex] = arr[i];
                negIndex += 2;
            }
        }

        return ans;
    }
    // TC : O(N)
    // SC : O(N)

}
