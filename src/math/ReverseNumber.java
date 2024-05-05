package math;

public class ReverseNumber
{
    public int reverse(int x) {
        int reverseNumber = 0;
        while(x != 0)
        {
            int lastDigit = x % 10;
            reverseNumber = (reverseNumber * 10) + lastDigit;
            x = x / 10;
            if (reverseNumber % 10 != lastDigit)
            {
                return 0;
            }
        }
        return reverseNumber;
    }
    // TC - O(Log(n)) , SC - 0(1)
}
