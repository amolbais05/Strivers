package recursion;

import java.util.stream.Stream;

public class Palindrome
{
    public static void main(String[] args)
    {
        System.out.println(inbuiltMethod("nitin"));
        System.out.println(inbuiltMethod("nitin"));

        System.out.println(alternateApproach("nitin"));
        System.out.println(alternateApproach("pravin"));

        System.out.println(recursive("nitin", 0, "nitin".length() - 1));
        System.out.println(recursive("pravin", 0, "pravin".length() - 1));


    }
    private static boolean inbuiltMethod(String str)
    {
        StringBuilder builder = new StringBuilder(str);
        builder = builder.reverse();
        return builder.toString().equals(str);
    }
    // TC : O (n)
    // SC : O (n)

    private static boolean alternateApproach(String str)
    {
        int left = 0;
        int right = str.length() - 1;
        while (left < right)
        {
            if (str.charAt(left) != str.charAt(right))
            {
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
    // TC : O (n)
    // SC : O (1)

    private static boolean recursive(String str, int left, int right)
    {
        if (left >= right)
        {
            return true;
        }
        if (str.charAt(left) != str.charAt(right))
        {
            return false;
        }
        return recursive(str, left + 1, right - 1);
    }
    // TC : O (n)
    // SC : O (n)

}
