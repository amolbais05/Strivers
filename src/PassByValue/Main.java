package PassByValue;

public class Main
{
    static int num_2 = 5;
    public static void main(String[] args)
    {
        int num = 10;
        doSomething(num); // we pass copy of variable, it is also called as pass by value
        System.out.println(num);
        System.out.println("-------------");
        doSomething(num_2); // also will not work when we have global variable
        System.out.println(num_2);
    }

    private static void doSomething(int num)
    {
        System.out.println(num);
        num += 10;
        System.out.println(num);
        num += 5;
        System.out.println(num);
        num += 10;
        System.out.println(num);
    }
}
