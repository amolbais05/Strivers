package recursion.lec2;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses
{
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n)
    {
        String current = "";
        approach1(current, n);
        approach2(current, 0, 0, n);
        return result;
    }

    private void approach1(String current, int n)
    {
        if (current.length() == 2 * n)
        {
            if (isValid(current))
            {
                result.add(current);
            }
            return;
        }
        approach1(current + "(", n);
        approach1(current + ")", n);
        // TC : O (2^n)
        // SC : O (n)

    }

    private void approach2(String current, int open, int close, int n)
    {
        if (current.length() == 2 * n)
        {
            result.add(current);
            return;
        }
        if (open < n)
        {
            approach2(current + "(", open + 1, close, n);
        }

        if (close < open)
        {
            approach2(current + ")", open, close + 1, n);
        }
        // TC : O (2^n)
        // SC : O (n)

    }

    private boolean isValid(String current)
    {
        int count = 0;
        for (int i = 0; i < current.length(); i++)
        {
            if (current.charAt(i) == '(')
            {
                count++;
            }
            else
            {
                count--;
            }
            if (count < 0)
            {
                return false;
            }
        }
        return count == 0;
    }
}
