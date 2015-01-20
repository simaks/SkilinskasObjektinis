package wordguess;

public class CreateSmartRobotPlayer implements PlayerChain {
    private PlayerChain nextChain;

    @Override
    public void setNextChain(PlayerChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public Player createPlayer(String playerType, String playerName) {
        if (playerType.equalsIgnoreCase("SmartRobot")) {
            return new SmartRobotPlayerAdapter(playerName);
        } else {
            return nextChain.createPlayer(playerType, playerName);
        }
    }
}
