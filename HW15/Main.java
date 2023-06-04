import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileLoggerConfigurationLoader configurationLoader = new FileLoggerConfigurationLoader();
            FileLoggerConfiguration configuration = configurationLoader.load("logger-config.txt");

            FileLogger logger = new FileLogger(configuration);

            logger.log("This is an info message", LoggingLevel.INFO);
            logger.log("This is a debug message", LoggingLevel.DEBUG);
        } catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
        } catch (FileMaxSizeReachedException e) {
            System.out.println("File max size reached: " + e.getMessage());
        }
    }
}