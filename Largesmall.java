public class Largesmall {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 7, 8, 9 };
        int min = a[0];
        int max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
            else if (a[i] < min)
                min = a[i];
        }

        System.out.println("Largest Number is : " + max);
        System.out.println("Smallest Number is : " + min);
    }
}
