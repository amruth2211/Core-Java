package Searching_algorithms;

public class LastOccurenceInSortedArray {
    static int lastOccurence(int[] arr, int x) {
        int low = 0;
        int n = arr.length;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                if (mid == n - 1 || arr[mid + 1] != arr[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 5, 10, 10, 10, 19 };
        System.err.println("Index" + lastOccurence(arr, 10));
    }
}
