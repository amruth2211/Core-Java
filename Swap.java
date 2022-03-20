public class Swap {
    public static void swap(int i, int j) {
        System.out.println("Before swaping values ");
        System.out.println("i = " + i + " j = " + j);
        int temp;
        temp = i;
        i = j;
        j = temp;
        System.out.println("After swaping values ");
        System.out.println("i = " + i + " j = " + j);
    }

    public static void main(String[] args) {
        int i = 10;
        int j = 13;
        swap(i, j);
    }
}
