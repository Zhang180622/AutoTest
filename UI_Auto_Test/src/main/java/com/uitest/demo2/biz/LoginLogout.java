package com.uitest.demo2.biz;
/*
    第二层：业务函数层
    业务方法封装，与业务相关，仅适用于当前项目
 */
import com.uitest.demo2.common.AbstractBasic;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;

public class LoginLogout extends AbstractBasic {

    public static void login(String username, String password) throws InterruptedException {
        driver.get(URL_B + "/tabase/login");
        driver.findElementById("usernameInput").sendKeys(username);
        driver.findElementById("passwordInput").sendKeys(password);
        driver.findElementByClassName("login-btn").click();
        TimeUnit.SECONDS.sleep(3);
        assertEquals(driver.findElementByClassName("tab-item-text").getText(),"首页");
    }

    public static void logout() throws InterruptedException {
        driver.findElementByXPath("//*[@id=\"app\"]/div[1]/div/div[2]/div/div/ul/li[4]/i[2]").click();
        driver.findElementByXPath("//*[@id=\"app\"]/div[1]/div/div[2]/div/div/ul/li[4]/div/ul/li[7]/a").click();
        TimeUnit.SECONDS.sleep(3);
    }

}
