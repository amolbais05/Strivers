package arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElements
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 3, 3, 3, 3, 10};
        System.out.println(boyersMoore(arr));
    }

    private static int bruteForce(int[] arr)
    {
        int count = 0;
        int majorityElement = 0;
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                if (arr[i] == arr[j])
                {
                    count++;
                }
            }
            if (count > arr.length / 3)
            {
                majorityElement = arr[i];
            }
            count = 0;
        }
        return majorityElement;
    }
    // TC : O(n^2)
    // SC : O(1)

    private static List<Integer> better(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;

        int mini = (n / 3) + 1;

        for (int i = 0; i < n; i++)
        {
            int value = map.getOrDefault(arr[i], 0);
            map.put(arr[i], value + 1);

            if (map.get(arr[i]) == mini)
            {
                ans.add(arr[i]);
            }
            if (ans.size() == 2)
            {
                break;
            }
        }
        return ans;
    }
    // TC : O(n)
    // SC : O(n)

    private static List<Integer> boyersMoore(int[] arr)
    {
        int n = arr.length; //size of the array

        int cnt1 = 0, cnt2 = 0; // counts
        int el1 = Integer.MIN_VALUE; // element 1
        int el2 = Integer.MIN_VALUE; // element 2

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++)
        {
            if (cnt1 == 0 && el2 != arr[i])
            {
                cnt1 = 1;
                el1 = arr[i];
            }
            else if (cnt2 == 0 && el1 != arr[i])
            {
                cnt2 = 1;
                el2 = arr[i];
            }
            else if (arr[i] == el1) cnt1++;
            else if (arr[i] == el2) cnt2++;
            else
            {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++)
        {
            if (arr[i] == el1) cnt1++;
            if (arr[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);

        // Uncomment the following line
        // if it is told to sort the answer array:
        //Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

        return ls;

    }
}
