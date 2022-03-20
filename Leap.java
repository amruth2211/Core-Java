public class Leap {
    public static void main(String[] args) {
        int y = 2000;
        if (y % 4 == 0) {
            if (y % 100 == 0) {
                if (y % 400 == 0)
                    System.out.println(y + " is " + "Leap year");
                else
                    System.out.println(y + " is " + "Not a Leap year");
            } else
                System.out.println(y + " is " + "Not a Leap year");
        } else
            System.out.println(y + " is " + "Not a Leap year");
    }
}
