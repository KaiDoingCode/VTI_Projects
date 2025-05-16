package logger;

import logger.domain.Logger;

public class LoggerDemo {
    public static void run() {
        Runnable task = () -> {
            Logger logger = Logger.getInstance();
            logger.log("Message from thread: " + Thread.currentThread().getName());
        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");

        t1.start();
        t2.start();
    }
}
