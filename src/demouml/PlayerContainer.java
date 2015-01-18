package demouml;

import java.util.Iterator;

public class PlayerContainer {
    PlayerIterator humanPlayers;
    PlayerIterator robotPlayers;

    public PlayerContainer(PlayerIterator humanPlayers, PlayerIterator robotPlayers) {
        this.humanPlayers = humanPlayers;
        this.robotPlayers = robotPlayers;
    }

    public void showPlayers() {

        System.out.println("NEW WAY WITH ITERATOR\n");

        Iterator humans = humanPlayers.createIterator();
        Iterator robots = robotPlayers.createIterator();

        System.out.println("Humans");
        printThePlayers(humans);

        System.out.println("Robots");
        printThePlayers(robots);
    }


    public void printThePlayers(Iterator iterator) {
        while (iterator.hasNext()) {
            Player songInfo = (Player) iterator.next();
            System.out.println(songInfo.getName());
        }
    }
}
