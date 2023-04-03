package org.example;

public interface Loggerable {
    public void log_message(LogLevel log_level,String message);
    public int get_level_messages_count (LogLevel log_level);
}
