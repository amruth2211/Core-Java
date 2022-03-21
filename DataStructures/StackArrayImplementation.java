package DataStructures;

class Stack {

    private int[] array;
    private int top;

    Stack(int size) {
        array = new int[size];
        top = -1;
    }

    public void push(int n) {
        if (top == array.length - 1) {
            System.out.println("Stack overflow");
        } else {
            array[++top] = n;
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
        } else {
            System.out.println("Element popped " + array[top--]);
        }
    }

    public void peek() {
        System.out.println(array[top]);
    }

    public void displayStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}

public class StackArrayImplementation {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.pop();
        stack.push(1);
        stack.push(2);
        stack.push(8);
        stack.push(6);
        stack.push(9);
        // stack.push(8);
        stack.pop();
        stack.displayStack();

    }
}
