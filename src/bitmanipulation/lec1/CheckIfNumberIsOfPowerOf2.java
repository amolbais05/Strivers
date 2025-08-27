package bitmanipulation.lec1;

public class CheckIfNumberIsOfPowerOf2
{
    public static void main(String[] args)
    {
        System.out.println(checkIfNumberIsOfPowerOf2(16));
        System.out.println(checkIfNumberIsOfPowerOf2(15));
        System.out.println(checkIfNumberIsOfPowerOf2(14));
        System.out.println(checkIfNumberIsOfPowerOf2(13));
        System.out.println(checkIfNumberIsOfPowerOf2(12));
        System.out.println(checkIfNumberIsOfPowerOf2(11));
        System.out.println(checkIfNumberIsOfPowerOf2(10));
        System.out.println(checkIfNumberIsOfPowerOf2(9));
        System.out.println(checkIfNumberIsOfPowerOf2(8));
        System.out.println(checkIfNumberIsOfPowerOf2(7));
        System.out.println(checkIfNumberIsOfPowerOf2(6));
        System.out.println(checkIfNumberIsOfPowerOf2(5));
    }

    private static boolean checkIfNumberIsOfPowerOf2(int n)
    {
        return (n & (n - 1)) == 0;
    }
}
