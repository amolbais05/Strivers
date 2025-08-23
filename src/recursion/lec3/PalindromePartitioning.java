package recursion.lec3;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> ans = new ArrayList<>();
        List<String> current = new ArrayList<>();
        func(s, 0, current, ans);
        return ans;
    }

    private void func(String s, int index, List<String> current, List<List<String>> ans)
    {
        if (index == s.length())
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i < s.length(); i++)
        {
            if (isPalindrome(s, index, i))
            {
                current.add(s.substring(index, i + 1));
                func(s, i + 1, current, ans);
                current.remove(current.size() - 1);
            }
        }
    }
    // TC : O (2^n * k * n)
    // SC : O (k * x)

    private boolean isPalindrome(String s, int start, int end)
    {
        while (start <= end)
        {
            if (s.charAt(start++) != s.charAt(end--))
            {
                return false;
            }
        }
        return true;
    }
}
