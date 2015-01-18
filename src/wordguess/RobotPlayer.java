package wordguess;

import java.util.Random;

public class RobotPlayer implements Player {
    private String name;

    public RobotPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public char chooseLetter(String letters, String wordStatus) {
        Random rand = new Random();
        int randomNum = rand.nextInt(letters.length());
        return letters.charAt(randomNum);
    }
}
