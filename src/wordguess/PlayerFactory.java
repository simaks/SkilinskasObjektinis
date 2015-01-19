package wordguess;

public class PlayerFactory {
    private PlayerChain chain1 = new createHumanPlayer();
    private PlayerChain chain2 = new createRobotPlayer();
    private PlayerChain chain3 = new createSmartRobotPlayer();
    private PlayerChain chain4 = new createNullPlayer();

    public PlayerFactory() {
        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
        chain3.setNextChain(chain4);
    }

    public Player getPlayer(String playerType, String playerName) {
        return chain1.createPlayer(playerType, playerName);
    }
}
