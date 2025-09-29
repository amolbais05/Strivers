package StackAndQueue.lec3;

import java.util.Stack;

public class AsteroidCollision
{
    public int[] asteroidCollision(int[] asteroids)
    {
        Stack<Integer> result = new Stack<>();

        for (int asteroid : asteroids)
        {
            // when collision happens
            while (!result.isEmpty() && asteroid < 0 && result.peek() > 0)
            {
                int sum = asteroid + result.peek();
                if (sum < 0)
                {
                    result.pop();
                }
                else if (sum > 0)
                {
                    asteroid = 0;
                    //break;
                }
                else // sum == 0
                {
                    result.pop();
                    asteroid = 0;
                }

            }

            if (asteroid != 0)
            {
                result.push(asteroid);
            }

        }

        int[] res = new int[result.size()];
        while (!result.isEmpty())
        {
            res[result.size() - 1] = result.pop();
        }
        return res;
    }
}
