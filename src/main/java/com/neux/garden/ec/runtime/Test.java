package com.neux.garden.ec.runtime;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;

public class Test {
    public static void main(String[] args) {
        AllInOne all = new AllInOne("");

        AioCheckOutALL obj = new AioCheckOutALL();
        obj.setMerchantTradeNo("NEUXTEST0000005");
        obj.setMerchantTradeDate("2017/01/01 08:05:23");
        obj.setTotalAmount("100");
        obj.setTradeDesc("test Description");
        obj.setItemName("TestItem");
//        obj.setReturnURL("http://211.23.128.214:5000");
        obj.setNeedExtraPaidInfo("N");
        obj.setOrderResultURL("https://www.google.com.tw");
        obj.setClientBackURL("http://tw.yahoo.com");
        String form = all.aioCheckOut(obj, null);

        System.out.println("===");
        System.out.println(form);
        System.out.println("===");
    }
}
