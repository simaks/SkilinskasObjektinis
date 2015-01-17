package demouml;

public class PlayerFactory {
    public Player getPlayer(String playerType, String playerName) {
        // TODO: use chain of responsibility
        if (playerType.equalsIgnoreCase("Human")) {
            return new HumanPlayer(playerName);
        } else if (playerType.equalsIgnoreCase("Robot")) {
            return new RobotPlayer(playerName);
        } else {
            // TODO: Add checks for this case
            return null;
        }
    }
}
