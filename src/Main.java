import demouml.PlayerFactory;
import demouml.Player;

public class Main {

    public static void main(String[] args) {
        PlayerFactory playerFactory = new PlayerFactory();
        Player hPlayer = playerFactory.getPlayer("Human");
        Player rPlayer = playerFactory.getPlayer("Robot");
        hPlayer.makeMove();
        rPlayer.makeMove();
        System.out.println("Game Over!");
    }
}
