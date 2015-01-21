package wordguess;

import java.util.Random;

public class SmartRobot {
    private String idCode;
    private GetDictionaryData dictionaryProxy;

    public SmartRobot(String idCode) {
        this.idCode = idCode;
        dictionaryProxy = new DictionaryProxy();
    }

    public void setIdCode(String idCode) {
        this.idCode = idCode;
    }

    public String getIdCode() {
        return this.idCode;
    }

    public char guessLetter(String letters, String wordStatus) {
        String bestWord = bestDictionaryWord(wordStatus, letters);
        if (bestWord.length() > 0) {
            String unknownLetters = unknownLetters(bestWord, wordStatus);
            if (unknownLetters.length() > 0) {
                return unknownLetters.charAt(0);
            }
        }


        return randomLetter(letters);
    }

    private String bestDictionaryWord(String fit, String availableLetters) {
        String bestWord = "";
        for (String w : dictionaryProxy.getDictionaryWords()) {
            w = w.toLowerCase();
            if (wordFits(w, fit) && allLettersIn(unknownLetters(w, fit), availableLetters)) {
                bestWord = w;
            }
        }
        return bestWord;
    }

    private boolean wordFits(String word, String fit) {
        if (word.length() == fit.length()) {
            for (int i = 0; i < fit.length(); i++) {
                if (fit.charAt(i) != '_' && fit.charAt(i) != word.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private String unknownLetters(String word, String fit) {
        String letters = "";
        if (word.length() == fit.length()) {
            for (int i = 0; i < fit.length(); i++) {
                if (fit.charAt(i) == '_') {
                    letters += word.charAt(i);
                }
            }
        }
        return letters;
    }

    /**
     * Check if all letters from s1 exists in s2
     */
    private boolean allLettersIn(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (!s2.contains(Character.toString(s1.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    private char randomLetter(String letters) {
        Random rand = new Random();
        int randomNum = rand.nextInt(letters.length());
        return letters.charAt(randomNum);
    }
}
