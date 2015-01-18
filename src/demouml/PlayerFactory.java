package demouml;

public class PlayerFactory {
    public Player getPlayer(String playerType, String playerName) {
        if (playerType.equalsIgnoreCase("Human")) {
            return new HumanPlayer(playerName);
        } else if (playerType.equalsIgnoreCase("Robot")) {
            return new RobotPlayer(playerName);
        } else if (playerType.equalsIgnoreCase("SmartRobot")) {
            return new SmartRobotPlayerAdapter(playerName);
        } else {
            return null;
        }
    }
}
