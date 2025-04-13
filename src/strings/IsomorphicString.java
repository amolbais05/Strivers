package strings;

import java.util.HashMap;

public class IsomorphicString
{
    public static void main(String[] args)
    {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t)
    {
        if (s.length() != t.length())
        {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
        {
            Character original = s.charAt(i);
            Character replacement = t.charAt(i);

            if (!map.containsKey(original))
            {
                if (!map.containsValue(replacement))
                {
                    map.put(original, replacement);
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if (map.get(original) != replacement)
                {
                    return false;
                }
            }
        }
        return true;
    }
    // TC = O(n)
    // SC = O(n)

}
