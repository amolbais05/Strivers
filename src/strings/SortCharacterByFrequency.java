package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class SortCharacterByFrequency
{
    public static void main(String[] args)
    {
        String s = "tree";
        System.out.println(frequencySort(s));
        System.out.println(frequencySortProrityQueue(s));
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
    // TC : O(n + k log k)

    private static String frequencySortProrityQueue(String s)
    {
        // Count character frequencies
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray())
        {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Use a max heap (PriorityQueue) to sort chracters by frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        // Build the result string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty())
        {
            char ch = maxHeap.poll();
            result.append(String.valueOf(ch).repeat(freqMap.get(ch)));
        }
        return result.toString();
    }
    // TC : O(n + k log k)
    // SC : O(n + k)

}
