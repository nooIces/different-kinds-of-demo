package com.nooices.apachecommonscli.demo;

import com.nooices.apachecommonscli.util.CmdUtil;
import com.nooices.apachecommonscli.util.OptionsUtil;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

public class ApacheCommonsCliDemo {

    public static void main(String[] args) {
        main0(args);
    }

    public static String main0(String[] args) {
        // 构建Options
        Options options = OptionsUtil.buildCmdLineDemoOptions(new Options());
        // 解析出CommandLine
        CommandLine commandLine = CmdUtil.parseCmdLine("java ApacheCommonsCliDemo", args, options, new DefaultParser());
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

}
