package com.news.util;

import com.news.bean.NewsBean;
import com.news.web.SpiderNews;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-24-11:59
 */
public class ChooseNet {
    public static NewsBean chooseNet(String url){
        NewsBean newsBean = new NewsBean() ;
        // ����ѡ��
        if (url.contains("wap.zzwb.cn")){
            // ֣�����ͻ��� zzwb.zynews.cn
            newsBean = SpiderNews.getZzwb(url) ;
        }else if(url.contains("newwap.zzrbnews.com/gov")){
            // ֣���ձ�
            newsBean = SpiderNews.getZZRBNews(url) ;
        }else if(url.contains("zzwb.zynews.cn")){
            //֣������x��
            newsBean = SpiderNews.getZYnewsZzwb(url) ;
        }else if (url.contains("www.zzwb.cn")){
            // ֣�����ͻ���
            newsBean = SpiderNews.getWWWZzwb(url) ;
        }else if(url.contains("newwap.zzrbnews.com")){
            //֣���ձ��ͻ���
            newsBean = SpiderNews.getNewsZZRB(url) ;
        }else if(url.contains("zzrb.zynews.cn")){
            // ֣���ձ���x��
            newsBean = SpiderNews.getZYnews(url) ;
        }else if(url.contains("www.toutiao.com")){
            // ͷ���š�xxxx��
            newsBean = SpiderNews.getToutiao(url);
        }else if(url.contains("mengma.jinbw.com.cn")){
            // ����ͻ���
            newsBean = SpiderNews.getMengMa(url);
        }else if(url.contains("www.dahebao.cn")){
            // ��ӿͻ���
            newsBean = SpiderNews.getDahebao(url);
        }else if(url.contains("news.dahebao.cn")){
            // ���news
            newsBean = SpiderNews.getNewsDahebao(url);
        }else if(url.contains("gov.hnr.cn")){
            //  ӳ����
            newsBean = SpiderNews.getYingxiang(url);
        }else if(url.contains("news.hnr.cn")){
            //  ӳ����
            newsBean = SpiderNews.getNewsYingxiang(url);
        }else if(url.contains("www.takungpao.com")){
            newsBean = SpiderNews.getWWWtakungpao(url);
        }else if(url.contains("news.takungpao.com")){
            newsBean = SpiderNews.getNewstakungpao(url);
        }else if(url.contains("news.dahe.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"4g_title\">","<p class=\"time fl\" id=\"pubtime_baidu\">","�����","<p>","<");
        }else if(url.contains("4g.dahe.cn")){
            newsBean = SpiderNews.temp(url,"<h1>","<p class=\"fl\">","�����","<p>","<");
        }else if(url.contains("city.dahe.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"4g_title\">","<p class=\"time fl\" id=\"pubtime_baidu\">","�����","<p>","<");
        }else if(url.contains("edu.dahe.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"4g_title\">","<p class=\"time fl\" id=\"pubtime_baidu\">","�����","<p>","<");
        }else if(url.contains("photo.dahe.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"4g_title\">","<span class=\"subtime\" id=\"pubtime_baidu\">","�����","<p>","<");
        }else if(url.contains("hn.ifeng.com")){
            newsBean = SpiderNews.temp(url,"<h1 itemprop=\"headline\" id=\"artical_topic\">","<span itemprop=\"datePublished\" class=\"ss01\">","�����","<p>","<");
        }else if(url.contains("hn.cri.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"atitle\" class=\"atitle\">","<span id=\"apublishtime\" class=\"apublishtime\">","��������","<p>&emsp;&emsp;","<");
        }else if(url.contains("hn.chinaso.com")){
            newsBean = SpiderNews.temp(url,"<h1 class=\"detail-title\">"," <span>","���Ѻ���","</strong>","<");
        }else if(url.contains("www.henanfazhi.net")){
            newsBean = SpiderNews.temp(url,"<h1>","<span class=\"date\">","���Ϸ�����","&nbsp;&nbsp;","<");
        }else if(url.contains("www.hnfzb.com")){
            newsBean = SpiderNews.temp(url,"<title>","ʱ�䣺","���Ϸ���������","</strong>","<");
            newsBean.title = newsBean.title.split("ƽ������")[0];
        }else if(url.contains("news.hnjkw.net")){
            newsBean = SpiderNews.temp(url,"<H1>","<span>","���Ͻ�����","</strong>","<");
        }else if(url.contains("www.henan.gov.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"title\">","<i id=\"pubDate\">","����ʡ��������","<p>","</p>");
        }else if(url.contains("www.shenji.henan.gov.cn")){
            newsBean = SpiderNews.tempGBK(url,"<FONT size=+0>","ʱ�䣺","&nbsp;&nbsp;���","����ʡ�����","<P style=\"LINE-HEIGHT: 2; TEXT-INDENT: 38px\"><FONT style=\"FONT-FAMILY: ����; FONT-SIZE: 18px\">","<");
        }else if(url.contains("www.henan100.com")){
            newsBean = SpiderNews.temp(url,"<h1><a href=\"","����ʱ�䣺","����һ�ٶ�","<meta name=\"Description\" content=\"","\"");
            newsBean.title = newsBean.title.split(">")[1] ;
        }else if(url.contains("www.jinbw.com.cn")){
            newsBean = SpiderNews.temp(url,"<h1>","<span>","����","<p>","<");
        }else if(url.contains("xinwen.mlzgw.cn")){
            newsBean = SpiderNews.temp(url,"<h1 itemprop=\"headline\" id=\"artical_topic\">","<span class=\"ss01\">","�����й���","<p>","</p");
        }else if(url.contains("hn.mzyfz.com")){
            newsBean = SpiderNews.tempGBK(url,"<title>","������"," ","�����뷨����","����Ѷ��</font>","</span");
            newsBean.title = newsBean.title.split("-")[0] ;
        }else if(url.contains("www.thepaper.cn")){
            newsBean = SpiderNews.temp2(url,"<h1 class=\"news_title\">","    ","<span>&nbsp;&nbsp;","��������","meta name=\"Description\" content=\"","\"");
        }else if(url.contains("jszx.court.gov.cn")){
            newsBean = SpiderNews.temp(url,"div class=\"title\">","����ʱ�䣺","ȫ����Ժ��ʤ���������ִ���ѡ���Ϣ��","<span style=\"text-indent: 2em;\">","<");
        }else if(url.contains("henan.people.com.cn")){
            newsBean = SpiderNews.tempGBK(url,"<h1>","<div class=\"fl\">","��Դ","������","<meta name=\"description\" content=\"","\"");
        }else if(url.contains("ha.people.com.cn")){
            newsBean = SpiderNews.tempGBK(url,"<h1>","<div class=\"fl\">","��Դ","������","\t","</p>");
        }else if(url.contains("travel.shangdu.com")){
            newsBean = SpiderNews.tempGBK(url,"<h2 class=\"infoTitle\">","div class=\"info_time news_sub_info\"><span>","<","�̶���","<meta name=\"description\" content=\"","\"/");
        }else if(url.contains("www.sdbgw.com.cn")){
            newsBean = SpiderNews.temp2(url,"<h1>","�������ڣ�"," ","ʱ������","<p><span style=\"color:#0000ff;\">","<");
        }else if(url.contains("henan.163.com")){
            newsBean = SpiderNews.temp2(url,"<h1>","     ","����Դ","���׺���","<meta name=\"description\" content=\"","\"");
        }else if(url.contains("www.ha.xinhuanet.com")){
            newsBean = SpiderNews.temp3(url,"\"title\" : '","', ","\"ptime\" : '","',","�»���","\"abs\" : '","',");
        }else if(url.contains("www.bjnews.com.cn")){
            newsBean = SpiderNews.temp2(url,"<div class=\"title\"><h1>","<div class=\"fl ntit_l\"><span class=\"date\">","<","�¾���","<meta name=\"description\" content=\"","\"");
        }else if(url.contains("hn.cnr.cn")){
            newsBean = SpiderNews.tempGBK(url,"<h2>","<span>","</span><","�����","</strong>","<");
        }else if(url.contains("china.cnr.cn")){
            newsBean = SpiderNews.tempGBK(url,"<h2>","<span>","</span><","�����","<div class=TRS_Editor><p>","<");
        }else if(url.contains("www.yywsb.com")){
            newsBean = SpiderNews.tempGBK2(url,"<meta property=\"og:title\" content=\"","\" />"," ","��Դ","ҽҩ������"," <FONT face=����>","<");
            newsBean.time =  newsBean.time.replace("|","") ;
        }else if(url.contains("news.zzedu.net.cn")){
            newsBean = SpiderNews.temp2(url,"<p class=\"font_yahei\"><strong>","<span>","&#","֣�ݽ�����Ϣ��","<p style=\"text-indent: 2em; text-align: left;\">","<");
        }else if(url.contains("school.zzedu.net.cn")){
            newsBean = SpiderNews.temp2(url,"<p class=\"font_yahei\"><strong>","<span>","&#","֣�ݽ�����Ϣ��","<p style=\"text-indent: 2em; text-align: left;\">","<");
        }else if(url.contains("www.zhengzhou.gov.cn")){
            newsBean = SpiderNews.temp3(url,"<meta name=\"ArticleTitle\" content=\"","\"/>","����ʱ�䣺"," ","֣������������","<span style=\"text-indent: 2em;\">","<");
        }else if(url.contains("zz.wenming.cn")){
            newsBean = SpiderNews.temp(url,"<h2 class=\"article-title ffyh\">","<div class=\"info\"> <i>","֣��������","<p align=\"justify\" style=\"overflow-x: hidden; word-break: break-all\">","<");
        }else if(url.contains("henan.youth.cn")){
            newsBean = SpiderNews.temp2(url,"<p class=\"pbt\">","����ʱ�䣺"," ","�й�������","<META name=\"Description\" content='"," ");
        }else if(url.contains("zgsc.china.com.cn")){
            newsBean = SpiderNews.temp2(url,"<h1>","<div class=\"rqly\">"," ","�й���","<p style=\"text-indent: 2em;\">","<");
        }else if(url.contains("zjnews.china.com.cn")){
            newsBean = SpiderNews.temp2(url,"<div class=\"title\">","����ʱ�䣺"," ","�й���","desc: '","',");
        }else if(url.contains("home.china.com.cn")){
            newsBean = SpiderNews.temp2(url,"<h2>","ʱ�䣺"," ","�й���","<meta name=\"description\" content=\"","\">");
        }else if(url.contains("www.cqn.com.cn")){
            newsBean = SpiderNews.temp3(url,"<title>","</title>","<date>"," ","�й�����������","<p style=\"MARGIN: 0px 3px 15px; TEXT-INDENT: 30px\">","<");
        }else if(url.contains("m.cqn.com.cn")){
            newsBean = SpiderNews.temp3(url,"<title>","</title>","<date>"," ","�й�����������","<meta name=\"description\" content=\"","\" />");
        }else if(url.contains("www.chinanews.com")){
            newsBean = SpiderNews.tempGB2312(url,"<input id=\"newstitle\" name=\"newstitle\" type=\"hidden\" value='","'/>","<input id=\"newsdate\" type=\"hidden\" name=\"newsdate\" value=\"","\"/>","������","<p>","<");
        }else if(url.contains("www.ha.chinanews.com.cn")){
            newsBean = SpiderNews.tempGB2312(url,"<div class=\"neiron_title\">","<","<li>","�� ","������","<p>","<");
        }else if(url.contains("finance.chinanews.com")){
            newsBean = SpiderNews.tempGB2312(url,"<input id=\"newstitle\" name=\"newstitle\" type=\"hidden\" value='","'/>","<input id=\"newsdate\" type=\"hidden\" name=\"newsdate\" value=\"","\"/>","������","<meta name=\"description\" content=\"","\" />");
        }else if(url.contains("www.zyjjw.cn")){
            newsBean = SpiderNews.tempGB2312(url,"<div class=\"wb_title\">","</div>","ʱ��:"," ","��ԭ������","<meta name=\"Description\" content=\"","\" />");
        }else if(url.contains("jk.zynews.cn")){
            newsBean = SpiderNews.temp2(url,"<h2 class=\"article-title ffyh\">","<div class=\"info\"> <i>"," ","��ԭ��","<meta property=\"og:description\" content=\"","\" />");
        }else if(url.contains("news.zynews.cn")){
            newsBean = SpiderNews.temp2(url,"<title>","2019","   ","��ԭ��","</strong>","<");
            newsBean.time = "2019" +  newsBean.time  ;
        }else if(url.contains("www.hnly.gov.cn")){
            newsBean = SpiderNews.temp2(url,"<title>","<span style=\"margin-right:20px;\">","</span> ���","����ʡ��ҵ��","<span style=\"font-size:19px;font-family:����_GB2312\">","<");
        }else if(url.contains("www.xingyang.org.cn")){
            newsBean = SpiderNews.temp2(url,"<h1>","����ʱ�䣺 "," ","������","<span style=\"box-sizing: border-box; font-size: 16px;\">","<");
        }else if(url.contains("www.zzsj.gov.cn")){
            newsBean = SpiderNews.temp3(url,"    ","</font></span>","2019-"," ","�Ͻ�������","<p style=\"text-indent:2em;\">","<");
            newsBean.time = "2019-" +  newsBean.time  ;
        }else if(url.contains("zjj.zhengzhou.gov.cn")){
            newsBean = SpiderNews.temp(url,"<h2>","ʱ�䣺","֣�������������ල����վ","<p style=\"text-indent: 2em; text-align: left;\">","<");
        }else if(url.contains("www.rmjtxw.com")){
            newsBean = SpiderNews.tempGB2312(url,"<h1>","</h1>","<div class=\"fl\">2"," ","����ͨ��","<meta name=\"description\" content=\"","\">");
            newsBean.time = "2" +  newsBean.time  ;
        }else if(url.contains("shms.rmjtxw.com")){
            newsBean = SpiderNews.tempGB2312(url,"<div class=\"left1_a\"><h1>","<","<span>","</span>","����ͨ��","<meta name=\"description\" content=\"","\">");
        }else if(url.contains("")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"4g_title\">","<span class=\"subtime\" id=\"pubtime_baidu\">","��ԭ��","<p>","");
        }

/*

* */
        System.out.println(newsBean.toString());
        return newsBean ;
    }
}
