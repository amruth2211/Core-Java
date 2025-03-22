package Sorting_algorithms;

public class SelectionSort {
    // Prgoram to implement selection sort
    // The time complexity of the selection sort is O(n^2)
    // uses of slelection sort are when the memory write is a costly operation and
    // the list is small and when the list is almost sorted and when the cost of
    // swapping is very high

    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;

        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        selectionSort(arr);
        System.out.println("Sorted array");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
