package recursion.lec3;

import java.util.ArrayList;
import java.util.List;

public class KthPermutationSequence
{
    private static String getPermutation(int n, int k)
    {
        int fact = 1;
        List<Integer> nums = new ArrayList<>();

        for (int i = 1; i < n; i++)
        {
            fact *= i;
            nums.add(i);
        }
        nums.add(n);

        StringBuilder sb = new StringBuilder();
        k--; // make k zero-based

        while (!nums.isEmpty())
        {
            int index = k / fact;
            sb.append(nums.get(index));
            nums.remove(index);

            if (nums.isEmpty())
            {
                break;
            }

            k %= fact;
            fact /= nums.size();
        }

        return sb.toString();
    }


    public static void main(String[] args)
    {
        System.out.println(getPermutation(4, 17));
    }
}
