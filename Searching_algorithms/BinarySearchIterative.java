package Searching_algorithms;

class BinarySearchIterative {


    static int binarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            // Check if x is present at mid
            if (arr[mid] == x)
                return mid;

            // If x greater, ignore left half
            if (arr[mid] < x)
                l = mid + 1;

            // If x is smaller, ignore right half
            else
                r = mid - 1;
        }

        // if we reach here, then element was
        // not present
        return -1;
    }

    public static void main(String args[]) {
        int[] arr = { 2, 3, 4, 10, 40 };
        System.err.println("Index" + binarySearch(arr, 10));
    }
}
