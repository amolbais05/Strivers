package queue;

public class QueueUsingArray
{
    private int[] arr;
    private int start;
    private int end;
    private int size;
    private int currentSize;

    public QueueUsingArray(int size)
    {
        arr = new int[size];
        start = -1;
        end = -1;
        this.size = 0;
    }

    private void enqueue(int data)
    {
        if (size == currentSize)
        {
            System.out.println("Queue is full");
            return;
        }
        if (currentSize == 0)
        {
            start = 0;
            end = 0;
        }
        else
        {
            end = (end + 1) % size;
        }
        arr[end] = data;
        currentSize++;
        System.out.println("Enqueued " + data);
    }

    private int dequeue()
    {
        if (currentSize == 0)
        {
            System.out.println("Queue is empty");
            return -1;
        }
        int data = arr[start];
        if (currentSize == 1)
        {
            start = end = -1;
        }
        else
        {
            start = (start + 1) % size;
        }
        currentSize--;
        return data;
    }

    private int peek()
    {
        if (currentSize == 0)
        {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[start];
    }

    private int size()
    {
        return currentSize;
    }

}
