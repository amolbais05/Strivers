package arrays.hard;

public class MergeTwoSortedArraysWithoutExtraSpace
{
    public static void main(String[] args)
    {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};

        // print array from bruteforce using stream
        System.out.println("Brute Force: " + java.util.Arrays.stream(bruteForce(arr1, arr2)).boxed().collect(java.util.stream.Collectors.toList()));

    }

    private static int[] bruteForce(int[] arr1, int[] arr2)
    {
        int n = arr1.length;
        int m = arr2.length;
        int[] arr3 = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m)
        {
            if (arr1[i] < arr2[j])
            {
                arr3[k++] = arr1[i++];
            }
            else
            {
             arr3[k++] = arr2[j++];
            }
        }
        while (i < n)
        {
            arr3[k++] = arr1[i++];
        }
        while (j < m)
        {
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }
    // TC : O(n+m)
    // SC : O(n+m)


}
