public class FileLoggerConfiguration {
    private LoggingLevel logLevel;

    public LoggingLevel getLogLevel() {
        return logLevel;
    }
    private String filePath;
    private LoggingLevel loggingLevel;
    private long maxFileSize;
    private String format;

    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel, long maxFileSize, String format) {
        this.filePath = filePath;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = maxFileSize;
        this.format = format;
    }

    public String getFilePath() {
        return filePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getFormat() {
        return format;
    }
}