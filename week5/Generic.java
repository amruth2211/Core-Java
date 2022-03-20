package week5;

class GenericExample {

    <T> void multiply(Integer para1, T para2) {

        if (para2.getClass().getSimpleName().equals("Integer") || para2.getClass().getSimpleName().equals("Double")) {

            System.out.println("Multipilcation result : " + para1 * Double.parseDouble(String.valueOf(para2)));
        } else if (para2.getClass().getSimpleName().equals("String")) {
            System.out.println("Multiplication is not supported");
        } else
            System.out.println("False ");
    }

}

class Generic {

    public static void main(String[] args) {
        GenericExample g = new GenericExample();
        g.multiply(10, 12);
        g.multiply(18, "Multiplication");
        g.multiply(15, true);
    }

}