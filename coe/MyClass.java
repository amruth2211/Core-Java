package coe;

import java.util.Scanner;

class Flowers {
    private int flowerId;
    private String flowerName;
    private int price;
    private int rating;
    private String type;

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

public class MyClass {
    static Flowers findMinPiceByType(Flowers[] f, String parameter) {
        Flowers result = null;
        boolean found = false;
        for (int i = 0; i < f.length; i++) {
            if (f[i].getRating() > 3 && f[i].getType().equals(parameter)) {
                result = f[i];
                found = true;
            }
        }
        if (found) {
            return result;
        } else
            return null;

    }

    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);
        Flowers[] f = new Flowers[4];
        for (int i = 0; i < f.length; i++) {
            f[i] = new Flowers();
            f[i].setFlowerId(scr.nextInt());
            scr.nextLine();
            f[i].setFlowerName(scr.nextLine());
            f[i].setPrice(scr.nextInt());
            scr.nextLine();
            f[i].setRating(scr.nextInt());
            scr.nextLine();
            f[i].setType(scr.next());
            scr.nextLine();
        }
        String p = scr.next();

        if (findMinPiceByType(f, p) != null) {
            System.out.println(findMinPiceByType(f, p).getFlowerId());

        } else
            System.out.println("There is no flower with given type");
        scr.close();
    }
}
