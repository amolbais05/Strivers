package strings;

import java.util.Arrays;
import java.util.HashMap;

public class Anagram
{
    public static void main(String[] args)
    {
        String s1 = "abcd";
        String s2 = "dcba";
        System.out.println(isAnagram(s1, s2));
        System.out.println(isAnagramSortBased(s1, s2));
        System.out.println(isAnagramHashMapAppraoch(s1, s2));
        System.out.println(isAnagramStreamBased(s1, s2));
    }

    private static boolean isAnagram(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }
        int xorSum = 0; // extra, already solution accepted
        int[] count = new int[256];
        for (int i = 0; i < s1.length(); i++)
        {
            xorSum ^= s1.charAt(i) ^ s2.charAt(i); // XOR both characters
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
        }

        if (xorSum != 0) // If XOR isn't zero, they're not anagrams
        {
            return false;
        }
        
        for (int i = 0; i < 256; i++)
        {
            if (count[i] != 0)
            {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagramSortBased(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    private static boolean isAnagramHashMapAppraoch(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray())
        {
            if (map.containsKey(c))
            {
                if (map.get(c) == 1)
                {
                    map.remove(c);
                }
                else
                {
                    map.put(c, map.get(c) - 1);
                }
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagramStreamBased(String s1, String s2)
    {
        if (s1.length() != s2.length())
        {
            return false;
        }
        return s1.chars().sorted().toArray() == s2.chars().sorted().toArray();
    }

}
