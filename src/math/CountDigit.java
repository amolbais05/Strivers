package math;

public class CountDigit
{
    public static void main(String[] args)
    {
        System.out.println("123 : " + countDigits_2(123));
        System.out.println("1234 : " + countDigits_2(1234));
        System.out.println("12345 : " + countDigits_2(12345));
        System.out.println("123456 : " + countDigits_2(123456));
        System.out.println("1 : " + countDigits_2(1));

    }

    static int countDigits(int n){
        int count = 0;
        while(n > 0)
        {
            n = n / 10;
            count++;
        }
        return count;
    }

    static int countDigits_2(int n){
        return (int) Math.log10(n)  + 1;
    }
}
