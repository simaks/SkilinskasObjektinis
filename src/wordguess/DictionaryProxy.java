package wordguess;

public class DictionaryProxy implements GetDictionaryData {
    private Dictionary dictionary;

    DictionaryProxy(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public String getDictionaryAlphabet() {
        return dictionary.getAlphabet();
    }

    @Override
    public String[] getDictionaryWords() {
        return dictionary.getWords();
    }

    @Override
    public String getRandomDictionaryWord() {
        return dictionary.getRandomWord();
    }
}
