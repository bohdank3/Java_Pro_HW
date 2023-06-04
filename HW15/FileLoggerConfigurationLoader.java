import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    public FileLoggerConfiguration load(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String fileLine;
            String logFilePath = null;
            LoggingLevel loggingLevel = null;
            long maxFileSize = 0;
            String format = null;

            while ((fileLine = reader.readLine()) != null) {
                if (fileLine.startsWith("FILE:")) {
                    logFilePath = fileLine.substring(6).trim();
                } else if (fileLine.startsWith("LEVEL:")) {
                    String level = fileLine.substring(7).trim();
                    loggingLevel = LoggingLevel.valueOf(level);
                } else if (fileLine.startsWith("MAX-SIZE:")) {
                    String size = fileLine.substring(10).trim();
                    maxFileSize = Long.parseLong(size);
                } else if (fileLine.startsWith("FORMAT:")) {
                    format = fileLine.substring(7).trim();
                }
            }

            return new FileLoggerConfiguration(logFilePath, loggingLevel, maxFileSize, format);
        }
    }
}