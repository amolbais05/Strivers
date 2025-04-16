package strings;

public class SumOfBeautyOfAllSubstrings
{
    public static void main(String[] args)
    {
        String s = "aabcb";
        System.out.println(beautySum(s));
    }

    private static int beautySum(String s)
    {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            int[] freq = new int[26];
            for (int j = i; j < n; j++)
            {
                freq[s.charAt(j) - 'a']++;
                sum += beauty(freq);
            }
        }
        return sum;
    }
    private static int beauty(int[] freq)
    {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++)
        {
            if (freq[i] > 0)
            {
                min = Math.min(min, freq[i]);
                max = Math.max(max, freq[i]);
            }
        }
        return max - min;
    }
    // TC : O(n^3)
}
