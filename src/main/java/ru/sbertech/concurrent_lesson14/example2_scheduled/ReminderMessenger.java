package ru.sbertech.concurrent_lesson14.example2_scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ReminderMessenger {
    private static ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        Reminder reminder = new Reminder();
        service.scheduleAtFixedRate(reminder, 0, 2, TimeUnit.SECONDS);
        //service.shutdown();
    }
}
