package demouml;

import java.util.ArrayList;
import java.util.Iterator;

public class PlayerContainer {
    PlayerIterator humanPlayers;
    PlayerIterator robotPlayers;

    public PlayerContainer(PlayerIterator humanPlayers, PlayerIterator robotPlayers) {
        this.humanPlayers = humanPlayers;
        this.robotPlayers = robotPlayers;
    }

    public void printPlayers() {
        printPlayerIterator(getArrayList().iterator());

        System.out.println("TOTAL PLAYERS: " + getArrayList().size());
    }

    public void printPlayerIterator(Iterator iterator) {
        while (iterator.hasNext()) {
            Player player = (Player) iterator.next();
            System.out.println(player.getName());
        }
    }

    public ArrayList<Player> getArrayList() {
        ArrayList<Player> playerArrayList = new ArrayList<Player>();
        addIteratorToArrayList(humanPlayers.createIterator(), playerArrayList);
        addIteratorToArrayList(robotPlayers.createIterator(), playerArrayList);
        return playerArrayList;
    }

    public void addIteratorToArrayList(Iterator iterator, ArrayList<Player> arrayList) {
        while (iterator.hasNext()) {
            Player player = (Player) iterator.next();
            arrayList.add(player);
        }
    }
}
