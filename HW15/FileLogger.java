import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private File logFile;
    private LoggingLevel currentLogLevel;
    private long maxFileSize;

    public FileLogger(FileLoggerConfiguration configuration) throws IOException {
        this.logFile = new File(configuration.getFilePath());

        // Проверяем, существует ли файл
        if (!logFile.exists()) {
            logFile.createNewFile();
        }

        this.currentLogLevel = configuration.getLogLevel();
        this.maxFileSize = configuration.getMaxFileSize();
    }

    public void log(String message, LoggingLevel level) throws IOException, FileMaxSizeReachedException {
        if (level.ordinal() <= currentLogLevel.ordinal()) {
            checkFileSize();

            String logMessage = "[" + getCurrentTime() + "]" + "[" + level.name() + "] " + "Message: " + message;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
                writer.write(logMessage);
                writer.newLine();
            }
        }
    }

    private String getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return currentTime.format(formatter);
    }

    private void checkFileSize() throws IOException, FileMaxSizeReachedException {
        long fileSize = logFile.length();
        if (fileSize >= maxFileSize) {
            throw new FileMaxSizeReachedException("Maximum file size reached. Current file size: " + fileSize + " bytes");
        }
    }
}