package com.news.web;

import com.news.bean.NewsBean;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-23-17:21
 */
public class SpiderNews {

    public static String getWebViewer(String u) throws Exception{
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
        HttpGet httpPost = new HttpGet(u);
        httpPost.setHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
//        HttpPost httpPost = new HttpPost(u) ;
        CloseableHttpResponse response=closeableHttpClient.execute(httpPost);
        HttpEntity entity=response.getEntity();
        String ux = EntityUtils.toString(entity,"utf-8") ;
        return ux;
    }

    public static String getWebViewerGBK(String u) throws Exception{
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
        HttpGet httpPost = new HttpGet(u);
        httpPost.setHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");
//        HttpPost httpPost = new HttpPost(u) ;
        CloseableHttpResponse response=closeableHttpClient.execute(httpPost);
        HttpEntity entity=response.getEntity();
        String ux = EntityUtils.toString(entity,"gbk") ;
        return ux;
    }

    public static String getWebViewer2(String u,String id) throws Exception{
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
        HttpPost httpPost = new HttpPost(u);
        httpPost.setHeader("Accept","*/*");
        httpPost.setHeader("Connection","keep-alive");
        httpPost.setHeader("Host","newwap.zzrbnews.com");

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        nvps.add(new BasicNameValuePair("Method", "gov.message.detail"));
        nvps.add(new BasicNameValuePair("Params", "{\"id\":\""+id+"\"}"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response=closeableHttpClient.execute(httpPost);
        HttpEntity entity=response.getEntity();
        String ux = EntityUtils.toString(entity,"utf-8") ;
        System.out.println(ux);
        return ux;
    }


    public static NewsBean tempGBK(String url,String titMa,String timeMa,String timeEnd,String comethis,String commentT,String commentE){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewerGBK(url) ;
            System.out.println(urls);
            String con = titMa + "(.*?)<" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace(titMa,"").replace("<","");
                newsBean.title = title ;
            }
            con = timeMa + "(.*?)" +timeEnd;
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace(timeMa,"").replace(timeEnd,"").replace("/","-").split(" ")[0];
                if (time.contains("��")){
                    time = time.split("��")[0] + "-" + time.split("��")[1].split("��")[0] +"-"+ time.split("��")[1].split("��")[1].split("��")[0] ;
                }
                newsBean.time = time ;
            }
            newsBean.come = comethis ;
            con = commentT + "(.*?)" + commentE;
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace(commentT,"").replace(commentE,"").replace("����","").replace(" ","");
                newsBean.comment = comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }


    public static NewsBean tempGBK2(String url,String titMa,String titEnd,String timeMa,String timeEnd,String comethis,String commentT,String commentE){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewerGBK(url) ;
            System.out.println(urls);
            String con = titMa + "(.*?)" +titEnd;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace(titMa,"").replace(titEnd,"");
                newsBean.title = title ;
            }
            con = timeMa + "(.*?)" +timeEnd;
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                System.out.println(time);
                time = time.replace(timeMa,"").replace(timeEnd,"").replace("/","-").split(" ")[0];
                if (time.contains("��")){
                    time = time.split("��")[0] + "-" + time.split("��")[1].split("��")[0] +"-"+ time.split("��")[1].split("��")[1].split("��")[0] ;
                }
                newsBean.time = time ;
            }
            newsBean.come = comethis ;
            con = commentT + "(.*?)" + commentE;
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace(commentT,"").replace(commentE,"").replace("����","").replace(" ","");
                newsBean.comment = comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean temp(String url,String titMa,String timeMa,String comethis,String commentT,String commentE){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            System.out.println(urls);
            String con = titMa + "(.*?)<" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace(titMa,"").replace("<","");
                newsBean.title = title ;
            }
            con = timeMa + "(.*?)<";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace(timeMa,"").replace("<","").split(" ")[0];
                if (time.contains("��")){
                    time = time.split("��")[0] + "-" + time.split("��")[1].split("��")[0] +"-"+ time.split("��")[1].split("��")[1].split("��")[0] ;
                }
                newsBean.time = time ;
            }
            newsBean.come = comethis ;
            con = commentT + "(.*?)" + commentE;
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace(commentT,"").replace(commentE,"").replace("����","").replace(" ","");
                newsBean.comment = comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean temp2(String url,String titMa,String timeMa,String timeEnd,String comethis,String commentT,String commentE){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            System.out.println(urls);
            String con = titMa + "(.*?)<" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace(titMa,"").replace("<","");
                newsBean.title = title ;
            }
            con = timeMa + "(.*?)" + timeEnd;
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace(timeMa,"").replace(timeEnd,"").trim().split(" ")[0];
                if (time.contains("��")){
                    time = time.split("��")[0] + "-" + time.split("��")[1].split("��")[0] +"-"+ time.split("��")[1].split("��")[1].split("��")[0] ;
                }
                newsBean.time = time ;
            }
            newsBean.come = comethis ;
            con = commentT + "(.*?)" + commentE;
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace(commentT,"").replace(commentE,"").replace("����","").replace(" ","");
                newsBean.comment = comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean temp3(String url,String titMa,String titEnd,String timeMa,String timeEnd,String comethis,String commentT,String commentE){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            System.out.println(urls);
            String con = titMa + "(.*?)"+titEnd ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace(titMa,"").replace(titEnd,"");
                newsBean.title = title ;
            }
            con = timeMa + "(.*?)" + timeEnd;
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace(timeMa,"").replace(timeEnd,"").trim().split(" ")[0];
                if (time.contains("��")){
                    time = time.split("��")[0] + "-" + time.split("��")[1].split("��")[0] +"-"+ time.split("��")[1].split("��")[1].split("��")[0] ;
                }
                newsBean.time = time ;
            }
            newsBean.come = comethis ;
            con = commentT + "(.*?)" + commentE;
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace(commentT,"").replace(commentE,"").replace("����","").replace(" ","");
                newsBean.comment = comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean getWWWtakungpao(String url){
        NewsBean newsBean = null ;
        try {
            newsBean = temp(url,"<h2 class=\"tkp_con_title\">","<div class=\"tkp_con_author\"><span>","����","<p>","<") ;
            System.out.println(newsBean.toString());
        }catch (Exception e){
        }
        return newsBean;
    }

    public static NewsBean getNewstakungpao(String url){
        NewsBean newsBean = null ;
        try {
            newsBean = temp(url,"<h1 class=\"tpk_con_tle\">","<div class=\"fl_dib\">","����","<p><span style=\"font-size: 12px;\">","<") ;
            System.out.println(newsBean.toString());
        }catch (Exception e){
        }
        return newsBean;
    }

    public static NewsBean getNewpaper(String url){
        NewsBean newsBean = null ;
        try {
            newsBean = new NewsBean();
            String urls  = getWebViewer(url) ;
            System.out.println(urls);
            String con = "<title>(.*?)</title>" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("<title>","").replace("</title>","");
                newsBean.title = title ;
            }
            con = "(.*)��(.*)��";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace(" ","");
                newsBean.time = time ;
            }
            con = "<p>&nbsp;&nbsp;&nbsp;&nbsp;(.*?)</p>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            String comment = "";
            boolean flag = true ;
            while(flag&&mr.find()) {
                comment = comment + "\n"+ mr.group() ;
                comment = comment.replace("<p>&nbsp;&nbsp;&nbsp;&nbsp;","").replace("</p>","");
                if (comment.length()>=100){
                    flag = false;
                }
            }
            newsBean.comment = comment+"..." ;
        }catch (Exception e){

        }
        System.out.println(newsBean.toString());
        return newsBean;
    }

    public static NewsBean getZYnews(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            String con = "<td class=\"font01\"(.*?)</td>" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("<td class=\"font01\" align=\"center\" style=\"color: #0205FF;\">","").replace("</td>","");
                con = ">(.*)";
                ah = Pattern.compile(con);
                mr = ah.matcher(title) ;
                if(mr.find()) {
                    title = mr.group() ;
                    title = title.replace(">","").replace("<","").replace("<STRONG>","").replace("</STRONG>","");
                    newsBean.title = title ;
                }
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
            newsBean.time = df.format(new Date());
            con = "<td width=168 align=left class=px12>(.*?)<";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String come = mr.group() ;
                come = come.replace("<td width=168 align=left class=px12>","").replace("<","").replace("<STRONG>","").replace("</STRONG>","");
                newsBean.come = "֣���ձ�" + come.replace("��","").replace(":","") ;
            }
            con = "<founder-content><P>(.*?)</P>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("<founder-content><P>","").replace("</P>","").replace("<P>","") ;
                newsBean.comment = comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean getToutiao(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            System.out.println(urls);
            String con = "title: (.*?)," ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("title: ","").replace(",","").replace("'","");
                newsBean.title = title ;
            }
            con = "time: '(.*)'";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace("time:","").replace("'","");
                newsBean.time = time ;
            }
            con = "source: '(.*)'";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String come = mr.group() ;
                come = come.replace("source:","").replace("'","").replace(" ","");
                newsBean.come = "ͷ���š�"+come+"��" ;
            }
            con = "abstract: '(.*?)'";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("abstract:","").replace("'","");
                newsBean.comment = comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean getMengMa(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            String con = "<title>(.*?)</title>" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("<title>","").replace("</title>","");
                newsBean.title = title ;
            }
            con = "<div style=\"margin-left: 10px;margin-top:2px;font-size: 12px;color: gray;\">(.*)</div>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace("<div style=\"margin-left: 10px;margin-top:2px;font-size: 12px;color: gray;\">","").replace("</div>","");
                newsBean.time = time ;
            }
            newsBean.come = "����ͻ���" ;
            con = "(.*)<o:p></o:p>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("<o:p></o:p>","");
                newsBean.comment = comment ;
            }
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("<o:p></o:p>","");
                newsBean.comment = newsBean.comment + "��" + comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean getDahebao(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            String con = "<h1>(.*?)</h1>" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("<h1>","").replace("</h1>","");
                newsBean.title = title ;
            }
            con = "<span class=\"time\">(.*)</span>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace("<span class=\"time\">","").replace("</span>","");
                newsBean.time = time ;
            }
            newsBean.come = "��ӿͻ���" ;
            con = "<p>(.*?)</p>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("<p>","").replace("</p>","");
                newsBean.comment = comment ;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean getZhongY(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            String con = "<h1 class=\"article-title ffyh\">(.*?)</h1>" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("<h1 class=\"article-title ffyh\">","").replace("</h1>","");
                newsBean.title = title ;
            }
            con = "<i id=\"pubtime_baidu\">(.*?)</i>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace("<i id=\"pubtime_baidu\">","").replace("</i>","");
                newsBean.time = time ;
            }
            newsBean.come = "��ԭ��" ;
            con = "<p>(.*?)</p>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("<p>","").replace("</p>","").replace("<strong>","").replace("</strong>",":").replace("��ԭ��Ѷ","").replace(":","");
                newsBean.comment = comment ;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    // wap.zzwb
    public static NewsBean getZzwb(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            System.out.println(urls);
            String con = "<div class=\"news-title\" style=\"color:#40404\">(.*?)</div>" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("<div class=\"news-title\" style=\"color:#40404\">","").replace("</div>","");
                newsBean.title = title ;
            }
            con = "news-time\">(.*?)�����";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace("news-time\">","").replace("�����","");
                newsBean.time = time ;
            }
            con = "��Դ(.*?)<";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String come = mr.group() ;
                come = come.replace("<","").replace("��Դ","").replace("��","").replace(":","");
                newsBean.come = come ;
            }
            con = "desc: (.*?),";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("desc: \"","").replace("\",","");
                newsBean.comment = comment ;
            }
            con = "<strong>(.*?)</strong>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("<strong>","").replace("</strong>","");
                newsBean.comment =  newsBean.comment.replace(comment,"") ;
            }
            newsBean.come = "֣�����ͻ���" ;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    // www.zzwb
    public static NewsBean getWWWZzwb(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            System.out.println(urls);
            String con = "<h1>(.*?)</h1>" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("<h1>","").replace("</h1>","");
                newsBean.title = title ;
            }
            con = "news-time\">(.*?)</span>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace("news-time\">","").replace("</span>","");
                newsBean.time = time ;
            }
            con = "��Դ(.*?)<";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String come = mr.group() ;
                come = come.replace("<","").replace("��Դ","").replace("��","").replace(":","");
                newsBean.come = come ;
            }
            con = "<p style=\"text-align: center\">(.*)</p>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                con = "<p>(.*?)<" ;
                ah = Pattern.compile(con);
                mr = ah.matcher(comment) ;
                if (mr.find()){
                    newsBean.comment = mr.group().replace("<p>","").replace("<","") ;
                }
            }
            newsBean.come = "֣�����ͻ���" ;
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(newsBean.toString());

        return newsBean;
    }

    public static NewsBean getNewsDahebao(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            System.out.println(urls);
            String con = "h1 class=\"article-title\">(.*?)</h1>" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("h1 class=\"article-title\">","").replace("</h1>","");
                newsBean.title = title ;
            }
            con = "<span class=\"time\">(.*)</span>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace("<span class=\"time\">","").replace("</span>","");
                newsBean.time = time ;
            }
            newsBean.come = "��ӿͻ���" ;
            con = "<p>(.*?)</p>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("<p>","").replace("</p>","");
                newsBean.comment = comment ;
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean getZYnewsZzwb(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            String con = "<td class=\"font01\"(.*?)</td>" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("<td class=\"font01\" align=\"center\" style=\"color: #0205FF;\">","").replace("</td>","");
                con = ">(.*)";
                ah = Pattern.compile(con);
                mr = ah.matcher(title) ;
                if(mr.find()) {
                    title = mr.group() ;
                    title = title.replace(">","").replace("<","").replace("<STRONG>","").replace("</STRONG>","");
                    newsBean.title = title ;
                }
            }
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
            newsBean.time = df.format(new Date());
            con = "<td width=168 align=left class=px12>(.*?)<";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String come = mr.group() ;
                come = come.replace("<td width=168 align=left class=px12>","").replace("<","").replace("<STRONG>","").replace("</STRONG>","");
                newsBean.come = "֣����" + come.replace("��","").replace(":","") ;
            }
            con = "<founder-content><P>(.*?)</P>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("<founder-content><P>","").replace("</P>","").replace("<P>","") ;
                newsBean.comment = comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean getNewsZZRB(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            System.out.println(urls);
            String con = "title: \"(.*?)\"," ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("title: \"","").replace("\",","");
                newsBean.title = title ;
            }
            con = "div class=\"news-time\">(.*)�����";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace("div class=\"news-time\">","").replace("�����","").replace(" ","");
                newsBean.time = time ;
            }
            newsBean.come = "֣���ձ��ͻ���" ;
            con = "desc: \"(.*?)\",";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("desc: \"","").replace("\",","");
                newsBean.comment = comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean getZZRBNews(String url){
        NewsBean newsBean = null ;
        try {
//            http://newwap.zzrbnews.com/gov/message.html?id=5725
            String myurl = url.split("id=")[1];
            String urls  = getWebViewer2("http://newwap.zzrbnews.com/ajax/?t=0.17138764453738542",myurl) ;
            System.out.println(urls);
            String con = "\"title\":\"(.*?)\"," ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("\"title\":\"","").replace("\",","");
                newsBean.title = title ;
            }
            con = "createtime\":\"(.*)\",";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace("createtime\":\"","").replace("\",","");
                time  = time.substring(0,10);
                newsBean.time = time ;
            }
            newsBean.come = "֣���ձ��ͻ���" ;
            con = "<p(.*?)</p>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            while(mr.find()) {
                String comment = mr.group() ;
                if (comment.contains("<strong>")){

                }else {
                    comment = comment.replace("<p style=\\\"line-height: 1.75em;\\\">","").replace("</p>","");
                    newsBean.comment = comment ;
                    break;
                }
            }
            System.out.println(newsBean.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean getYingxiang(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            System.out.println(urls);
            String con = "<h2 class=\"f32 lh48 mrg_t_30\">(.*?)</h2>" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("<h2 class=\"f32 lh48 mrg_t_30\">","").replace("</h2>","");
                newsBean.title = title ;
            }
            con = "<p class=\"left\"><span>(.*?)</span>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace("<p class=\"left\"><span>","").replace("</span>","");
                newsBean.time = time ;
            }
            newsBean.come = "ӳ����" ;
            con = "</strong>(.*?)</p>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("</strong>","").replace("</p>","");
                newsBean.comment = comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

    public static NewsBean getNewsYingxiang(String url){
        NewsBean newsBean = null ;
        try {
            String urls  = getWebViewer(url) ;
            System.out.println(urls);
            String con = "<h2 class=\"f32 lh48 mrg_t_30\">(.*?)</h2>" ;
            Pattern ah = Pattern.compile(con);
            newsBean = new NewsBean() ;
            newsBean.url = url ;
            Matcher mr = ah.matcher(urls) ;
            if(mr.find()) {
                String title = mr.group() ;
                title = title.replace("<h2 class=\"f32 lh48 mrg_t_30\">","").replace("</h2>","");
                newsBean.title = title ;
            }
            con = "<p class=\"left\"><span>(.*?)</span>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String time = mr.group() ;
                time = time.replace("<p class=\"left\"><span>","").replace("</span>","");
                String s = time.split("��")[0] + "-" + time.split("��")[1].split("��")[0] +"-"+ time.split("��")[1].split("��")[1].split("��")[0] ;
                newsBean.time = s ;
            }
            newsBean.come = "ӳ����" ;
            con = "<p>(.*?)</p>";
            ah = Pattern.compile(con);
            mr = ah.matcher(urls) ;
            if(mr.find()) {
                String comment = mr.group() ;
                comment = comment.replace("<p>","").replace("</p>","");
                newsBean.comment = comment ;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return newsBean;
    }

}
