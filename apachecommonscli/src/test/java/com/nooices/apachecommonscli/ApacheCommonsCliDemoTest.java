package com.nooices.apachecommonscli;

import com.nooices.apachecommonscli.demo.ApacheCommonsCliDemo;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ApacheCommonsCliDemoTest {

    @Test
    public void commandLineHelpTest() {
        String text = ApacheCommonsCliDemo.main0(new String[]{"-h", "-p", "test"});
        Assert.hasLength(text, "test help success");
    }

    @Test
    public void commandLinePrintTest() {
        String inputArg = "-p";
        String inputValue = "Hello World";
        String returnValue = ApacheCommonsCliDemo.main0(new String[]{inputArg, inputValue});
        Assert.isTrue(inputValue.equals(returnValue), "test print success");
    }

    @Test
    public void commandLineLackOfPrintTest() {
        String text = ApacheCommonsCliDemo.main0(new String[0]);
        Assert.isNull(text, "test lack of p success");
    }

}
