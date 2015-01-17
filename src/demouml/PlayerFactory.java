package demouml;

public class PlayerFactory {
    public Player getPlayer(String playerType) {
        // TODO: use chain of responsibility
        if (playerType.equalsIgnoreCase("Human")) {
            return new HumanPlayer();
        } else if (playerType.equalsIgnoreCase("Robot")) {
            return new RobotPlayer();
        } else {
            // TODO: Add checks for this case
            return null;
        }
    }
}
