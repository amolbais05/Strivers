package recursion;

import java.util.List;

public class MaxItemInList
{
    public static void main(String[] args)
    {
        System.out.println(maxItem(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)));
    }

    private static int maxItem(List<Integer> list)
    {
        if (list.size() == 1)
        {
            return list.get(0);
        }
        int first = list.get(0);
        int maxOfRest = maxItem(list.subList(1, list.size()));
        return Math.max(first, maxOfRest);
    }
    // TC : O (n)
    // SC : O (n)
}
