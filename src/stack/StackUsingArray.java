package stack;

public class StackUsingArray
{
    private int[] arr;
    private int top;
    private int capacity;

    public StackUsingArray(int capacity)
    {
        this.capacity = capacity;
        arr = new int[capacity];
        top = -1;
    }

    public boolean isEmpty()
    {
        return top == -1;
    }

    public boolean isFull()
    {
        return top == capacity - 1;
    }

    public void push(int data)
    {
        if (isFull())
        {
            System.out.println("Stack overflow! Resizing...");
            resize();
        }
        arr[++top] = data;
    }

    public int pop()
    {
        if (isEmpty())
        {
            throw new RuntimeException("Stack underflow! No elements to pop.");
        }
        return arr[top--];
    }

    public int peek()
    {
        if (isEmpty())
        {
            throw new RuntimeException("Stack is empty! Nothing to peek.");
        }
        return arr[top];
    }

    public int size()
    {
        return top + 1;
    }

    private void resize()
    {
        capacity = capacity * 2;
        int[] newArr = new int[capacity];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    public void print()
    {
        for (int i = top; i >= 0; i--)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        StackUsingArray stack = new StackUsingArray(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print();

        stack.push(40); // Triggers resizing
        stack.print();

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        stack.print();
    }
}
