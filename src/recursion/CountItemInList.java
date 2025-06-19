package recursion;

import java.util.List;

public class CountItemInList
{
    public static void main(String[] args)
    {
        System.out.println(countItem(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    private static int countItem(List<?> list)
    {
        if (list.isEmpty())
        {
            return 0;
        }
        return 1 + countItem(list.subList(1, list.size()));
    }
    // TC : O (n)
    // SC : O (n)
}
