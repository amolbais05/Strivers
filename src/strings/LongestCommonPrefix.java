package strings;

import java.util.Arrays;

public class LongestCommonPrefix
{
    public static void main(String[] args)
    {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefixBySort(strs));
    }

    private static String longestCommonPrefix(String[] strs)
    {
        if (strs == null || strs.length == 0)
        {
            return "";
        }
        String prefix = strs[0];
        for (String s : strs)
        {
            while (s.indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
    // TC = O(n * m)
    // SC = O(1)

    private static String longestCommonPrefixBySort(String[] strs)
    {

        if (strs.length == 0)
        {
            return "";
        }
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;
        while (idx < s1.length() && idx < s2.length())
        {
            if (s1.charAt(idx) == s2.charAt(idx))
            {
                idx++;
            }
            else
            {
                break;
            }
        }
        return s1.substring(0, idx);
    }
    // TC = O(nlogn)
    // SC = O(1)
}