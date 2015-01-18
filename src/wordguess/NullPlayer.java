package wordguess;

public class NullPlayer implements Player {
    @Override
    public String getName() {
        return "";
    }

    @Override
    public char chooseLetter(String letters, String wordStatus) {
        return 0;
    }
}
