package arrays.hard;

import java.util.Arrays;

// needs revision
public class FindTwoMissingNumber
{
    public static void main(String[] args)
    {
        int[] arr = {1, 2, 4, 6};
        int[] ans = findTwoMissingNumbers(arr);
        Arrays.stream(ans).forEach(System.out::print);
    }
    private static int[] findTwoMissingNumbers(int[] nums) {
        int n = nums.length + 2; // Total number of elements should be n (2 missing numbers)

        // Calculate the expected sum and expected sum of squares
        long expectedSum = (long) n * (n + 1) / 2;
        long expectedSumSquares = (long) n * (n + 1) * (2 * n + 1) / 6;

        long actualSum = 0;
        long actualSumSquares = 0;

        // Calculate the sum and sum of squares of the elements in the given array
        for (int num : nums) {
            actualSum += num;
            actualSumSquares += (long) num * num;
        }

        // Calculate the difference between the expected and actual sums
        long sumOfMissing = expectedSum - actualSum;
        long sumOfSquaresOfMissing = expectedSumSquares - actualSumSquares;

        // Now, we have the two equations:
        // x + y = sumOfMissing
        // x^2 + y^2 = sumOfSquaresOfMissing
        // We can find x and y using the fact that (x + y)^2 = x^2 + y^2 + 2xy
        // Rearranging: 2xy = (x + y)^2 - (x^2 + y^2)
        // So, xy = ((x + y)^2 - (x^2 + y^2)) / 2

        long productOfMissing = (sumOfMissing * sumOfMissing - sumOfSquaresOfMissing) / 2;

        // Now solve for x and y:
        long discriminant = sumOfMissing * sumOfMissing - 4 * productOfMissing;

        long x = (long) ((sumOfMissing + Math.sqrt(discriminant)) / 2);
        long y = sumOfMissing - x;

        return new int[]{(int) x, (int) y};
    }
    // TC : O(n)
    // SC : O(1)

    private static int[] findMissingUsingHash(int[] nums)
    {
        int n = nums.length + 2;
        boolean[] hash = new boolean[n + 1];

        // Mark the numbers present in the array
        for (int num : nums)
        {
            hash[num] = true;
        }

        // Find missing numbers
        int[] ans = new int[2];
        int index = 0;
        for (int i = 1; i <= n; i++)
        {
            if (!hash[i])
            {
                ans[index++] = i;
            }
        }
        return ans;
    }
    // TC : O(n)
    // SC : O(n)


}
