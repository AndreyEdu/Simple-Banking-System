package banking;

import java.util.Scanner;

import static banking.sql.Connect.*;

public class Main {
    public static void main(String[] args) {

        connect(args[1]);
        createNewTable();

        Scanner scanner = new Scanner(System.in);
        boolean stop1 = true;
        Account account = null;

        do {
            System.out.println("""
                            1. Create an account
                            2. Log into account
                            0. Exit
                            """);

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    account = new Account();
                    account.create();
                    break;
                case 2:
                    System.out.println("Enter your card number:");
                    String cardNumber = scanner.next();
                    System.out.println("Enter your PIN:");
                    String PINNumber = scanner.next();

                    if (account != null) {
                        if (account.checkData(cardNumber, PINNumber)) {
                            boolean stop2 = true;
                            System.out.println("You have successfully logged in!");
                            do {
                                System.out.println("""
                                    1. Balance
                                    2. Log out
                                    0. Exit
                                    """);

                                int logIn = scanner.nextInt();

                                switch (logIn) {
                                    case 1:
                                        System.out.println("Balance: " + account.getBalance());
                                        break;
                                    case 2:
                                        stop2 = false;
                                        break;
                                    case 0:
                                        stop1 = false;
                                        stop2 = false;
                                        break;
                                }
                            } while (stop2);
                        } else {
                            System.out.println("Wrong card number or PIN!");
                        }
                    } else {
                        System.out.println("Create an account first");
                    }

                    break;
                case 0:
                    stop1 = false;
                    System.out.println("Bye!");
                    break;
            }

        }while (stop1);

    }
}