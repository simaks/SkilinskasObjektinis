package wordguess;

import java.util.Hashtable;
import java.util.Iterator;

public class RobotPlayers implements PlayerIterator {
    Hashtable<Integer, Player> players = new Hashtable<Integer, Player>();
    int playerCount = 0;
    PlayerFactory factory;

    public RobotPlayers(Dictionary dictionary) {
        factory = new PlayerFactory(dictionary);
    }

    public void addPlayer(String playerName) {
        Player player = factory.getPlayer("Robot", playerName);
        players.put(playerCount++, player);
    }

    public void addPlayer(Player player) {
        players.put(playerCount++, player);
    }

    @Override
    public Iterator createIterator() {
        return players.values().iterator();
    }
}
