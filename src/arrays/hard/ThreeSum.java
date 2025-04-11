package arrays.hard;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        System.out.println(bruteForce(arr));
    }

    private static List<List<Integer>> bruteForce(int[] arr)
    {
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < arr.length; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                for (int k = j + 1; k < arr.length; k++)
                {
                    if (arr[i] + arr[j] + arr[k] == 0)
                    {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }

        }
        return new ArrayList<>(st);
    }
    // TC : O(n^3)
    // SC : O(3 * k)

    private static List<List<Integer>> better(int[] arr)
    {
        Arrays.sort(arr); // Sort the array first to maintain order
        Set<List<Integer>> st = new HashSet<>();

        for (int i = 0; i < arr.length; i++)
        {
            Set<Integer> hashset = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++)
            {
                int third = -(arr[i] + arr[j]);
                if (hashset.contains(third))
                {
                    st.add(Arrays.asList(arr[i], third, arr[j]));
                }
                hashset.add(arr[j]);
            }
        }
        return new ArrayList<>(st);
    }
    // TC : O(n^2)
    // SC : O(n)

    private static List<List<Integer>> optimal(int n, int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++)
        {
            //remove duplicates:
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            //moving 2 pointers:
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0)
                {
                    j++;
                }
                else if (sum > 0)
                {
                    k--;
                }
                else
                {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    //skip the duplicates:
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return ans;
    }
    // TC : O(n^2)
    // SC : O(1)



}
