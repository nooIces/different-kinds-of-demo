package com.nooices.apachecommonscli.util;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * option args: 1 简写形式 2 复杂形式 3 是否需要额外参数 4 描述
 */
public class OptionsUtil {

    public static Options buildCmdLineDemoOptions(Options options) {
        Option opt = new Option("h", "help", false, "Print Help");
        opt.setRequired(false);
        options.addOption(opt);

        opt = new Option("p", "print", true, "Print Args");
        opt.setRequired(true);
        options.addOption(opt);

        return options;
    }

}
