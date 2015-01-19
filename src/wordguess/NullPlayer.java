package wordguess;

public class NullPlayer implements Player {
    @Override
    public void setName(String name) {
    }

    @Override
    public String getName() {
        return "-";
    }

    @Override
    public char chooseLetter(String letters, String wordStatus) {
        return 0;
    }

    @Override
    public Player makeCopy() {
        Player playerObject = null;
        try {
            playerObject = (NullPlayer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return playerObject;
    }
}
