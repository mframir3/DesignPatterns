package Factory;

import java.util.Random;

public enum Color {
    RED, BLUE, GREEN, YELLOW, BLACK, ORANGE, WHITE, GREY, PURPLE, BABYBLUE;
    
    /**
     * Pick a random value of the Color enum.
     * @return a random Color.
     */
    public static Color getRandomColor() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
