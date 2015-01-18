package wordguess;

public class SmartRobotPlayerAdapter implements Player {
    SmartRobot smartRobot;
    public SmartRobotPlayerAdapter(String name) {
        smartRobot = new SmartRobot(name);
    }

    @Override
    public String getName() {
        return smartRobot.getIdCode();
    }

    @Override
    public char chooseLetter(String letters, String wordStatus) {
        return smartRobot.guessLetter(letters, wordStatus);
    }
}
