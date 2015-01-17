package demouml;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private final static Logger instance = new Logger();
    private SimpleDateFormat sdFormat = new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]");

    private Logger() {
    }

    public static Logger getInstance() {
        return instance;
    }

    public void logMessage(String message) {
        System.out.println(message);
        message = sdFormat.format(new Date()) + ' ' + message;
        writeData(message);
    }

    private void writeData(String message) {
        try {
            FileWriter fw = new FileWriter("game.log", true);
            fw.write(message + "\n");
            fw.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
}
