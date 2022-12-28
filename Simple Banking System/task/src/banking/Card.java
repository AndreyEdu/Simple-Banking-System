package banking;

import java.util.Arrays;
import java.util.Random;

public class Card {

    private final int[] bankIdentificationNumber = new int[] {4, 0, 0, 0, 0, 0};
    private final int[] accountIdentifier = new int[9];
    Random random = new Random();

    public Card() {

        int sum = 8;

        for (int i = 0; i < accountIdentifier.length; i++) {
            accountIdentifier[i] = random.nextInt(10);
        }


    }

    public String getID() {
        int checkSum = 4;
        StringBuilder sb = new StringBuilder();

        for (int j : bankIdentificationNumber) {
            sb.append(j);
        }

        for (int j : accountIdentifier) {
            sb.append(j);
        }
        sb.append(checkSum);
        return sb.toString();
    }
}
