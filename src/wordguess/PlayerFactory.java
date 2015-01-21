package wordguess;

public class PlayerFactory {
    private PlayerChain chain1;
    private PlayerChain chain2;
    private PlayerChain chain3;
    private PlayerChain chain4;

    public PlayerFactory(Dictionary dictionary) {
        chain1 = new CreateHumanPlayer();
        chain2 = new CreateRobotPlayer();
        chain3 = new CreateSmartRobotPlayer(dictionary);
        chain4 = new CreateNullPlayer();
        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
        chain3.setNextChain(chain4);
    }

    public Player getPlayer(String playerType, String playerName) {
        return chain1.createPlayer(playerType, playerName);
    }
}
