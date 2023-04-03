package testing;

import org.example.LogLevel;
import org.example.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

public class LoggerTesting {

    @Test
    void test1() {
        Logger logger = Logger.getINSTANCE();
        logger.log_message(LogLevel.ERROR,"log level ERROR");
        logger.log_message(LogLevel.ERROR,"log level ERROR");
        logger.log_message(LogLevel.DEBUG,"log level DEBUG");
        logger.log_message(LogLevel.DEBUG,"log level DEBUG");
        logger.log_message(LogLevel.DEBUG,"log level DEBUG");


        int expected = 3;
        int actual = logger.get_level_messages_count(LogLevel.DEBUG);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    void test2(){
        AtomicReference<Logger> logger2 = new AtomicReference<>();

        AtomicReference<Logger> logger3 = new AtomicReference<>();

        Logger logger1 = Logger.getINSTANCE();

        logger2.set(Logger.getINSTANCE());
        logger3.set(Logger.getINSTANCE());

        boolean expected = true;
        boolean actual = logger1 == logger2.get() && logger2.get() == logger3.get();

        Assertions.assertEquals(expected,actual);
    }
    @Test
    void test3(){
        Logger logger = Logger.getINSTANCE();

        boolean expected = true;
        boolean actual = logger.log_message(LogLevel.ERROR,"log level ERROR").contains(LogLevel.ERROR.name());

        Assertions.assertEquals(expected,actual);
    }
    @Test
    void test4(){
        Logger logger = Logger.getINSTANCE();

        boolean expected = true;
        boolean actual = logger.log_message(LogLevel.VERBOSE,"log level VERBOSE").contains(LogLevel.VERBOSE.name());

        Assertions.assertEquals(expected,actual);
    }
    @Test
    void test5(){
        Logger logger = Logger.getINSTANCE();
        boolean expected = true;
        boolean actual = logger.log_message(LogLevel.INFO,"log level INFO").contains(LogLevel.INFO.name());

        Assertions.assertEquals(expected,actual);
    }
    @Test
    void test6(){
        Logger logger = Logger.getINSTANCE();
        boolean expected = true;
        boolean actual = logger.log_message(LogLevel.WARNING,"log level WARNING").contains(LogLevel.WARNING.name());

        Assertions.assertEquals(expected,actual);
    }
    @Test
    void test7(){
        Logger logger = Logger.getINSTANCE();
        boolean expected = true;
        boolean actual = logger.log_message.contains(LogLevel.DEBUG.name());
        //(LogLevel.DEBUG,"log level DEBUG");
        Assertions.assertEquals(expected,actual);

    }
}
