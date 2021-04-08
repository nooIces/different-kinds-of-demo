package com.nooices.apachecommonscli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ApacheCommonsCliDemo {

    public static void main(String[] args) {
        main0(args);
    }

    public static String main0(String[] args) {
        // 构建Options
        Options options = buildCommandLineOptions(new Options());
        // 解析出CommandLine
        CommandLine commandLine = parseCmdLine("java ApacheCommonsCliDemo", args, options, new DefaultParser());
        if(commandLine == null){
            return null;
        }
        // 根据参数执行代码
        if(commandLine.hasOption('h')){
            return "help";
        }
        if(commandLine.hasOption('p')){
            System.out.println("Input value: " + commandLine.getOptionValue('p'));
            return commandLine.getOptionValue('p');
        }
        return null;
    }

    private static CommandLine parseCmdLine(String appName, String[] args, Options options, DefaultParser parser) {
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

    private static Options buildCommandLineOptions(Options options) {
        // args: 1 简写形式 2 复杂形式 3 是否需要额外参数 4 描述
        Option opt = new Option("h", "help", false, "Print Help");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("p", "print", true, "Print Args");
        opt.setRequired(true);
        options.addOption(opt);

        return options;
    }

}
