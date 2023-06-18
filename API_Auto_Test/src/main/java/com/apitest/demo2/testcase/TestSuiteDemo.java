package com.apitest.demo2.testcase;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteClassListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * @Author: zhangsp
 * @comment: by nhs and ohs,delete ohs comment
 */
import static org.testng.Assert.fail;

@Listeners(ExtentIReporterSuiteClassListenerAdapter.class)
public class TestSuiteDemo {
//    test push
//    @BeforeSuite
//    public void beforeSuite(){
//        System.out.println("beforeSuite");
//    }
//
//    @BeforeClass
//    public void beforeClass(){
//        System.out.println("beforeClass");
//    }
//
////    @BeforeGroups
////    public void beforeGroups(){
////        System.out.println("beforeGroups");
////    }
//
//    @BeforeTest
//    public void beforeTest(){
//        System.out.println("beforeTest");
//    }
//
//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("beforeMethod");
//    }

    @Test
    public void Test_001(){
        System.out.println("Test_001");
    }

    @Test
    public void Test_002(){
        System.out.println("Test_002");
    }

    @Test
    public void Test_003(){
        System.out.println("Test_003");
    }

    @Test
    public void Test_004(){
        System.out.println("Test_004");
        fail();
    }

    @Test
    public void Test_005(){
        System.out.println("Test_005");
        //fail();
    }

    @Test(dependsOnMethods ="Test_005")
    public void Test_006(){
        System.out.println("Test_006");
    }

//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("afterMethod");
//    }
//
//    @AfterTest
//    public void afterTest(){
//        System.out.println("afterTest");
//    }
//
////    @AfterGroups
////    public void afterGroups(){
////        System.out.println("afterGroups");
////    }
//
//    @AfterClass
//    public void afterClass(){
//        System.out.println("afterClass");
//    }
//
//    @AfterSuite
//    public void afterSuite(){
//        System.out.println("afterSuite");
//    }
}
