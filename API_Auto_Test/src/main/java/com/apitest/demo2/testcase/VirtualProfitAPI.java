package com.apitest.demo2.testcase;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteClassListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.apitest.demo2.biz.VirtualProfit.*;

@Listeners(ExtentIReporterSuiteClassListenerAdapter.class)
public class VirtualProfitAPI {


    @Test(description = "单产品虚拟计提处理成功", priority=0)
    public void virtualProfit_Test0001(){
        virtualProfitDeal("F6", 20220318, "ZH0001");
    }


    @Test(description = "多产品虚拟计提处理成功", priority=0)
    public void virtualProfit_Test0002(){
        virtualProfitDeal("F6", 20220318, "ZH0001,ZH0002");
    }


    @Test(description = "单产品虚拟计提处理失败，缺净值方案", priority=0)
    public void virtualProfit_Test0003(){
        virtualProfitDeal("F6", 20220318, "ZH0003");
    }


    @Test(description = "基金在系统中不存在", priority=1)
    public void virtualProfit_Test0004(){
        String fundcodes = "123456";
        virtualProfitDeal("F6", 20220318, fundcodes);
    }


    @Test(description = "同时存在计提成功和失败", priority=1)
    public void virtualProfit_Test0005(){
        String fundcodes = "AEF001,123456";
        virtualProfitDeal("F6", 20220318, fundcodes);
    }
}
