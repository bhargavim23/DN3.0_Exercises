package SingletonPatternExample;

public class Logger {
    private static Logger instance;
    private Logger() {
    }
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("Log: " + message);
    }
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        logger1.log("First log message");
        logger2.log("Second log message");
        System.out.println("Are both instances equal?" + (logger1 == logger2));
    }
}
