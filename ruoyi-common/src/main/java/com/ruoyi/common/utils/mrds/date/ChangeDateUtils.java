package com.ruoyi.common.utils.mrds.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChangeDateUtils {
    public static final String GSTIME="yyyy-MM-dd HH:mm:ss";

    //时间戳转换成日期格式：
    public static String getUnixTransferTime(long nowtime){
        Date date=new Date(nowtime*1000);
        SimpleDateFormat format=new SimpleDateFormat(GSTIME);
        return format.format(date);
    }

    //获取当前时间时间戳
    public static Long getCurrentUnixTime(){
        long time=System.currentTimeMillis();
        return time/1000;
    }
}
