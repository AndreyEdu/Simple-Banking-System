package banking;

import banking.sql.Connect;

import java.util.Random;

public class Account {
    private final Card card;
    private final String PIN;
    private final int balance;

    private int id = 0;

    Random random = new Random();

    public Account() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(random.nextInt(10));
        }
        this.PIN = sb.toString();
        this.card = new Card();
        this.balance = 0;
        Connect.insert(++id, card.getID(), getPIN(), this.balance);
    }

    public void create() {
        System.out.println("Your card has been created");
        System.out.println("Your card number:");
        System.out.println(card.getID());
        System.out.println("Your card PIN:");
        System.out.println(getPIN());
    }

    public String getPIN() {
        return PIN;
    }

    public int getBalance() {
        return this.balance;
    }

    public boolean checkData(String cardNumber, String pinNumber) {
        return cardNumber.equals(card.getID()) && pinNumber.equals(getPIN());
    }
}
