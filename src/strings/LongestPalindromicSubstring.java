package strings;

public class LongestPalindromicSubstring
{
    public static void main(String[] args)
    {
        String s = "babad";
        System.out.println(longestPalindromeUsingTwoPointers(s));
        System.out.println(longestPalindromeUsingDp(s));
    }

    private static String longestPalindromeUsingDp(String s)
    {

        int n = s.length();
        int max = Integer.MIN_VALUE;
        int start = 0;

        Boolean[][] dp = new Boolean[n][n];  // Memo table

        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n; j++)
            {
                if (isPalindrome(s, i, j, dp))
                {
                    if ((j - i + 1) > max)
                    {
                        max = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }
    // TC : O(n^2)
    // SC : O(n^2)

    private static boolean isPalindrome(String s, int i, int j, Boolean[][] dp)
    {
        if (i >= j)
        {
            return true;
        }

        if (dp[i][j] != null)
        {
            return dp[i][j];  // Return cached result
        }

        if (s.charAt(i) == s.charAt(j))
        {
            dp[i][j] = isPalindrome(s, i + 1, j - 1, dp);
        }
        else
        {
            dp[i][j] = false;
        }
        return dp[i][j];
    }

    private static String longestPalindromeUsingTwoPointers(String s)
    {
        String ans = "";
        for (int i = 0; i < s.length(); i++)
        {
            String oddString = expand(i, i, s);
            String evenString = expand(i, i + 1, s);

            if (evenString.length() > ans.length())
            {
                ans = evenString;
            }

            if (oddString.length() > ans.length())
            {
                ans = oddString;
            }
        }
        return ans;
    }
    // TC : O(n^2)
    // SC : O(1)

    private static String expand(int i, int j, String s)
    {
        int left = i;
        int right = j;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
