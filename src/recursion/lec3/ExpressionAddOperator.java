package recursion.lec3;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator
{
    public List<String> addOperators(String num, int target)
    {
        List<String> ans = new ArrayList<>();
        backtrack(num, target, 0, "", 0, 0, ans);
        return ans;
    }
    // TC : O (n * 4^n)
    // SC : O (n)

    private void backtrack(String num, int target, int index, String path, long resSoFar, long prevNum, List<String> ans)
    {
        if (index == num.length())
        {
            if (resSoFar == target)
            {
                ans.add(path);
            }
            return;
        }

        for (int j = index; j < num.length(); j++)
        {
            if (j > index && num.charAt(index) == '0')
            {
                break; // skip leading zeros
            }

            long currNum = Long.parseLong(num.substring(index, j + 1));

            if (index == 0)
            {
                // first number, no operator
                backtrack(num, target, j + 1, path + currNum, currNum, currNum, ans);
            }
            else
            {
                // addition
                backtrack(num, target, j + 1, path + "+" + currNum, resSoFar + currNum, currNum, ans);

                // subtraction
                backtrack(num, target, j + 1, path + "-" + currNum, resSoFar - currNum, -currNum, ans);

                // multiplication
                backtrack(num, target, j + 1, path + "*" + currNum, resSoFar - prevNum + prevNum * currNum, prevNum * currNum,
                    ans);
            }
        }
    }
}
