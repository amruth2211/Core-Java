
public class MergeSort {

    public static void merge(int[] a, int l, int m, int r) {

        int i = l;
        int j = m + 1;
        int x = 0;
        int[] merge = new int[r - l + 1];

        while (i <= m && j <= r) {
            if (a[i] <= a[j])
                merge[x++] = a[i++];
            else
                merge[x++] = a[j++];
        }
        while (i <= m)
            merge[x++] = a[i++];
        while (j <= r)
            merge[x++] = a[j++];

        for (int p = 0, q = l; p < merge.length; p++, q++) {
            a[q] = merge[p];
        }

    }

    public static void divide(int[] a, int l, int r) {

        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        divide(a, l, mid);
        divide(a, mid + 1, r);

        merge(a, l, mid, r);

    }

    public static void main(String[] args) {

        int[] a = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };
        int n = a.length;
        divide(a, 0, n - 1);

        for (int ele : a) {
            System.out.println(ele);
        }
    }

}
