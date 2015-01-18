package demouml;

import java.util.ArrayList;
import java.util.Iterator;

public class HumanPlayers implements PlayerIterator {
    ArrayList<Player> players;
    PlayerFactory factory;

    public HumanPlayers() {
        factory = new PlayerFactory();
        players = new ArrayList<Player>();
    }

    public void addPlayer(String playerName) {
        Player player = factory.getPlayer("Human", playerName);
        players.add(player);
    }

    @Override
    public Iterator createIterator() {
        return players.iterator();
    }
}
