package recursion.lec3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak
{
    private boolean wordBreak(String s, List<String> wordDict)
    {

        Set<String> wordSet = new HashSet<>(wordDict);
        int maxLen = wordDict.stream().mapToInt(String::length).max().orElse(0);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++)
        {
            for (int j = i - 1; j >= 0 && i - j <= maxLen; j--)
            {
                if (dp[j] && wordSet.contains(s.substring(j, i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    // TC : O(n^2)
    // SC : O(n)
}
