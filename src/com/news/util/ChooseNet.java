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
        url = url.trim() ;
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
        }else if(url.contains("www.jinbw.com.cn/a")){
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
        }else if(url.contains("www.yywsb.com/art")){
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
            newsBean = SpiderNews.temp2(url,"<h1 class=\"article-title ffyh\">","<i id=\"pubtime_baidu\">"," ","��ԭ��","</strong>","<");
//            http://news.zynews.cn/2017sazz/2017syj/xsq/20190319/2074.html
            if (url.contains("2017sazz/2017syj")){
                String time = newsBean.url.split("/")[6] ;
                System.out.println(time);
                newsBean.time = time.charAt(0) + ""+ time.charAt(1)+ "" +time.charAt(2) + ""+ time.charAt(3) + "-" +time.charAt(4) +time.charAt(5) + "-" +time.charAt(6) +time.charAt(7) ;
            }else if (url.contains("2017sazz")){
                String time = newsBean.url.split("/")[5] ;
                System.out.println(time);
                newsBean.time = time.charAt(0) + ""+ time.charAt(1)+ "" +time.charAt(2) + ""+ time.charAt(3) + "-" +time.charAt(4) +time.charAt(5) + "-" +time.charAt(6) +time.charAt(7) ;
            }else {
//                newsBean.time = newsBean.url.split("/")[3] + "-" + newsBean.url.split("/")[4] ;
            }
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
        }else if(url.contains("mbd.baidu.com")){
            newsBean = SpiderNews.temp5(url,"<h1 class=\"titleSize\">","<","<div class=\"infoSet\"><span>","</span>","�ټҺ�","class=\"authorName\">","<span class=\"bjh-p\">","<");
        }else if(url.contains("baijiahao.baidu.com")) {
            newsBean = SpiderNews.temp5(url,"<title>","<","<meta itemprop=\"dateUpdate\" content=\""," ","�ټҺ�","<p class=\"author-name\">","<span class=\"bjh-p\">","<");
        }else if(url.contains("m.sohu.com")) {
            newsBean = SpiderNews.tempGB2312_t(url, "title: '", "',","<meta itemprop=\"dateUpdate\" content=\"", "\" />","�Ѻ���","<header class=\"name\">", "<meta name=\"description\" content=\"", "\" />");
        }else if(url.contains("www.sohu.com")) {
            newsBean = SpiderNews.tempGB2312_t(url, "<meta property=\"og:title\" content=\"", "\"/>","<meta property=\"og:release_date\" content=\"", " ","�Ѻ���","��Դ:<a href=\"\" target=\"_blank\">", "<meta name=\"description\" content=\"", "\" />");
        }else if(url.contains("mp.weixin.qq.com")) {
            newsBean = SpiderNews.tempGB2312_t(url, "var msg_title = \"", "\";","var publish_time = \"", "\"","΢�Ź��ں�","<strong class=\"profile_nickname\">", "var msg_desc = \"", "\";");
        }else if(url.contains("c.m.163.com")) {
            newsBean = SpiderNews.tempGB2312_t(url, "<h1 class=\"g-title\">", "<","<span>", "</span>","���׺�","<b>", "<p>", "</p>");
        }else if(url.contains("dy.163.com")) {
            newsBean = SpiderNews.tempGB2312_t(url, "<title>", "_","data-ptime=\"", " ","���׺�","<h4>", "<p>", "</p>");
        }else if(url.contains("newpaper.dahe.cn/dhb/")){
            newsBean = SpiderNews.temp5(url, "<title>","<","data-ptime=\"","<", "��ӱ�","<td width=\"160\" align=left>", "</p><p>&nbsp;","<");
            newsBean.title = newsBean.title.split("--")[0];
            newsBean.come = newsBean.come.replace("��","").replace("��","").replace("��","");
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("newpaper.dahe.cn/dhjkb/")) {
            newsBean = SpiderNews.temp5(url, "<title>","<","data-ptime=\"","<", "��ӽ�����","<td width=\"160\" align=left>", "</p><p>&nbsp;","<");
            newsBean.title = newsBean.title.split("--")[0];
            newsBean.come = newsBean.come.replace("��","").replace("��","").replace("��","");
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("www.jinbw.com.cn/dzb")) {
            newsBean = SpiderNews.temp5(url, "<td class=\"font01\" align=center style=\"color: #0205FF;\">","<","<strong>"," ����", "������","<td width=\"145\" align=left>", "<p><p&nbsp;xmlns=\"\">","<");
            newsBean.come = newsBean.come.replace("��","").replace("��","").replace("��","");
        }else if(url.contains("dzb.jinbw.com.cn")) {
            newsBean = SpiderNews.temp5(url, "<td class=\"font01\" align=center style=\"color: #0205FF;\">","<","<strong>"," ����", "������","<td width=\"145\" align=left>", "<p><p&nbsp;xmlns=\"\">","<");
            newsBean.come = newsBean.come.replace("��","").replace("��","").replace("��","");
        }else if(url.contains("newpaper.dahe.cn/jrab/")) {
            newsBean = SpiderNews.temp5(url, "<title>","--","<strong>","<", "���Ϸ��Ʊ���","<founder-pagenum>", "<!--enpcontent--><P><p>","<");
            newsBean.come = newsBean.come.replace("��","").replace("��","") + "��";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("www.hngrrb.cn")) {
            newsBean = SpiderNews.temp5(url, "<founder-title>","<","<strong>","<", "���Ϲ����ձ���","<founder-pagenum>", "<founder-content><P>","<");
            newsBean.come = newsBean.come.replace("��","").replace("��","") + "��";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("newpaper.dahe.cn/hnrb/")) {
            newsBean = SpiderNews.temp5(url, "<title>","--","<strong>","<", "�����ձ���","<founder-pagenum>", "<p>&nbsp;&nbsp;&nbsp;&nbsp;","<");
            newsBean.come = newsBean.come.replace("��","").replace("��","") + "��";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("newpaper.dahe.cn/hnrbncb/")) {
            newsBean = SpiderNews.temp5(url, "<title>","--","<strong>","<", "�����ձ�ũ�屨��","<founder-pagenum>", "<p>&nbsp;&nbsp;&nbsp;&nbsp;","<");
            newsBean.come = newsBean.come.replace("��","").replace("��","") + "��";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("newpaper.dahe.cn/hnsb/")) {
            newsBean = SpiderNews.temp5(url, "<title>","--","<strong>","<", "�����̱���","<founder-pagenum>", "<!--enpcontent--><P>","<");
            newsBean.come = newsBean.come.replace("��","").replace("��","") + "��";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("www.yywsb.com")) {
            newsBean = SpiderNews.temp6(url, "<TD align=left valign=\"top\" class=default ><P>","<","<strong>","<", "ҽҩ������","          ", "<P>&nbsp;","<");
            newsBean.time = newsBean.url.split("/")[4] + "-" + newsBean.url.split("/")[5] ;
        }else if(url.contains("newpaper.dahe.cn/jrxf/")) {
            newsBean = SpiderNews.temp5(url, "<title>","--","<strong>","<", "�������ѱ���","<founder-pagenum>", "<!--enpcontent--><P>","</");
            if (newsBean.comment!=null){
                newsBean.comment = newsBean.comment.replace("<P>","").replace("<p>","").replace("</P>","").replace("</p>","");
            }
            newsBean.come = newsBean.come.replace("��","").replace("��","") + "��";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("epaper.hnfzb.com:8080")) {
            String timess = url.split("/")[6] + "-" + url.split("/")[7]+ "-" + url.split("/")[8] ;
            newsBean = SpiderNews.temp6(url, "<h2 class=\"content_title\">","<","<strong>","<", "���Ϸ��Ʊ�",timess +" ", "<div id=\"pgcontent\" class=\"nfont\">","</");
            if (newsBean.comment!=null){
                newsBean.comment = newsBean.comment.replace("<P>","").replace("<p>","").replace("</P>","").replace("</p>","");
            }
            newsBean.time = newsBean.url.split("/")[6] + "-" + newsBean.url.split("/")[7]+ "-" + newsBean.url.split("/")[8] ;
        }else if(url.contains("www.hndt.com")) {
            newsBean = SpiderNews.temp3(url, "<title>","<","<span class=\"tag\">"," ", "���Ϲ㲥�ͻ���", "<p><span style=\"font-size: 18px;\">","<");
        }else if(url.contains("www.henandaily.cn")) {
            newsBean = SpiderNews.temp3(url, "<title>","-","<div class=\"content-time\">"," ", "�����ձ��ͻ���", "<meta name=\"description\" content=\"","\" />");
            newsBean.time = newsBean.time.replace(".","-");
        }else if(url.contains("huimian.app.china.com")) {
            newsBean = SpiderNews.temp3(url, "<title>","<","\t\t201"," ", "֣�ݵ�̨�ͻ���", "<p style=\"text-align: justify;\">","<");
            if (newsBean.comment==null){
                newsBean = SpiderNews.temp3(url, "<title>","<","\t\t201"," ", "֣�ݵ�̨�ͻ���", "<p style=\"text-indent: 2em;\">","<");
            }
            newsBean.time = "201" + newsBean.time;
        }else if(url.contains("www.shangbw.com")) {
            newsBean = SpiderNews.temp3(url, "<title>","_","�������ڣ�","&", "�����̱��ͻ���", "<meta name=\"description\" content=\"","\"/>");
        }else if(url.contains("khd.shangbw.com")) {
            newsBean = SpiderNews.temp3(url, "  ","</h1>","201"," ", "�����̱��ͻ���", "����","<br />");
            newsBean.time = "201" + newsBean.time;
        }else if(url.contains("share.zztv.tv")) {
            newsBean = SpiderNews.temp3(url, "<title>","<","<span id=\"ptime\" class=\"date\">","<", "֣�ݵ���̨�ͻ���", "ext-align: left; margin-top: 0px; margin-bottom: 0px; padding: 0px; box-sizing: border-box;\">","</");
        }else if(url.contains("liuyan.people.com.cn")) {
            newsBean = SpiderNews.temp3(url, "<h2><b>","\n","&nbsp;&nbsp;&nbsp;&nbsp;","</span>", "���������԰�", "<p class=\"zoom\">","</");
        }else if(url.contains("xtq.zynews.cn")) {
            newsBean = SpiderNews.temp3(url, "<meta name=\"keywords\" content=\"","\" />","������ "," ", "��ͨ��", "&nbsp; &nbsp;&nbsp; &nbsp;","<");
        }else if(url.contains("club.kdnet.net")) {
            newsBean = SpiderNews.temp3(url, "<div class=\"posts-title\">","</div>","</span> 201"," ", "��������", "&nbsp;&nbsp;&nbsp;&nbsp;","<");
            newsBean.time = ("201" + newsBean.time).replace("/","-");
        }else if(url.contains("bbs.tianya.cn")) {
            newsBean = SpiderNews.temp3(url, "<span class=\"s_title\"><span style=\"font-weight:400;\">","<","js_replytime=\""," ", "������̳", "<meta name=\"description\" itemprop=\"description\" content=\"","\" />");
        }else if(url.contains("edu.zynews.cn")){
            newsBean = SpiderNews.tempGB2312(url, "<h1 class=\"article-title ffyh\">","<","<div class=\"info\"><i>","</i><i>��Դ", "��ԭ��", "<p><p>","<");

        }
/*

* */
        System.out.println(newsBean.toString());
        return newsBean ;
    }
}
