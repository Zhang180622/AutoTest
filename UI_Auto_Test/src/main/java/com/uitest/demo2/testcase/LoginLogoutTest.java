package com.uitest.demo2.testcase;
/*
    测试用例
    具体测试逻辑，应用业务方法，降低耦合
 */

import com.uitest.demo2.common.AbstractBasic;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.uitest.demo2.biz.LoginLogout.login;
import static com.uitest.demo2.biz.LoginLogout.logout;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteClassListenerAdapter;

@Listeners(ExtentIReporterSuiteClassListenerAdapter.class)
public class LoginLogoutTest extends AbstractBasic {

    static {
        System.setProperty("extent.reporter.html.start","true");
        System.setProperty("extent.reporter.html.out","test-output/ExtentReporterHTML.html");
    }

    @BeforeClass
    public void setup() throws InterruptedException {
        login("30180","1");
    }

    @Test
    public void testCase_001(){
        System.out.println("testCase_001");
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        logout();
    }

}
