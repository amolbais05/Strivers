package heaps.lec1;

public class ConvertMinHeapToMaxHeap
{
    static void MaxHeapify(int arr[], int i, int N)
    {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < N && arr[l] > arr[i])
        {
            largest = l;
        }
        if (r < N && arr[r] > arr[largest])
        {
            largest = r;
        }
        if (largest != i)
        {
            // swap arr[i] and arr[largest]
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            MaxHeapify(arr, largest, N);
        }
    }

    // This function basically builds max heap
    static void convertMaxHeap(int arr[], int N)
    {
        for (int i = (N - 2) / 2; i >= 0; --i)
        {
            MaxHeapify(arr, i, N);
        }
    }


    public static void main(String[] args)
    {
        // array representing Min Heap
        int arr[] = {3, 5, 9, 6, 8, 20, 10, 12, 18, 9};
        int N = arr.length;


        convertMaxHeap(arr, N);

    }
}
