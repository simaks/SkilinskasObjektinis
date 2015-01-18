package wordguess;

public interface Player {
    public String getName();
    public char chooseLetter(String letters, String wordStatus);
}
