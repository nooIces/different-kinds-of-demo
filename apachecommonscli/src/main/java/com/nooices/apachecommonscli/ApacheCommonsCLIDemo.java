package com.nooices.apachecommonscli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class ApacheCommonsCLIDemo {

    public static void main(String[] args) {
        // 构建Options
        Options options = buildCommandLineOptions(new Options());
        // 解析出CommandLine
        CommandLine commandLine = parseCmdLine("commonLine demo", args, options, new DefaultParser());
        // 根据参数执行代码
        if(commandLine.hasOption('p')){
            System.out.println("Input value: " + commandLine.getOptionValue('p'));
        }
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
                System.exit(0);
            }
        } catch (ParseException e) {
            hf.printHelp(appName, options, true);
            System.exit(1);
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
