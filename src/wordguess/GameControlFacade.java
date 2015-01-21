package wordguess;

import java.util.ArrayList;
import java.util.LinkedList;

public class GameControlFacade {
    private LinkedList<Player> gamePlayers;
    private int activePlayerIndex;
    private String unknownLetters;
    private String word;
    private GetDictionaryData dictionaryData;
    private String usedLetters;
    private Logger logger;

    public GameControlFacade(Dictionary dictionary) {
        this.activePlayerIndex = 0;
        this.gamePlayers = new LinkedList<Player>();
        dictionaryData = new DictionaryProxy(dictionary);
        logger = Logger.getInstance();
    }

    public void addPlayer(Player player) {
        gamePlayers.add(player);
    }

    public void addPlayers(ArrayList<Player> players) {
        for (Player p : players) {
            gamePlayers.add(p);
        }
    }

    public void gameRun() {
        if (gamePlayers.size() <= 0) {
            logger.logMessage("At least 1 player is needed to start the game.");
            return;
        }
        this.word = dictionaryData.getRandomDictionaryWord().toLowerCase();
        this.unknownLetters = word;
        this.usedLetters = "";
        logger.logMessage("[**** " + getActivePlayer().getName() + " turn. ****]");
        while (!this.gameOver()) {
            logger.logMessage("Word status: " + wordStatus());
            if (!askLetterFromPlayer(this.getActivePlayer())) {
                switchToNextPlayerIndex();
                logger.logMessage("[**** " + getActivePlayer().getName() + " turn. ****]");
            }
        }
        logger.logMessage(this.getActivePlayer().getName() + " has won the game! Answer: " + this.word);
    }

    public boolean gameOver() {
        return this.unknownLetters.length() <= 0;
    }

    public Player getActivePlayer() {
        return this.gamePlayers.get(this.activePlayerIndex);
    }

    private void switchToNextPlayerIndex() {
        logger.logMessage("Switching player");
        this.activePlayerIndex++;
        if (this.activePlayerIndex >= this.gamePlayers.size()) {
            this.activePlayerIndex = 0;
        }
    }

    private boolean askLetterFromPlayer(Player player) {
        char chosenLetter = player.chooseLetter(this.getUnusedLetters(), wordStatus());
        logger.logMessage(this.getActivePlayer().getName() + " guesses " + chosenLetter);
        if (this.usedLetters.indexOf(chosenLetter) == -1) {
            usedLetters += chosenLetter;
        }
        if (this.unknownLetters.indexOf(chosenLetter) > -1) {
            this.unknownLetters = this.unknownLetters.replace(Character.toString(chosenLetter), "");
            return true;
        } else {
            return false;
        }
    }

    public String getUnusedLetters() {
        String unusedLetters = dictionaryData.getDictionaryAlphabet();
        for (int i = 0; i < this.usedLetters.length(); i++) {
            unusedLetters = unusedLetters.replace(Character.toString(usedLetters.charAt(i)), "");
        }
        return unusedLetters;
    }

    public String wordStatus() {
        String wordStatus = "";
        for (int i = 0; i < this.word.length(); i++) {
            if (usedLetters.contains(Character.toString(word.charAt(i)))) {
                wordStatus += this.word.charAt(i);
            } else {
                wordStatus += "_";
            }
        }
        return wordStatus;
    }
}
