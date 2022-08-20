package com.apitest.demo2.testcase;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteClassListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.apitest.demo2.biz.VirtualProfit.*;

@Listeners(ExtentIReporterSuiteClassListenerAdapter.class)
public class VirtualProfitAPI {

    @Test(description = "虚拟计提处理服务成功", priority=0)
    public void virtualProfitTestSuccess(){
        virtualProfitDeal("F6", 153941, "AEF001");
    }

    @Test(description = "如下基金在系统中不存在", priority=1)
    public void virtualProfitTestFail(){
        String fundcodes = "AEF001,123456";
        virtualProfitDeal("F6", 153941, fundcodes);
    }
}
