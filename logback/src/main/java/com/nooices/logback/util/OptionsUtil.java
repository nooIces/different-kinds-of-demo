package com.nooices.logback.util;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class OptionsUtil {

    public static Options buildLogOptions(Options options) {
        Option opt = new Option("l", "level", true, "set log level");
        opt.setRequired(true);
        options.addOption(opt);

        return options;
    }

    public static Options buildLogConfigFilePathOptions(Options options) {
        Option opt = new Option("p", "path", true, "logback config file path");
        opt.setRequired(true);
        options.addOption(opt);

        return options;
    }

}
