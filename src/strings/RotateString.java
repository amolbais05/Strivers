package strings;

public class RotateString
{
    public static void main(String[] args)
    {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }

    public static boolean rotateString(String s, String goal)
    {
        if(s.length() != goal.length())
            return false;

        String temp = s + s;
        return temp.contains(goal);
    }
    // TC = O(n)
    // SC = O(n)
}
