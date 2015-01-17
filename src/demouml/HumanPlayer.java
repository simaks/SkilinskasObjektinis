package demouml;

public class HumanPlayer implements Player {
    private String name;

    public HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public char chooseLetter(String letters) {
        return 'a';
    }
}
