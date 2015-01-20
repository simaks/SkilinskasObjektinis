package wordguess;

public class CreateNullPlayer implements PlayerChain {

    @Override
    public void setNextChain(PlayerChain nextChain) {
    }

    @Override
    public Player createPlayer(String playerType, String playerName) {
        return new NullPlayer();
    }
}
