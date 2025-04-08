package binarysearch.onanswers;

public class MedianOfTwoSortedArrays
{
    public static void main(String[] args)
    {
        int[] arr1 = {1, 4, 7, 10, 12};
        int[] arr2 = {2, 3, 6, 15};
        System.out.println(bruteForce(arr1, arr2));
        System.out.println(better(arr1, arr2));
    }

    private static double bruteForce(int[] arr1, int[] arr2)
    {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arr3 = new int[n1 + n2];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2)
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
        while (i < n1)
        {
            arr3[k++] = arr1[i++];
        }
        while (j < n2)
        {
            arr3[k++] = arr2[j++];
        }
        int n = arr3.length;

        if (n % 2 == 1)
        {
            return arr3[n / 2];
        }
        else
        {
            return (arr3[n / 2] + arr3[n / 2 - 1]) / 2.0;
        }
    }

    private static double better(int[] arr1, int[] arr2)
    {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n = n1 + n2;
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int cnt = 0;
        int ined1 = -1;
        int ined2 = -1;
        int i = 0;
        int j = 0;

        while (i < n1 && j < n2)
        {
            if (arr1[i] < arr2[j])
            {
                if (cnt == ind1)
                {
                    ined1 = arr1[i];
                }
                if (cnt == ind2)
                {
                    ined2 = arr1[i];
                }
                cnt++;
                i++;
            }
            else
            {
                if (cnt == ind1)
                {
                    ined1 = arr2[j];
                }
                if (cnt == ind2)
                {
                    ined2 = arr2[j];
                }
                cnt++;
                j++;
            }
        }

        while (i < n1)
            {
                if (cnt == ind1)
                {
                    ined1 = arr1[i];
                }
                if (cnt == ind2)
                {
                    ined2 = arr1[i];
                }
                cnt++;
                i++;
            }
        while (j < n2)
            {
            if (cnt == ind1)
            {
                ined1 = arr2[j];
            }
            if (cnt == ind2)
                {
                    ined2 = arr2[j];
                }
            cnt++;
            j++;
            }
        if (n % 2 == 1)
            {
                return ined2;
            }
        else
            {
                return (ined1 + ined2) / 2.0;
            }


    }
}
