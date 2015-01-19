import wordguess.*;

public class Main {

    private static Logger logger = Logger.getInstance();
    private static PlayerFactory playerFactory = new PlayerFactory();

    public static void main(String[] args) {
        logger.logMessage("[****** Program start ******]");
        HumanPlayers humanPlayers = new HumanPlayers();
        RobotPlayers robotPlayers = new RobotPlayers();
        humanPlayers.addPlayer("Jonas");
        robotPlayers.addPlayer("R1");
        robotPlayers.addPlayer("R2");
        Player r3 = playerFactory.getPlayer("Robot", "R3");
        Player r3Copy = r3.makeCopy();
        r3Copy.setName("Copy of " + r3Copy.getName());
        robotPlayers.addPlayer(r3);
        robotPlayers.addPlayer(r3Copy);
        PlayerContainer playerContainer = new PlayerContainer(humanPlayers, robotPlayers);
        playerContainer.printPlayers();

        GameControlFacade gameControlFacade = new GameControlFacade();
        gameControlFacade.addPlayer(playerFactory.getPlayer("null", "Mr. null"));
        gameControlFacade.addPlayers(playerContainer.getArrayList());
        gameControlFacade.addPlayer(playerFactory.getPlayer("SmartRobot", "Smarty3000"));
        gameControlFacade.gameRun();
        logger.logMessage("[******  Program end  ******]");
    }
}
