package Objects_Array;

import java.util.Scanner;

class Fruits {
    private int fruitId;
    private String fruitName;
    private int price;
    private int rating;

    public Fruits() {
        this.fruitId = 0;
        this.fruitName = "";
        this.price = 0;
        this.rating = 0;
    }

    public Fruits(int fruitId, String fruitName, int price, int rating) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.rating = rating;
    }

    public int getFruitId() {
        return fruitId;
    }

    public void setFruitId(int fruitId) {
        this.fruitId = fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
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

}

public class Task {

    static Fruits findMaximunPiceByRating(Fruits[] f, int parameter) {
        Fruits result = null;
        boolean found = false;
        for (int i = 0; i < f.length; i++) {
            if (f[i].getRating() > parameter) {
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
        Fruits[] f = new Fruits[4];
        for (int i = 0; i < f.length; i++) {
            f[i] = new Fruits();
            f[i].setFruitId(scr.nextInt());
            scr.nextLine();
            f[i].setFruitName(scr.nextLine());
            f[i].setPrice(scr.nextInt());
            scr.nextLine();
            f[i].setRating(scr.nextInt());
            scr.nextLine();
        }
        int p = scr.nextInt();

        if (findMaximunPiceByRating(f, p) != null) {
            System.out.println(findMaximunPiceByRating(f, p).getFruitId());
        } else
            System.out.println("No such Fruit");
        scr.close();
    }

}
