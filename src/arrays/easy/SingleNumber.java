package arrays.easy;

public class SingleNumber
{
    public static void main(String[] args)
    {
        int arr[] = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(arr));
    }

    private static int singleNumber(int[] nums) {
        int number = 0;
        for (int i = 0; i < nums.length; i++)
        {
            number ^= nums[i];
        }
        return number;
    }
    // TC : O(N)
    // SC : O(1)
}
