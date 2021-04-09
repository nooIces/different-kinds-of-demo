package com.nooices.logback.demo;

import com.nooices.logback.util.PrintLogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleDemo {

    private static final Logger logger = LoggerFactory.getLogger(SimpleDemo.class);

    public static void main(String[] args) {
        main0(args);
    }

    public static void main0(String[] args) {
        PrintLogUtil.printAllLogLevelLog(logger, "SimpleDemo");
    }

}
