package heaps;

public class MaxHeap
{
    private int[] arr;
    private int size;
    private int capacity;

    public MaxHeap(int capacity)
    {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    public int getParent(int i)
    {
        return (i - 1) / 2;
    }

    public int getLeftChild(int i)
    {
        return 2 * i + 1;
    }

    public int getRightChild(int i)
    {
        return 2 * i + 2;
    }

    public void insert(int value)
    {
        if (size == capacity)
        {
            System.out.println("Binary Heap is full");
            return;
        }

        // Insert  the new element at the end
        arr[size] = value;

        // store the index of the new element
        int i = size;

        // increase the size of the heap
        size++;

        // Fix the min heap property if it is violated, bubble up (for max-heap, parent < child)
        while (i != 0 && arr[getParent(i)] < arr[i])
        {
            int temp = arr[getParent(i)];
            arr[getParent(i)] = arr[i];
            arr[i] = temp;
            i = getParent(i);
        }

    }

    public int extractMax()
    {
        if (size <= 0)
        {
            return Integer.MIN_VALUE;
        }

        if (size == 1)
        {
            return arr[--size];
        }

        int root = arr[0];

        // Copy the last element to the root
        arr[0] = arr[size - 1];
        size--;
        // Heapify the root
        heapify(0);
        return root;
    }

    public void heapify(int index)
    {
        int left = getLeftChild(index);
        int right = getRightChild(index);
        int largest = index;

        if (left < size && arr[left] > arr[largest])
        {
            largest = left;
        }

        if (right < size && arr[right] > arr[largest])
        {
            largest = right;
        }

        if (largest != index)
        {
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;
            heapify(largest);
        }
    }

    public int getMax()
    {
        return arr[0];
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }


}
