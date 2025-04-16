package strings;

import java.util.HashSet;
import java.util.Set;

public class CountNumberOfSubstrings
{
    public static void main(String[] args)
    {
        String s = "aababcabc";
        System.out.println(countGoodSubstrings(s));
    }

    private static int countGoodSubstrings(String s)
    {
        int n = s.length();
        return (n * (n + 1)) / 2;
    }
    // TC : O(1)
    // SC : O(1)

    private static int countGoodSubstrings2(String s)
    {
        int n = s.length();
        int count = 0;
        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();
        while (right < n)
        {
            char ch = s.charAt(right);

            while (set.contains(ch))
            {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(ch);
            count += right - left + 1;

            right++;
        }
        return count;
    }
    // TC : O(n)
    // SC : O(1)
}
