package com.nooices.logback.demo;

import ch.qos.logback.classic.Level;
import com.nooices.apachecommonscli.util.CmdUtil;
import com.nooices.logback.util.OptionsUtil;
import com.nooices.logback.util.PrintLogUtil;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogLevelDemo {

    public static void main(String[] args) {
        main0(args);
    }

    public static void main0(String[] args) {
        Options options = OptionsUtil.buildLogOptions(new Options());
        CommandLine cmd = CmdUtil.parseCmdLine("LogLevelDemo", args, options, new DefaultParser());
        if(cmd == null){
            return;
        }
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.nooices");
        logger.setLevel(parseLogLevel(cmd));
        PrintLogUtil.printAllLogLevelLog(logger, "parent");

        Logger childLogger = LoggerFactory.getLogger("com.nooices.child");
        PrintLogUtil.printAllLogLevelLog(childLogger, "child");
    }

    private static Level parseLogLevel(CommandLine cmd){
        switch (cmd.getOptionValue('l').toLowerCase()){
            case "info":
                return Level.INFO;
            case "debug":
                return Level.DEBUG;
            case "warn":
                return Level.WARN;
            case "error":
                return Level.ERROR;
            default:
                return Level.TRACE;
        }
    }
}
