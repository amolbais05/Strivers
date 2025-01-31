package arrays.hard;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        System.out.println(bruteForce(arr, 0));
    }

    private static Set<List<Integer>> bruteForce(int[] arr, int target) {
        Set<List<Integer>> st = new HashSet<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        long sum = arr[i] + arr[j];
                        sum += arr[k];
                        sum += arr[l];

                        if (target == sum) {
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

    private static Set<List<Integer>> better(int[] arr, int target) {
        Set<List<Integer>> st = new HashSet<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = arr[i] + arr[j];
                    sum += arr[k];
                    long fourth = target - sum;
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], (int) fourth);
                        temp.sort(null);
                        st.add(temp);
                    }
                    hashset.add((long) arr[k]);
                }
            }
        }
        return st;
    }
    // TC : O(N3*log(M)), where N = size of the array, M = no. of elements in the set.
    // SC : O(2 * no. of the quadruplets)+O(N)


    private static List<List<Integer>> optimal(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skip duplicates
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue; // skip duplicates
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) 
                    {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    }
                    else if (sum < target)
                    {
                        k++;
                    }
                    else if (sum > target)
                    {
                        l--;
                    }
                }
            }   
        }
        return ans;
    }
    // TC : o(n^3)
    // SC : O(1)
}
