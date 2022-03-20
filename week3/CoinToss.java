package week3;

class Coin {
    String sideUp;

    public Coin() {
        toss();
    }

    void toss() {
        int random = (int) (Math.random() * 2);
        switch (random) {
            case 0: {
                this.sideUp = "Tail";
                break;
            }
            case 1: {
                this.sideUp = "Head";
                break;
            }
            default:
                this.sideUp = "";
        }
    }

    public String getSideUp() {
        return sideUp;
    }

}

public class CoinToss {
    public static void main(String[] args) {

        double balance = 0.0;

        Coin quarter = new Coin();
        Coin dime = new Coin();
        Coin nickel = new Coin();

        while (balance < 1.0) {
            quarter.toss();
            dime.toss();
            nickel.toss();

            if (quarter.sideUp.equals("Head")) {
                balance += 0.25;
            }

            else if (dime.sideUp.equals("Head")) {
                balance += 0.10;
            }

            else if (nickel.sideUp.equals("Head")) {
                balance += 0.05;
            } else
                balance += 0.0;
        }
        System.out.println("Balance: " + balance);

        if (balance == 1.0) {
            System.out.println("You win!");
        } else {
            System.out.println("You Lose");
        }
    }
}
