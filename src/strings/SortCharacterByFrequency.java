package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SortCharacterByFrequency
{
    public static void main(String[] args)
    {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    private static String frequencySort(String s)
    {
        // Step 1: Count the frequency of each character
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sort the characters based on their frequency in descending order
        List<Character> sortedChars = new ArrayList<>(map.keySet());
        Collections.sort(sortedChars, (a, b) -> map.get(b) - map.get(a));

        // Step 3: Build the result string by repeating characters based on their frequency
        StringBuilder result = new StringBuilder();
        for (char c : sortedChars)
        {
            result.append(String.valueOf(c).repeat(map.get(c))); // repeat method is added in java 11
        }

        // Step 4: Return the result string
        return result.toString();
    }
}
