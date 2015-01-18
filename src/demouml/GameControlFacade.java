package demouml;

import java.util.LinkedList;

public class GameControlFacade {
    private LinkedList<Player> gamePlayers;
    private int activePlayerIndex;
    private String lettersLeft;
    private String word;
    private Dictionary dictionary;
    private String usedLetters;
    private Logger logger;

    public GameControlFacade() {
        this.activePlayerIndex = 0;
        this.gamePlayers = new LinkedList<Player>();
        dictionary = Dictionary.getInstance();
        logger = Logger.getInstance();
    }

    public void addPlayer(Player player) {
        gamePlayers.add(player);
    }

    public void gameRun() {
        this.word = dictionary.getRandomWord().toLowerCase();
        this.lettersLeft = word;
        this.usedLetters = "";
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
        return this.lettersLeft.length() <= 0;
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
        char chosenLetter = player.chooseLetter(this.getUnusedLetters());
        logger.logMessage(this.getActivePlayer().getName() + " guesses " + chosenLetter);
        if (this.usedLetters.indexOf(chosenLetter) == -1) {
            usedLetters += chosenLetter;
        }
        if (this.lettersLeft.indexOf(chosenLetter) > -1) {
            this.lettersLeft = this.lettersLeft.replace(Character.toString(chosenLetter), "");
            return true;
        } else {
            return false;
        }
    }

    public String getUnusedLetters() {
        String unusedLetters = dictionary.getAlphabet();
        for (int i = 0; i < this.usedLetters.length(); i++) {
            unusedLetters = unusedLetters.replace(Character.toString(usedLetters.charAt(i)), "");
        }
        logger.logMessage(usedLetters);
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
