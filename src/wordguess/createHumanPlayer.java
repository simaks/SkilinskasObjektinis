package wordguess;

public class createHumanPlayer implements PlayerChain {
    private PlayerChain nextChain;

    @Override
    public void setNextChain(PlayerChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public Player createPlayer(String playerType, String playerName) {
        if (playerType.equalsIgnoreCase("Human")) {
            return new HumanPlayer(playerName);
        } else {
            return nextChain.createPlayer(playerType, playerName);
        }
    }
}
