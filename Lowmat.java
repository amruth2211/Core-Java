public class Lowmat {
    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i < j)
                    a[i][j] = 0;
            }
        }
        for (int[] row : a) {
            for (int ele : row)
                System.out.print(ele + " ");
            System.out.println();
        }
    }
}
