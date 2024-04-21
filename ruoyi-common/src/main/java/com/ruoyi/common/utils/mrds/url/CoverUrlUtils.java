package com.ruoyi.common.utils.mrds.url;

import com.ruoyi.common.utils.StringUtils;

public class CoverUrlUtils {
    public static final String OSS_DOMAIN = "https://dailycontest.oss-cn-shanghai.aliyuncs.com/";

    public static String getCoverUrl(String url){
        if(StringUtils.isEmpty(url) || (url.length()>OSS_DOMAIN.length() && OSS_DOMAIN.equals(url.substring(0,OSS_DOMAIN.length())))){
            return url;
        }
        return (OSS_DOMAIN+url).trim();
    }
}
