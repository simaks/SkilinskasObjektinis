import demouml.PlayerFactory;
import demouml.Logger;
import demouml.GameControlFacade;

public class Main {

    private static Logger logger = Logger.getInstance();
    public static void main(String[] args) {
        logger.logMessage("[****** Program start ******]");
        PlayerFactory playerFactory = new PlayerFactory();
        GameControlFacade gameControlFacade = new GameControlFacade();
        gameControlFacade.addPlayer(playerFactory.getPlayer("Human", "Human 1"));
        gameControlFacade.addPlayer(playerFactory.getPlayer("Robot", "Robot 1"));
        gameControlFacade.addPlayer(playerFactory.getPlayer("Robot", "Robot 2"));
        gameControlFacade.gameRun();
        logger.logMessage("[******  Program end  ******]");
    }
}
