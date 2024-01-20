package com.wso2.support.db.migration.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger{
        public static void error(String str)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime localDateTime = LocalDateTime.now();
            String formattedDateTime = localDateTime.format(formatter);
            System.out.println("[" + formattedDateTime + "] - " + " ERROR  - " + str);
        }

        public static void info(String str)
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            LocalDateTime localDateTime = LocalDateTime.now();
            String formattedDateTime = localDateTime.format(formatter);
            System.out.println("[" + formattedDateTime + "] - " + " INFO - " + str);
        }
}
