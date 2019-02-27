package com.news.util;

import com.news.bean.NewsBean;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-23-17:19
 */
public class NewsUtil {
    /*
    高新区格式是：
    舆情来源：“来源”：“标题”
    时间：
    URL：
    摘要：
    如
    舆情来源：新华网：【新春走基层】新丝路“钢铁驼队”的养护师
    时间：2019-01-23
    URL：http://www.ha.xinhuanet.com/news/2019-01/23/c_1124029481.htm
    摘要：新华网郑州1月23日电 （游黎  李伟 王振鹏）2018年，中欧。。。
    */
    public static String getStatusOne(NewsBean newsBean){
        String out = newsBean.come +"："+newsBean.title+"\n"+"URL："+newsBean.url+"\n"+"摘要："+newsBean.comment;
        return out;
    }
    public static String getStatusTwo(NewsBean newsBean){
        String out =  newsBean.title +"\n"+"时间："+ getTime(newsBean.time)+"\n"+"来源："+newsBean.come+"\n"+"内容概要："+newsBean.comment+"\n"+"链接地址："+newsBean.url+"\n";
        return out;
    }
    public static String getStatusThree(NewsBean newsBean){
        String out = "舆情来源："+newsBean.come +"："+newsBean.title+""+"\n"+"发布时间："+getTime2(newsBean.time) +"\n"+"URL："+newsBean.url+"\n"+"摘要："+newsBean.comment+"\n";
        return out;
    }
    public static String getTime(String time){
        String []arr =  time.split(" ") ;
        for(int i=0;i<arr.length;i++){
            if(arr[i].contains("-")){
                String []times = arr[i].split("-");
                if(times.length==3){
                    Integer one = Integer.parseInt(times[1]);
                    Integer two = Integer.parseInt(times[2]);
                    return one+"月"+ two+"日" ;
                }else if(times.length==2){
                    return times[0]+"月"+times[1]+"日" ;
                }
            }
        }
        return time ;
    }
    public static String getTime2(String time){
        String []arr =  time.split(" ") ;
        for(int i=0;i<arr.length;i++){
            if(arr[i].contains("-")){
                String []times = arr[i].split("-");
                if(times.length==3){
                    return times[0]+"-"+times[1]+"-"+ times[2] ;
                }else if(times.length==2){
                    return times[0]+"-"+times[1] ;
                }
            }
        }
        return time ;
    }
}
