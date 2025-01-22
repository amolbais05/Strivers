package arrays.easy;

import java.util.stream.IntStream;

public class CheckArrayIsSorted
{
    public static void main(String[] args)
    {
        System.out.println(isSorted(new int[]{1,2,3,4,5}));

    }

    private static boolean isSorted(int[] nums)
    {
        int N = nums.length;
        for (int i = 1 ; i < N; i++)
        {
            if (nums[i] < nums[i - 1])
            {
                return false;
            }
        }
        return true;
    }

    public boolean check(int[] nums) {

        int n = nums.length;

        // Count the number of "break points" where arr[i] > arr[(i + 1) % n]
        long breakCount = IntStream.range(0, n)
                .filter(i -> nums[i] > nums[(i + 1) % n])
                .count();

        // A valid rotated sorted array can have at most one break point
        return breakCount <= 1;

    }

}
