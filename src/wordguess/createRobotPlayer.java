package wordguess;

public class CreateRobotPlayer implements PlayerChain {
    private PlayerChain nextChain;

    @Override
    public void setNextChain(PlayerChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public Player createPlayer(String playerType, String playerName) {
        if (playerType.equalsIgnoreCase("Robot")) {
            return new RobotPlayer(playerName);
        } else {
            return nextChain.createPlayer(playerType, playerName);
        }
    }
}
