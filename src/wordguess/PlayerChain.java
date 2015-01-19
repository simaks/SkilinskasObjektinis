package wordguess;

public interface PlayerChain {
    public void setNextChain(PlayerChain nextChain);

    public Player createPlayer(String playerType, String playerName);
}
