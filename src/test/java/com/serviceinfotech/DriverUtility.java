package com.serviceinfotech;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DriverUtility {

    public static String captureScreen(WebDriver driver) {
            String path = null;
        //get your driver instance
        try {
            File source = ((TakesScreenshot)
                    driver).getScreenshotAs(OutputType.FILE);
            Calendar currentDate = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat(
                    "yyyy/MMM/dd HH:mm:ss");
            String dateN = formatter.format(currentDate.getTime()).replace("/","_");
            String dateNow = dateN.replace(":","_");
            String snapShotDirectory =  "c:\\temp\\"+ dateNow;
            File f = new File(snapShotDirectory);
            if(f.mkdir()){
                path = f.getAbsolutePath() + "/" + source.getName();
                FileUtils.copyFile(source, new File(path));
            }
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }
}
