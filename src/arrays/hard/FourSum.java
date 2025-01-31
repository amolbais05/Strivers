package arrays.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum
{
    public static void main(String[] args)
    {
        int[] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(bruteForce(arr, 0));
    }
    
    private static Set<List<Integer>> bruteForce(int[] arr, int target)
    {
        Set<List<Integer>> st = new HashSet<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n ;j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    for (int l = k + 1; l < n; l++)
                    {
                        long sum = arr[i] + arr[j];
                        sum += arr[k];
                        sum += arr[l];

                        if (target == sum)
                        {
                            var temp = List.of(arr[i], arr[j], arr[k], arr[l]);
                            temp.sort(null);
                            st.add(temp);
                        }

                    }
                    
                }
            }
        }
        return st;
    }
    // TC : O(n^4)
    // SC : O(n)

    private static List<List<Integer>> better(int[] arr, int target)
    {
        Set<List<Integer>> st = new HashSet<>();
        
    }


}
