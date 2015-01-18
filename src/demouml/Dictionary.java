package demouml;

import java.util.Random;

public class Dictionary {
    private final static Dictionary instance = new Dictionary();
    final private String[] words = {
            "Word",
            "Hello",
            "Advice",
            "Palace",
            "Zoo",
            "Exchange",
            "Doll",
            "Positive",
    };
    final private String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private Dictionary() {
    }

    public static Dictionary getInstance() {
        return instance;
    }

    public String getAlphabet() {
        return this.alphabet;
    }

    public String getRandomWord() {
        Random rand = new Random();
        int randomNum = rand.nextInt(words.length);
        return words[randomNum];
    }

    public String[] getWords() {
        return words;
    }
}
