package wordguess;

public class SmartRobotPlayerAdapter implements Player {
    SmartRobot smartRobot;
    public SmartRobotPlayerAdapter(String name, Dictionary dictionary) {
        smartRobot = new SmartRobot(name, dictionary);
    }

    @Override
    public void setName(String name) {
        smartRobot.setIdCode(name);
    }

    @Override
    public String getName() {
        return smartRobot.getIdCode();
    }

    @Override
    public char chooseLetter(String letters, String wordStatus) {
        return smartRobot.guessLetter(letters, wordStatus);
    }

    @Override
    public Player makeCopy() {
        Player playerObject = null;
        try {
            playerObject = (SmartRobotPlayerAdapter) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return playerObject;
    }
}
