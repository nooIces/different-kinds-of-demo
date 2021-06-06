package com.nooices.logback.util;

import org.apache.commons.cli.*;

public class CmdUtil {

    public static CommandLine parseCmdLine(String appName, String[] args, Options options, DefaultParser parser) {
        HelpFormatter hf = new HelpFormatter();
        hf.setWidth(110);
        CommandLine commandLine = null;
        try {
            commandLine = parser.parse(options, args);
            if (commandLine.hasOption('h')) {
                // 打印options帮助
                hf.printHelp(appName, options, true);
            }
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            hf.printHelp(appName, options, true);
        }
        return commandLine;
    }

}
