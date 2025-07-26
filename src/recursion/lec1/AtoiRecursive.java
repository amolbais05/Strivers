package recursion.lec1;

public class AtoiRecursive
{

    public static int myAtoi(String s)
    {
        if (s == null || s.isEmpty())
        {
            return 0;
        }
        s = s.trim();
        if (s.isEmpty())
        {
            return 0;
        }

        int sign = 1;
        int index = 0;

        if (s.charAt(0) == '+' || s.charAt(0) == '-')
        {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++;
        }

        return sign * helper(s, index, 0);
    }

    private static int helper(String s, int index, int acc)
    {
        if (index >= s.length() || !Character.isDigit(s.charAt(index)))
        {
            return acc;
        }

        int digit = s.charAt(index) - '0'; // convert 'char' to 'int'

        // Check for overflow
        if (acc > (Integer.MAX_VALUE - digit) / 10)
        {
            return (acc < 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        acc = acc * 10 + digit;
        return helper(s, index + 1, acc);
    }

    public static void main(String[] args)
    {
        System.out.println(myAtoi("12345"));      // 12345
        System.out.println(myAtoi("   -42"));     // -42
        System.out.println(myAtoi("4193 text"));  // 4193
        System.out.println(myAtoi("text 987"));   // 0
        System.out.println(myAtoi("-91283472332"));// -2147483648
    }
}
