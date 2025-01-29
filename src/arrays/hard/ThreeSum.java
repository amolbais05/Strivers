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



}
