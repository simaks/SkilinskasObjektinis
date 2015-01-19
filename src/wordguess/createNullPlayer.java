package wordguess;

public class createNullPlayer implements PlayerChain {

    @Override
    public void setNextChain(PlayerChain nextChain) {
    }

    @Override
    public Player createPlayer(String playerType, String playerName) {
        return new NullPlayer();
    }
}
