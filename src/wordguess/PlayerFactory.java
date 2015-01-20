package wordguess;

public class PlayerFactory {
    private PlayerChain chain1 = new CreateHumanPlayer();
    private PlayerChain chain2 = new CreateRobotPlayer();
    private PlayerChain chain3 = new CreateSmartRobotPlayer();
    private PlayerChain chain4 = new CreateNullPlayer();

    public PlayerFactory() {
        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
        chain3.setNextChain(chain4);
    }

    public Player getPlayer(String playerType, String playerName) {
        return chain1.createPlayer(playerType, playerName);
    }
}
