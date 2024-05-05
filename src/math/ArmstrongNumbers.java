package math;

public class ArmstrongNumbers
{
    public static void main(String[] args)
    {
        System.out.println(isArmstrongNumbers(153));
        System.out.println(isArmstrongNumbers(1634));
        System.out.println(isArmstrongNumbers(123));
        System.out.println(isArmstrongNumbers(123));
        System.out.println(isArmstrongNumbers(123));
        System.out.println(isArmstrongNumbers(123));
        System.out.println(isArmstrongNumbers(123));
    }

    static boolean isArmstrongNumbers(int number)
    {
        int sum = 0;
        int power = 0;
        int temp = number;
        int dub= number;

        while (temp > 0)
        {
            temp = temp / 10;
            power++;
        }

        while (number > 0)
        {
         int lastNum = number % 10;
         sum += Math.pow(lastNum, power);
         number = number / 10;
        }

        return sum == dub;
    }
}
