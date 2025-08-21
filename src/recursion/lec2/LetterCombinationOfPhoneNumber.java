package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber
{
    private final String[] MAPPING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits)
    {
        List<String> ans = new ArrayList<>();

        if (digits == null || digits.isEmpty())
        {
            return ans;
        }

        backtrack(digits, 0, new StringBuilder(), ans);
        return ans;
    }

    void backtrack(String digits, int index, StringBuilder ds, List<String> ans)
    {

        if (digits.length() == index)
        {
            ans.add(ds.toString());
            return;
        }

        String letters = MAPPING[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray())
        {
            ds.append(ch);
            backtrack(digits, index + 1, ds, ans);
            ds.deleteCharAt(ds.length() - 1);
        }
    }
    // TC : O(k^n)
    // SC : O(n) [auxiliary] + O(k^n × n) [output]
}
