package wordguess;

public interface Player extends Cloneable {
    public void setName(String name);
    public String getName();
    public char chooseLetter(String letters, String wordStatus);
    public Player makeCopy();
}
