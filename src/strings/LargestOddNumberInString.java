package strings;

public class LargestOddNumberInString
{
    public static void main(String[] args)
    {
        String num = "52";
        System.out.println(largestOddNumber(num));
    }

    private static String largestOddNumber(String num)
    {
        for(int i = num.length()-1; i >= 0; i--)
        {
            if(num.charAt(i) % 2 != 0)
            {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
    // TC = O(n)
    // SC = O(1)

    private static String largestOddNumberUsingRecursion(String num, int index)
    {
        if (index < 0)
        {
            return "";
        }
        if (num.charAt(index) % 2 != 0)
        {
            return num.substring(0, index + 1);
        }
        return largestOddNumberUsingRecursion(num, index - 1);
    }
    // TC = O(n)
    // SC = O(n)
}
