
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubSequence {

    static boolean isAnagram(String str1, String str2) {
        String s1 = str1.replaceAll("\\s", "");
        String s2 = str2.replaceAll("\\s", "");
        boolean status = true;
        if (s1.length() != s2.length()) {
            status = false;
        } else {
            char[] ArrayS1 = s1.toLowerCase().toCharArray();
            char[] ArrayS2 = s2.toLowerCase().toCharArray();
            Arrays.sort(ArrayS1);
            Arrays.sort(ArrayS2);
            status = Arrays.equals(ArrayS1, ArrayS2);
        }
        return status;

    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        List<String> l = new ArrayList<>();
        int n = scr.nextInt();
        String s = scr.next();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                String p = s.substring(i, j);
                l.add(p);
            }
        }
        int size = l.size();
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                if (isAnagram(l.get(i), l.get(j))) {
                    if (l.get(i).length() > max)
                        max = l.get(i).length();
                }
            }
        }
        System.out.println(max - 1);
        scr.close();
    }
}
