package banking;

import java.util.Arrays;
import java.util.Random;

public class Card {

    private final int[] bankIdentificationNumber = new int[] {4, 0, 0, 0, 0, 0};
    private final int[] accountIdentifier = new int[9];

    private int checkSum;

    Random random = new Random();

    public Card() {

        int[] numberCardLuhn = new int[9];
        int sum = 8;

        for (int i = 0; i < accountIdentifier.length; i++) {
            accountIdentifier[i] = random.nextInt(10);
            numberCardLuhn[i] = accountIdentifier[i];
        }

        for (int i = 0; i < numberCardLuhn.length; i++) {
            if (i % 2 == 0) {
                numberCardLuhn[i] *= 2;
                if (numberCardLuhn[i] > 9) {
                    numberCardLuhn[i] -= 9;
                }
            }
            sum += numberCardLuhn[i];
        }
        System.out.println(sum);

        for (int i = 0; i < 10; i++) {
            if ((sum + i) % 10 == 0) {
                this.checkSum = i;
            }
        }
    }

    public String getID() {
        StringBuilder sb = new StringBuilder();

        for (int j : bankIdentificationNumber) {
            sb.append(j);
        }

        for (int j : accountIdentifier) {
            sb.append(j);
        }
        sb.append(this.checkSum);
        return sb.toString();
    }
}
