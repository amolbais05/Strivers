package heaps;

public class BinaryHeap
{
    private int[] arr;
    private int size;
    private int capacity;

    public BinaryHeap(int capacity)
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

        // Fix the min heap property if it is violated
        while (i != 0 && arr[getParent(i)] > arr[i])
        {
            int temp = arr[getParent(i)];
            arr[getParent(i)] = arr[i];
            arr[i] = temp;
            i = getParent(i);
        }

    }

    public void minHeapify(int index)
    {
        int left = getLeftChild(index);
        int right = getRightChild(index);
        int smallest = index;

        if (left < size && arr[left] < arr[smallest])
        {
            smallest = left;
        }

        if (right < size && arr[right] < arr[smallest])
        {
            smallest = right;
        }

        if (smallest != index)
        {
            int temp = arr[smallest];
            arr[smallest] = arr[index];
            arr[index] = temp;
            minHeapify(smallest);
        }
    }

    public int extractMin()
    {
        if (size <= 0)
        {
            return Integer.MAX_VALUE;
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
        minHeapify(0);
        return root;
    }

    public void decreaseKey(int index, int value)
    {
        arr[index] = value;
        // Fix the min heap property if it is violated
        while (index != 0 && arr[getParent(index)] > arr[index])
        {
            int temp = arr[getParent(index)];
            arr[getParent(index)] = arr[index];
            arr[index] = temp;
            index = getParent(index);
        }
    }

    public void deleteKey(int index)
    {
        if (index < 0 || index >= size)
        {
            return;
        }
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

    public int getMin()
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

    public static void main(String args[])
    {
        BinaryHeap h = new BinaryHeap(20);

        h.insert(4);
        h.insert(1);
        h.insert(2);
        h.insert(6);
        h.insert(7);
        h.insert(3);
        h.insert(8);
        h.insert(5);

        System.out.println("Min value is " + h.getMin());

        h.insert(-1);
        System.out.println("Min value is " + h.getMin());

        h.decreaseKey(3, -2);
        System.out.println("Min value is (decreaseKey) " + h.getMin());

        h.extractMin();
        System.out.println("Min value is (extractMin) " + h.getMin());

        h.deleteKey(0);
        System.out.println("Min value is (deleteKey) " + h.getMin());
    }
}
