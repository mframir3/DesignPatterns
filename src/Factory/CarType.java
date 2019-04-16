package Factory;

import java.util.Random;

public enum CarType {
    SPORT, HYBRID, TRUCK;

    /**
     * Pick a random value of the CarType enum.
     * @return a random BaseColor.
     */
    public static CarType getRandomCarType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
