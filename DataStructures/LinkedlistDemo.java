package DataStructures;

class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    int size() {
        if (!isEmpty()) {
            int count = 1;
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
                count++;
            }
            return count;
        }
        return -1;
    }

    boolean isEmpty() {
        return head == null;
    }

    void addAtFirst(int data) {
        Node n = new Node(data);
        if (isEmpty()) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
    }

    void addAtLast(int data) {
        if (isEmpty()) {
            addAtFirst(data);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node n = new Node(data);
            temp.next = n;
            n.next = null;
        }
    }

    void addAtPosition(int pos, int data) {
        if (pos == 1) {
            addAtFirst(data);
            return;
        }
        int size = size();
        if ((pos - 1) == size) {
            addAtLast(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            temp = temp.next;
        }
        Node n = new Node(data);
        n.next = temp.next;
        temp.next = n;

    }

    void displayList() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

}

public class LinkedlistDemo {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        l.addAtFirst(3);
        l.addAtLast(5);
        l.addAtFirst(4);
        System.out.println(l.size());
        l.addAtPosition(3, 6);
        l.displayList();
    }
}
