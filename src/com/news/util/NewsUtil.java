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
    ��������ʽ�ǣ�
    ������Դ������Դ���������⡱
    ʱ�䣺
    URL��
    ժҪ��
    ��
    ������Դ���»��������´��߻��㡿��˿·�������նӡ�������ʦ
    ʱ�䣺2019-01-23
    URL��http://www.ha.xinhuanet.com/news/2019-01/23/c_1124029481.htm
    ժҪ���»���֣��1��23�յ� ������  ��ΰ ��������2018�꣬��ŷ������
    */
    public static String getStatusOne(NewsBean newsBean){
        String out = newsBean.come +"��"+newsBean.title+"\n"+"URL��"+newsBean.url+"\n"+"ժҪ��"+newsBean.comment;
        return out;
    }
    public static String getStatusTwo(NewsBean newsBean){
        String out =  newsBean.title +"\n"+"ʱ�䣺"+ getTime(newsBean.time)+"\n"+"��Դ��"+newsBean.come+"\n"+"���ݸ�Ҫ��"+newsBean.comment+"\n"+"���ӵ�ַ��"+newsBean.url+"\n";
        return out;
    }
    public static String getStatusThree(NewsBean newsBean){
        String out = "������Դ��"+newsBean.come +"��"+newsBean.title+""+"\n"+"����ʱ�䣺"+getTime2(newsBean.time) +"\n"+"URL��"+newsBean.url+"\n"+"ժҪ��"+newsBean.comment+"\n";
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
                    return one+"��"+ two+"��" ;
                }else if(times.length==2){
                    return times[0]+"��"+times[1]+"��" ;
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
