package strings;

import java.util.Map;

public class RomanNumberToInteger
{
    public static void main(String[] args)
    {
        System.out.println(romanToInt("I"));
        System.out.println(romanToInt("II"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("V"));
        System.out.println(romanToInt("VI"));
        System.out.println(romanToInt("X"));
        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994
    }

    private static int romanToInt2(String s)
    {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++)
        {
            int current = getValue(s.charAt(i));
            if (i < n - 1 && current < getValue(s.charAt(i + 1)))
            {
                ans -= current;
            }
            else
            {
                ans += current;
            }
        }
        return ans;
    }

    private static int romanToInt(String s)
    {
        // Special cases
        s= s.replace("IV", "IIII");
        s= s.replace("IX", "VIIII");
        s= s.replace("XL", "XXXX");
        s= s.replace("XC", "LXXXX");
        s= s.replace("CD", "CCCC");
        s= s.replace("CM", "DCCCC");

        int sum = 0;

        for (int i = 0; i < s.length(); i++)
        {
            sum += getValue(s.charAt(i));
        }
        return sum;
    }

    private static Integer getValue(char key)
    {
        // Constant map
        return Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        ).get(key);
    }

}
