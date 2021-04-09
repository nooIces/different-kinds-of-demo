package com.nooices.logback.demo;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import com.nooices.apachecommonscli.util.CmdUtil;
import com.nooices.logback.util.OptionsUtil;
import com.nooices.logback.util.PrintLogUtil;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAppenderDemo {

    public static void main(String[] args) {
        try {
            main0(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main0(String[] args) throws JoranException {
        Options options = OptionsUtil.buildLogConfigFilePathOptions(new Options());
        CommandLine cmd = CmdUtil.parseCmdLine("LogAppenderDemo", args, options, new DefaultParser());
        if(cmd == null){
            return;
        }
        // 重新设置配置文件
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(lc);
        lc.reset();
        configurator.doConfigure(cmd.getOptionValue('p'));

        Logger parentLogger = LoggerFactory.getLogger("com.nooices");
        PrintLogUtil.printAllLogLevelLog(parentLogger, "parentLogger");
        Logger logbackLogger = LoggerFactory.getLogger("com.nooices.logback");
        PrintLogUtil.printAllLogLevelLog(logbackLogger, "logbackLogger");
        Logger otherLogger = LoggerFactory.getLogger("com.nooices.other");
        PrintLogUtil.printAllLogLevelLog(otherLogger, "otherLogger");
        Logger otherParentLogger = LoggerFactory.getLogger("com.other.logback");
        PrintLogUtil.printAllLogLevelLog(otherParentLogger, "otherParentLogger");

    }

}
