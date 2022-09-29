package com.apitest.demo2.biz;


import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSONObject;
import com.apitest.demo2.common.ApiBasic;


public class VirtualProfit extends ApiBasic {

    private static final Logger logger = LoggerFactory.getLogger(VirtualProfit.class);

    /**
     *
     * @param tacode    TA代码
     * @param systime   净值日期
     * @param fundcodes 虚拟计提产品代码，支持多个产品
     */
    public static void virtualProfitDeal(String tacode, int systime, String fundcodes) {
        String URI = "/ta5-service/taut/com.hundsun.ta.ta5.biz.online.specialdeal.api.VirtualProfitService/virtualProfitDeal";
        String url = URL_B + URI;
        logger.info("URL = " + url);

        Map<String, Object> head = new HashMap();
        Map<String, Object> body = new HashMap();
        ArrayList FundCodeList = new ArrayList();
        String[] prdcodeList = fundcodes.split(",");
        for(int i = 0 ; i < prdcodeList.length; i++){
            Map<String, Object> prdcodeMap = new HashMap<String, Object>(prdcodeList.length);
            prdcodeMap.put("prdcode",prdcodeList[i]);
            FundCodeList.add(prdcodeMap);
        }
        body.put("TACode",tacode);
        body.put("FunctionId","IF3001");
        body.put("SysTime",systime);
        body.put("FundCode",FundCodeList);
        paramsMap.put("head", head);
        paramsMap.put("body", body);

        JSONObject paramsMapJson = new JSONObject(paramsMap);
        logger.info("requestParams = " + paramsMapJson.toString());
        logger.info("-------------分隔符-------------");
        returnValue(url, paramsMapJson, "head");
    }

}
