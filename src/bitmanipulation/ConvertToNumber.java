package bitmanipulation;

public class ConvertToNumber
{
    public static void main(String[] args)
    {
        System.out.println(convertToNumber("101"));
        System.out.println(convertToNumber("111"));
        System.out.println(convertToNumber("100"));
        System.out.println(convertToNumber("110"));
        System.out.println(convertToNumber("1001"));
        System.out.println(convertToNumber("1100"));
        System.out.println(convertToNumber("10001"));
        System.out.println(convertToNumber("10011"));
        System.out.println(convertToNumber("100001"));
        System.out.println(convertToNumber("100011"));
        System.out.println(convertToNumber("1000001"));
        System.out.println(convertToNumber("1000011"));
        System.out.println(convertToNumber("10000001"));
        System.out.println(convertToNumber("10000011"));
    }

    private static int convertToNumber(String binary)
    {
        int num = 0;
        int n = binary.length();
        int power = 1;

        for (int i = n - 1; i >= 0; i--)
        {
            if (binary.charAt(i) == '1')
            {
                num = num + power;
            }
            power = power * 2;
        }
        return num;
    }
}
