package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class BinaryStringsWithoutConsecutive1s
{
    public static void main(String[] args)
    {
        int n = 3;
        List<String> result = generateBinaryStrings(n);
        System.out.println(result);
    }

    private static List<String> generateBinaryStrings(int n)
    {
        List<String> result = new ArrayList<>();
        stringRecursive(n, "", result);
        return result;
    }

    private static void stringRecursive(int n, String current, List<String> result)
    {
        if (current.length() == n)
        {
            result.add(current);
            return;
        }

        // Always can place '0'
        stringRecursive(n, current + "0", result);

        // Can place '1' only if last char isn't '1'
        if (current.isEmpty() || current.charAt(current.length() - 1) != '1')
        {
            stringRecursive(n, current + "1", result);
        }
    }
    // TC : O (2^n)
    // SC : O (n)
}
