package Searching_algorithms;

public class FirstOccurenceInSortedArray {

    static int firstOccurence(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < x) {
                low = mid + 1;
            } else if (arr[mid] > x) {
                high = mid - 1;
            } else {
                if (mid == 0 || arr[mid - 1] != arr[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = { 1, 2, 5, 10, 10, 12, 19 };
        System.err.println("Index" + firstOccurence(arr, 10));
    }
}
