package stack;

public class StackUsingArray
{
    private int[] arr;
    private int top;
    private int size;

    public StackUsingArray(int size)
    {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    public boolean isEmpty()
    {
        return top == -1;
    }

    public void push(int data)
    {
        if (top == size - 1)
        {
            System.out.println("Stack is full");
            return;
        }
        top++;
        arr[top] = data;
    }

    public int pop()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty");
            return -1;
        }
        int data = arr[top];
        top--;
        return data;
    }

    public int top()
    {
        if (isEmpty())
        {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
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
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();

        System.out.println(stack.pop());
        stack.print();
        System.out.println(stack.top());
        stack.print();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.print();
    }
}
