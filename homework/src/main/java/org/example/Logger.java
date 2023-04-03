package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Logger implements Loggerable{


    private static Logger INSTANCE;

    private Logger() {
    }

    public static Logger getINSTANCE() {
        return INSTANCE;
    }

    HashMap<LogLevel, Integer> counter = new HashMap<>();
    public void log_message (LogLevel log_level, String message){
        LocalDateTime date1 = LocalDateTime.now();
        DateTimeFormatter form =  DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(message +"" + log_level + "" + date1.format(form) );
        if (!counter.containsKey(log_level)) {
            counter.put(log_level, 0);
        }
        counter.replace(log_level, counter.get(log_level) + 1);

    }

    @Override
    public int get_level_messages_count(LogLevel log_level) {
        if (!counter.containsKey(log_level)) {
            return 0;
        }
        return counter.get(log_level);
    }
}
