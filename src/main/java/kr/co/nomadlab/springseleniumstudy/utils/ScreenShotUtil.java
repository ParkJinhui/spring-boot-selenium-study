package kr.co.nomadlab.springseleniumstudy.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Calendar;

@Lazy
@Component
public class ScreenShotUtil {

//    @Autowired
//    private WebDriver driver;
    @Autowired
    private ApplicationContext ctx;

//    @Value("${screenshot.path}\\img.png")
    @Value("${screenshot.path}")
    private Path path;

    public void takeScreenShot() throws IOException {
        File sourceFile = ((TakesScreenshot) ctx.getBean(WebDriver.class)).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve(getStringTimeMilli() + ".png").toFile());
    }

    private String getStringTimeMilli(){
        String month_str, day_str, hour_str, minute_str, second_str, milliSecond_str;

        Calendar c			= Calendar.getInstance();

        int year = c.get(Calendar.YEAR);
        int month = (c.get(Calendar.MONTH)+1);
        int day = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        int milliSecond 	= c.get(Calendar.MILLISECOND);

        if(month<10){month_str="0"+month;			}else{	month_str= String.valueOf(month);			}
        if(day<10){	day_str="0"+day;					}else{	day_str= String.valueOf(day);				}
        if(hour<10){		hour_str="0"+hour;				}else{	hour_str= String.valueOf(hour);				}
        if(minute<10){	minute_str="0"+minute;			}else{	minute_str= String.valueOf(minute);		}
        if(second<10){	second_str="0"+second;			}else{	second_str= String.valueOf(second);		}

        if(milliSecond < 10){
            milliSecond_str="00"+milliSecond;
        }else{
            if(milliSecond < 100) {
                milliSecond_str="0"+milliSecond;
            } else{
                milliSecond_str= String.valueOf(milliSecond);
            }
        }
        return year + month_str + day_str + hour_str + minute_str + second_str + milliSecond_str;
    }

}
