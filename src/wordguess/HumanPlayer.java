package wordguess;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanPlayer implements Player {
    private String name;
    private Logger logger;

    public HumanPlayer(String name) {
        this.name = name;
        this.logger = Logger.getInstance();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public char chooseLetter(String letters, String wordStatus) {
        String input = "";
        System.out.println("Unused letters: " + letters);
        while (input.length() != 1) {
            System.out.print("Enter one character:");
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                input = br.readLine();
            }
            catch (IOException e){
                logger.logMessage("Error reading from user");
            }
        }
        return input.charAt(0);
    }
}
