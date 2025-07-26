package recursion.lec1;

public class AtoiRecursive2
{
    public int myAtoi(String s) {

        if (s.isEmpty())
        {
            return 0;
        }

        s = s.trim();

        if (s.isEmpty())
        {
            return 0;
        }

        int index = 0;
        char firstChar = s.charAt(index);
        boolean isNegative = false;

        if (firstChar == '-')
        {
            isNegative = true;
            index++;
        }
        else if (firstChar == '+')
        {
            index++;
        }

        if (index >= s.length() || !Character.isDigit(s.charAt(index)))
        {
            return 0;
        }

        return atoi(s, index, 0, isNegative);
    }

    public int atoi(String str, int i, int result, boolean isNegative)
    {
        if (i >= str.length() || !Character.isDigit(str.charAt(i)))
        {
            return isNegative ? -result : result;
        }
        int digit = str.charAt(i) - '0'; // convert 'char' to 'int'

        // Overflow check before multiplying
        if (result > (Integer.MAX_VALUE - digit) / 10)
        {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        result = result * 10 + digit;
        return atoi(str, i + 1, result, isNegative);
    }
    // TC : O (N)
    // SC : O (N)
}
