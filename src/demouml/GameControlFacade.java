package demouml;

import java.util.LinkedList;

public class GameControlFacade {
    private LinkedList<Player> gamePlayers;
    private int activePlayerIndex;
    private String lettersLeft;
    private String word;
    private Dictionary dictionary;
    private String usedLetters;

    public GameControlFacade() {
        this.activePlayerIndex = 0;
        this.gamePlayers = new LinkedList<Player>();
        dictionary = Dictionary.getInstance();
    }

    public void addPlayer(Player player) {
        gamePlayers.add(player);
    }

    public void gameRun() {
        this.word = dictionary.getRandomWord().toLowerCase();
        this.lettersLeft = word;
        this.usedLetters = "";
        while (!this.gameOver()) {
            if (!askLetterFromPlayer(this.getActivePlayer())) {
                switchToNextPlayerIndex();
            }
        }
        Logger.getInstance().logMessage(this.getActivePlayer().getName() + " has won the game! Answer: " + this.word);
    }

    public boolean gameOver() {
        return this.lettersLeft.length() <= 0;
    }

    public Player getActivePlayer() {
        return this.gamePlayers.get(this.activePlayerIndex);
    }

    private void switchToNextPlayerIndex() {
        Logger.getInstance().logMessage("Switching player");
        this.activePlayerIndex++;
        if (this.activePlayerIndex >= this.gamePlayers.size()) {
            this.activePlayerIndex = 0;
        }
    }

    private boolean askLetterFromPlayer(Player player) {
        char chosenLetter = player.chooseLetter(this.getUnusedLetters());
        Logger.getInstance().logMessage(this.getActivePlayer().getName() + " guesses " + chosenLetter);
        if (this.lettersLeft.indexOf(chosenLetter) > -1) {
            usedLetters += chosenLetter;
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
        return unusedLetters;
    }
}
