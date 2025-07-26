package ipc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    // Thread-safe logging method
    public static synchronized void log(String who, String message) {
        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + timestamp + "] [" + who + "] " + message);
    }
}