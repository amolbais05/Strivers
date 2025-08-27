package bitmanipulation.lec1;

public class SwapTwoNumber
{
    public static void main(String[] args)
    {

    }

    // even number of "1" then "0"
    // odd number of "1" then "1"

    private static void swap(int a, int b)
    {
        // Step 1: XOR a and b, store in a
        // Now a contains (a ^ b)
        a = a ^ b;

        // Step 2: XOR the new a (a ^ b) with b
        // This gives us original value of a
        // So b now becomes the old value of a
        b = a ^ b;

        // Step 3: XOR the new a (a ^ b) with new b (old a)
        // This gives us original value of b
        // So a now becomes the old value of b
        a = a ^ b;

        // At this point, the values are swapped:
        // 'a' now has original 'b', and 'b' now has original 'a'
    }


}
