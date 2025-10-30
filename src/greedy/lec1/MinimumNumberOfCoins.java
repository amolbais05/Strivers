package greedy.lec1;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfCoins
{
    private void findMin(int V)
    {
        int[] deno = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        List<Integer> ans = new ArrayList<>();
        int n = deno.length;

        for (int i = n - 1; i >= 0; i--)
        {
            while (V >= deno[i])
            {
                V -= deno[i];
                ans.add(deno[i]);
            }

        }
        System.out.println(ans);
    }
    // TC : O(n)
    // SC : O(n)
}
