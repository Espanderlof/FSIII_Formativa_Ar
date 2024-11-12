package com.duoc.back_libros.patterns;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LibroLogger {
    private static LibroLogger instance;
    private static final Object lock = new Object();
    private final DateTimeFormatter formatter;

    private LibroLogger() {
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public static LibroLogger getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new LibroLogger();
                }
            }
        }
        return instance;
    }

    public void logOperation(String operation, String details) {
        String timestamp = LocalDateTime.now().format(formatter);
        System.out.println(String.format("[%s] %s: %s", timestamp, operation, details));
    }
}