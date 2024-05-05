package math;

public class Palindrome
{
    public static void main(String[] args)
    {
        System.out.println(checkPalindrome(1234));
        System.out.println(checkPalindrome(121));
        System.out.println(checkPalindrome(123211));
        System.out.println(checkPalindrome(1234321));
    }

    static boolean checkPalindrome(int number)
    {
        int originalNumber = number;
        int newNumber = 0;
        while(number > 0)
        {
         int lastDigit = number % 10;
         newNumber = (newNumber * 10) + lastDigit;
         number = number / 10;
        }

        return originalNumber == newNumber;
    }
}
