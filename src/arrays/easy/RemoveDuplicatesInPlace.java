package arrays.easy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RemoveDuplicatesInPlace
{
    public static void main(String[] args)
    {
        int arr[] = {1,1,2,2,2,3,3};
        System.out.println("Old : "+arr.length);
        //removeDuplicates(arr);
        System.out.println(removeDuplicatesFunctional(arr));

    }


    public static int removeDuplicates(int[] nums)
    {
        int i = 0;
        for (int j = 1; j < nums.length; j++)
        {
            if (nums[i] != nums[j])
            {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicatesFunctional(int[] nums) {
        int[] result = IntStream.of(nums).distinct().toArray();
        System.arraycopy(result, 0, nums, 0, result.length);
        return result.length;
    }
}
