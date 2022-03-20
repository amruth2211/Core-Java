package Week4;

//To remove the trailing space without using the inbuilt trim method 

public class TrailSpace {
    public static void main(String[] args) {
        String s = "   Hi Hello World   ";
        int n = s.length();
        int i = 0, j = n - 1;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        while (j >= 0 && s.charAt(j) == ' ') {
            j--;
        }
        System.out.println(s.substring(i, j + 1));

    }
}
