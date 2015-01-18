import demouml.*;

public class Main {

    private static Logger logger = Logger.getInstance();

    public static void main(String[] args) {
        logger.logMessage("[****** Program start ******]");
        HumanPlayers humanPlayers = new HumanPlayers();
        RobotPlayers robotPlayers = new RobotPlayers();
        humanPlayers.addPlayer("Jonas");
        robotPlayers.addPlayer("R1");
        robotPlayers.addPlayer("R2");
        robotPlayers.addPlayer("R3");
        PlayerContainer playerContainer = new PlayerContainer(humanPlayers, robotPlayers);
        playerContainer.printPlayers();

        GameControlFacade gameControlFacade = new GameControlFacade();
        gameControlFacade.addPlayers(playerContainer.getArrayList());
        gameControlFacade.gameRun();
        logger.logMessage("[******  Program end  ******]");
    }
}
