package arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangle {

    public static void main(String[] args) {
        printPascalTriangle(5);
        System.out.println(nCr(5, 2));
        System.out.println(getRow(3));
        System.out.println(generate(3));
    }

    private static void printPascalTriangle(int n) {
        int[][] pascalTriangle = new int[n][n];
        for (int i = 0; i < n; i++) {
            pascalTriangle[i][0] = 1; // First column is always 1
            pascalTriangle[i][i] = 1; // Last Column is always 1

            for (int j = 1; j < i; j++) {
                pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];
            }
        }

        // Convert matrix to List<List<Integer>> using streams
        List<List<Integer>> listOfLists = Arrays.stream(pascalTriangle)
                .map(row -> Arrays.stream(row) // Stream each row
                        .boxed()    // Convert int to Integer
                        .takeWhile(num -> num != 0) // Only take non-zero numbers
                        .collect(Collectors.toList())) // Collect to List<Integer>
                .collect(Collectors.toList()); // Collect to List<List<Integer>>


        System.out.println(listOfLists);

    }

    // print Pascal's Triangle single element
    private static long nCr(int row, int col) {
        long res = 1;

        // calculating nCr:
        for (int i = 0; i < col; i++) {
            res = res * (row - i);
            res = res / (i + 1);
        }
        return res;
    }
    // TC : O(n)
    // SC : O(1)

    // Given the row number n. Print the n-th row of Pascal?s triangle.
    public static List<Long> getRow(int rowIndex) {
        long ans = 1;
        List<Long> ansRow = new ArrayList<>();
        ansRow.add(1L);
        for (int col = 1; col < rowIndex; col++) {
            ans = ans * (rowIndex - col);
            ans = ans / col;
            ansRow.add(ans);
        }
        return ansRow;
    }
    // TC : O(n)
    // SC : O(1)

    // Given n, print pascal's triangle
    public static List<List<Long>> generate(int numRows) {
        List<List<Long>> ans = new ArrayList<>();
        for (int row = 1; row <= numRows; row++)
        {
            ans.add(getRow(row));
        }
        return ans;
    }
        // TC : O(n^2)
        //SC : O(1)
}


/**
 *                1
 *             1   1
 *           1   2   1
 *         1   3   3   1
 *       1   4   6   4   1
 *
 * */
