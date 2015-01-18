package demouml;

import java.util.Hashtable;
import java.util.Iterator;

public class RobotPlayers implements PlayerIterator {
    Hashtable<Integer, Player> players = new Hashtable<Integer, Player>();
    int playerCount = 0;
    PlayerFactory factory;

    public RobotPlayers() {
        factory = new PlayerFactory();
    }

    public void addPlayer(String playerName) {
        Player player = factory.getPlayer("Human", playerName);
        players.put(playerCount++, player);
    }

    @Override
    public Iterator createIterator() {
        System.out.println(playerCount);
        return players.values().iterator();
    }
}
