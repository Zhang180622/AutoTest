package com.uitest.demo2.common;
/*
    模块化：将测试用例中的公共部分抽离出来，供其它测试用例调用，被模块化的部分可以单独维护，降低维护工作量
    第一层：公共函数层
    公共方法的封装，与具体业务无关，适用于所有项目
 */
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;


public abstract class AbstractBasic {

    public static ChromeDriver driver;
    public static final String chromeDriver = "webdriver.chrome.driver";
    public static final String webDriver = "C:\\Driver\\chromedriver.exe";
    public static final String URL_B = "http:10.20.18.166";

    //在子类的BeforeClass之前运行
    @BeforeClass
    public ChromeDriver createChromeDriver(){
        System.setProperty(chromeDriver,webDriver);
        return driver = new ChromeDriver();
    }

    //在子类的AfterClass之后运行
    @AfterClass
    public void teardownAll(){
        driver.quit();
    }


}
