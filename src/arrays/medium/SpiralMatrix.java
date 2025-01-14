package arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
    public static void main(String[] args)
    {
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        spiralOrder(matrix).stream().forEach(System.out::print);
    }


    private static List<Integer> spiralOrder(int[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        List<Integer> result = new ArrayList<>();

        while (left <= right && top <= bottom)
        {
            for (int i = left; i <= right; i++)
            {
                result.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++)
            {
                result.add(matrix[i][right]);
            }

            if (left < right && top < bottom)
            {
                for (int i = right - 1; i > left; i--)
                {
                    result.add(matrix[bottom][i]);
                }

                for (int i = bottom; i > top; i--)
                {
                    result.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
    // TC

}
