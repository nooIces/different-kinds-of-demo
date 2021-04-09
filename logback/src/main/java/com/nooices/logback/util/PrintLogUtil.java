package com.nooices.logback.util;

import org.slf4j.Logger;

public class PrintLogUtil {

    public static void printAllLogLevelLog(Logger logger, String name) {
        logger.error("{}, Hello error", name);
        logger.warn("{}, Hello warn", name);
        logger.info("{}, Hello info", name);
        logger.debug("{}, Hello debug", name);
    }

}
