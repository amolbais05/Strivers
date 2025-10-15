package heaps.lec1;

public class CheckIfArrayRepresentsMinHeap
{
    public static void main(String[] args)
    {
        int[] arr = {10, 15, 14, 25, 30};
        System.out.println(isMinHeap(arr));
    }

    public static boolean isMinHeap(int[] arr)
    {
        int n = arr.length;
        for (int i = 0; i < n / 2; i++)
        {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            if (leftChild < n && arr[i] > arr[leftChild])
            {
                return false;
            }
            if (rightChild < n && arr[i] > arr[rightChild])
            {
                return false;
            }
        }
        return true;
    }
    // TC : O(n)
    // SC : O(1)

}
