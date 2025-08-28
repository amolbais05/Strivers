package bitmanipulation.lec2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SingleNumberIII
{
    public static void main(String[] args)
    {
        int[] nums = {2, 4, 2, 6, 3, 7, 7, 3};
    }

    private List<Integer> bruteForceUsingHashing(int[] nums)
    {
        Map<Integer, Long> map = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        return map
            .entrySet()
            .stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey).collect(Collectors.toList());
    }
    // TC nLogN
    // SC : O (n)

    private List<Integer> optimal(int[] nums)
    {
        int xorAll = 0;
        for (int num : nums)
        {
            xorAll ^= num;
        }
        int rightmostSetBit = xorAll & (-xorAll);

        int num1 = 0, num2 = 0;

        // Step 3: Divide into two groups
        for (int num : nums)
        {
            if ((num & rightmostSetBit) != 0)
            {
                num1 ^= num;
            }
            else
            {
                num2 ^= num;
            }
        }

        // Step 4: Return result as List
        return Arrays.asList(num1, num2);
    }
    // TC : O(N)
    // SC
}
