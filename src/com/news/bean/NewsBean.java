package com.news.bean;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-23-17:16
 */
public class NewsBean {
    public String url ;
    public String come ;
    public String title ;
    public String comment ;
    public String time ;

    @Override
    public String toString() {
        return "����: "+url+"\n"+"��Դ: "+come+"\n"+"����: "+title+"\n"+"ժҪ: "+comment+"\n"+"ʱ��: "+time+"\n";
    }
}
