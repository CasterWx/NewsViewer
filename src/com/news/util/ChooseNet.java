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
        // 域名选择
        if (url.contains("wap.zzwb.cn")){
            // 郑州晚报客户端 zzwb.zynews.cn
            newsBean = SpiderNews.getZzwb(url) ;
        }else if(url.contains("newwap.zzrbnews.com/gov")){
            // 郑州日报
            newsBean = SpiderNews.getZZRBNews(url) ;
        }else if(url.contains("zzwb.zynews.cn")){
            //郑州晚报第x版
            newsBean = SpiderNews.getZYnewsZzwb(url) ;
        }else if (url.contains("www.zzwb.cn")){
            // 郑州晚报客户端
            newsBean = SpiderNews.getWWWZzwb(url) ;
        }else if(url.contains("newwap.zzrbnews.com")){
            //郑州日报客户端
            newsBean = SpiderNews.getNewsZZRB(url) ;
        }else if(url.contains("zzrb.zynews.cn")){
            // 郑州日报第x版
            newsBean = SpiderNews.getZYnews(url) ;
        }else if(url.contains("www.toutiao.com")){
            // 头条号《xxxx》
            newsBean = SpiderNews.getToutiao(url);
        }else if(url.contains("mengma.jinbw.com.cn")){
            // 猛犸客户端
            newsBean = SpiderNews.getMengMa(url);
        }else if(url.contains("www.dahebao.cn")){
            // 大河客户端
            newsBean = SpiderNews.getDahebao(url);
        }else if(url.contains("news.dahebao.cn")){
            // 大河news
            newsBean = SpiderNews.getNewsDahebao(url);
        }else if(url.contains("gov.hnr.cn")){
            //  映象网
            newsBean = SpiderNews.getYingxiang(url);
        }else if(url.contains("news.hnr.cn")){
            //  映象网
            newsBean = SpiderNews.getNewsYingxiang(url);
        }else if(url.contains("www.takungpao.com")){
            newsBean = SpiderNews.getWWWtakungpao(url);
        }else if(url.contains("news.takungpao.com")){
            newsBean = SpiderNews.getNewstakungpao(url);
        }else if(url.contains("news.dahe.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"4g_title\">","<p class=\"time fl\" id=\"pubtime_baidu\">","大河网","<p>","<");
        }else if(url.contains("4g.dahe.cn")){
            newsBean = SpiderNews.temp(url,"<h1>","<p class=\"fl\">","大河网","<p>","<");
        }else if(url.contains("city.dahe.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"4g_title\">","<p class=\"time fl\" id=\"pubtime_baidu\">","大河网","<p>","<");
        }else if(url.contains("edu.dahe.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"4g_title\">","<p class=\"time fl\" id=\"pubtime_baidu\">","大河网","<p>","<");
        }else if(url.contains("photo.dahe.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"4g_title\">","<span class=\"subtime\" id=\"pubtime_baidu\">","大河网","<p>","<");
        }else if(url.contains("hn.ifeng.com")){
            newsBean = SpiderNews.temp(url,"<h1 itemprop=\"headline\" id=\"artical_topic\">","<span itemprop=\"datePublished\" class=\"ss01\">","凤凰网","<p>","<");
        }else if(url.contains("hn.cri.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"atitle\" class=\"atitle\">","<span id=\"apublishtime\" class=\"apublishtime\">","国际在线","<p>&emsp;&emsp;","<");
        }else if(url.contains("hn.chinaso.com")){
            newsBean = SpiderNews.temp(url,"<h1 class=\"detail-title\">"," <span>","国搜河南","</strong>","<");
        }else if(url.contains("www.henanfazhi.net")){
            newsBean = SpiderNews.temp(url,"<h1>","<span class=\"date\">","河南法治网","&nbsp;&nbsp;","<");
        }else if(url.contains("www.hnfzb.com")){
            newsBean = SpiderNews.temp(url,"<title>","时间：","河南法治在线网","</strong>","<");
            newsBean.title = newsBean.title.split("平安河南")[0];
        }else if(url.contains("news.hnjkw.net")){
            newsBean = SpiderNews.temp(url,"<H1>","<span>","河南健康网","</strong>","<");
        }else if(url.contains("www.henan.gov.cn")){
            newsBean = SpiderNews.temp(url,"<h1 id=\"title\">","<i id=\"pubDate\">","河南省人民政府","<p>","</p>");
        }else if(url.contains("www.shenji.henan.gov.cn")){
            newsBean = SpiderNews.tempGBK(url,"<FONT size=+0>","时间：","&nbsp;&nbsp;浏览","河南省审计厅","<P style=\"LINE-HEIGHT: 2; TEXT-INDENT: 38px\"><FONT style=\"FONT-FAMILY: 宋体; FONT-SIZE: 18px\">","<");
        }else if(url.contains("www.henan100.com")){
            newsBean = SpiderNews.temp(url,"<h1><a href=\"","发布时间：","河南一百度","<meta name=\"Description\" content=\"","\"");
            newsBean.title = newsBean.title.split(">")[1] ;
        }else if(url.contains("www.jinbw.com.cn/a")){
            newsBean = SpiderNews.temp(url,"<h1>","<span>","今报网","<p>","<");
        }else if(url.contains("xinwen.mlzgw.cn")){
            newsBean = SpiderNews.temp(url,"<h1 itemprop=\"headline\" id=\"artical_topic\">","<span class=\"ss01\">","魅力中国网","<p>","</p");
        }else if(url.contains("hn.mzyfz.com")){
            newsBean = SpiderNews.tempGBK(url,"<title>","发布："," ","民主与法制网","本网讯（</font>","</span");
            newsBean.title = newsBean.title.split("-")[0] ;
        }else if(url.contains("www.thepaper.cn")){
            newsBean = SpiderNews.temp2(url,"<h1 class=\"news_title\">","    ","<span>&nbsp;&nbsp;","澎湃新闻","meta name=\"Description\" content=\"","\"");
        }else if(url.contains("jszx.court.gov.cn")){
            newsBean = SpiderNews.temp(url,"div class=\"title\">","发布时间：","全国法院决胜”基本解决执行难“信息网","<span style=\"text-indent: 2em;\">","<");
        }else if(url.contains("henan.people.com.cn")){
            newsBean = SpiderNews.tempGBK(url,"<h1>","<div class=\"fl\">","来源","人民网","<meta name=\"description\" content=\"","\"");
        }else if(url.contains("ha.people.com.cn")){
            newsBean = SpiderNews.tempGBK(url,"<h1>","<div class=\"fl\">","来源","人民网","\t","</p>");
        }else if(url.contains("travel.shangdu.com")){
            newsBean = SpiderNews.tempGBK(url,"<h2 class=\"infoTitle\">","div class=\"info_time news_sub_info\"><span>","<","商都网","<meta name=\"description\" content=\"","\"/");
        }else if(url.contains("www.sdbgw.com.cn")){
            newsBean = SpiderNews.temp2(url,"<h1>","发布日期："," ","时代报告","<p><span style=\"color:#0000ff;\">","<");
        }else if(url.contains("henan.163.com")){
            newsBean = SpiderNews.temp2(url,"<h1>","     ","　来源","网易河南","<meta name=\"description\" content=\"","\"");
        }else if(url.contains("www.ha.xinhuanet.com")){
            newsBean = SpiderNews.temp3(url,"\"title\" : '","', ","\"ptime\" : '","',","新华网","\"abs\" : '","',");
        }else if(url.contains("www.bjnews.com.cn")){
            newsBean = SpiderNews.temp2(url,"<div class=\"title\"><h1>","<div class=\"fl ntit_l\"><span class=\"date\">","<","新京报","<meta name=\"description\" content=\"","\"");
        }else if(url.contains("hn.cnr.cn")){
            newsBean = SpiderNews.tempGBK(url,"<h2>","<span>","</span><","央广网","</strong>","<");
        }else if(url.contains("china.cnr.cn")){
            newsBean = SpiderNews.tempGBK(url,"<h2>","<span>","</span><","央广网","<div class=TRS_Editor><p>","<");
        }else if(url.contains("www.yywsb.com/art")){
            newsBean = SpiderNews.tempGBK2(url,"<meta property=\"og:title\" content=\"","\" />"," ","来源","医药卫生网"," <FONT face=宋体>","<");
            newsBean.time =  newsBean.time.replace("|","") ;
        }else if(url.contains("news.zzedu.net.cn")){
            newsBean = SpiderNews.temp2(url,"<p class=\"font_yahei\"><strong>","<span>","&#","郑州教育信息网","<p style=\"text-indent: 2em; text-align: left;\">","<");
        }else if(url.contains("school.zzedu.net.cn")){
            newsBean = SpiderNews.temp2(url,"<p class=\"font_yahei\"><strong>","<span>","&#","郑州教育信息网","<p style=\"text-indent: 2em; text-align: left;\">","<");
        }else if(url.contains("www.zhengzhou.gov.cn")){
            newsBean = SpiderNews.temp3(url,"<meta name=\"ArticleTitle\" content=\"","\"/>","发布时间："," ","郑州市人民政府","<span style=\"text-indent: 2em;\">","<");
        }else if(url.contains("zz.wenming.cn")){
            newsBean = SpiderNews.temp(url,"<h2 class=\"article-title ffyh\">","<div class=\"info\"> <i>","郑州文明网","<p align=\"justify\" style=\"overflow-x: hidden; word-break: break-all\">","<");
        }else if(url.contains("henan.youth.cn")){
            newsBean = SpiderNews.temp2(url,"<p class=\"pbt\">","发稿时间："," ","中国青年网","<META name=\"Description\" content='"," ");
        }else if(url.contains("zgsc.china.com.cn")){
            newsBean = SpiderNews.temp2(url,"<h1>","<div class=\"rqly\">"," ","中国网","<p style=\"text-indent: 2em;\">","<");
        }else if(url.contains("zjnews.china.com.cn")){
            newsBean = SpiderNews.temp2(url,"<div class=\"title\">","发布时间："," ","中国网","desc: '","',");
        }else if(url.contains("home.china.com.cn")){
            newsBean = SpiderNews.temp2(url,"<h2>","时间："," ","中国网","<meta name=\"description\" content=\"","\">");
        }else if(url.contains("www.cqn.com.cn")){
            newsBean = SpiderNews.temp3(url,"<title>","</title>","<date>"," ","中国质量新闻网","<p style=\"MARGIN: 0px 3px 15px; TEXT-INDENT: 30px\">","<");
        }else if(url.contains("m.cqn.com.cn")){
            newsBean = SpiderNews.temp3(url,"<title>","</title>","<date>"," ","中国质量新闻网","<meta name=\"description\" content=\"","\" />");
        }else if(url.contains("www.chinanews.com")){
            newsBean = SpiderNews.tempGB2312(url,"<input id=\"newstitle\" name=\"newstitle\" type=\"hidden\" value='","'/>","<input id=\"newsdate\" type=\"hidden\" name=\"newsdate\" value=\"","\"/>","中新网","<p>","<");
        }else if(url.contains("www.ha.chinanews.com.cn")){
            newsBean = SpiderNews.tempGB2312(url,"<div class=\"neiron_title\">","<","<li>","日 ","中新网","<p>","<");
        }else if(url.contains("finance.chinanews.com")){
            newsBean = SpiderNews.tempGB2312(url,"<input id=\"newstitle\" name=\"newstitle\" type=\"hidden\" value='","'/>","<input id=\"newsdate\" type=\"hidden\" name=\"newsdate\" value=\"","\"/>","中新网","<meta name=\"description\" content=\"","\" />");
        }else if(url.contains("www.zyjjw.cn")){
            newsBean = SpiderNews.tempGB2312(url,"<div class=\"wb_title\">","</div>","时间:"," ","中原经济网","<meta name=\"Description\" content=\"","\" />");
        }else if(url.contains("jk.zynews.cn")){
            newsBean = SpiderNews.temp2(url,"<h2 class=\"article-title ffyh\">","<div class=\"info\"> <i>"," ","中原网","<meta property=\"og:description\" content=\"","\" />");
        }else if(url.contains("news.zynews.cn")){
            newsBean = SpiderNews.temp2(url,"<h1 class=\"article-title ffyh\">","<i id=\"pubtime_baidu\">"," ","中原网","</strong>","<");
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
            newsBean = SpiderNews.temp2(url,"<title>","<span style=\"margin-right:20px;\">","</span> 浏览","河南省林业局","<span style=\"font-size:19px;font-family:仿宋_GB2312\">","<");
        }else if(url.contains("www.xingyang.org.cn")){
            newsBean = SpiderNews.temp2(url,"<h1>","发布时间： "," ","荥阳网","<span style=\"box-sizing: border-box; font-size: 16px;\">","<");
        }else if(url.contains("www.zzsj.gov.cn")){
            newsBean = SpiderNews.temp3(url,"    ","</font></span>","2019-"," ","上街区政府","<p style=\"text-indent:2em;\">","<");
            newsBean.time = "2019-" +  newsBean.time  ;
        }else if(url.contains("zjj.zhengzhou.gov.cn")){
            newsBean = SpiderNews.temp(url,"<h2>","时间：","郑州市质量技术监督局网站","<p style=\"text-indent: 2em; text-align: left;\">","<");
        }else if(url.contains("www.rmjtxw.com")){
            newsBean = SpiderNews.tempGB2312(url,"<h1>","</h1>","<div class=\"fl\">2"," ","人民交通网","<meta name=\"description\" content=\"","\">");
            newsBean.time = "2" +  newsBean.time  ;
        }else if(url.contains("shms.rmjtxw.com")){
            newsBean = SpiderNews.tempGB2312(url,"<div class=\"left1_a\"><h1>","<","<span>","</span>","人民交通网","<meta name=\"description\" content=\"","\">");
        }else if(url.contains("mbd.baidu.com")){
            newsBean = SpiderNews.temp5(url,"<h1 class=\"titleSize\">","<","<div class=\"infoSet\"><span>","</span>","百家号","class=\"authorName\">","<span class=\"bjh-p\">","<");
        }else if(url.contains("baijiahao.baidu.com")) {
            newsBean = SpiderNews.temp5(url,"<title>","<","<meta itemprop=\"dateUpdate\" content=\""," ","百家号","<p class=\"author-name\">","<span class=\"bjh-p\">","<");
        }else if(url.contains("m.sohu.com")) {
            newsBean = SpiderNews.tempGB2312_t(url, "title: '", "',","<meta itemprop=\"dateUpdate\" content=\"", "\" />","搜狐号","<header class=\"name\">", "<meta name=\"description\" content=\"", "\" />");
        }else if(url.contains("www.sohu.com")) {
            newsBean = SpiderNews.tempGB2312_t(url, "<meta property=\"og:title\" content=\"", "\"/>","<meta property=\"og:release_date\" content=\"", " ","搜狐号","来源:<a href=\"\" target=\"_blank\">", "<meta name=\"description\" content=\"", "\" />");
        }else if(url.contains("mp.weixin.qq.com")) {
            newsBean = SpiderNews.tempGB2312_t(url, "var msg_title = \"", "\";","var publish_time = \"", "\"","微信公众号","<strong class=\"profile_nickname\">", "var msg_desc = \"", "\";");
        }else if(url.contains("c.m.163.com")) {
            newsBean = SpiderNews.tempGB2312_t(url, "<h1 class=\"g-title\">", "<","<span>", "</span>","网易号","<b>", "<p>", "</p>");
        }else if(url.contains("dy.163.com")) {
            newsBean = SpiderNews.tempGB2312_t(url, "<title>", "_","data-ptime=\"", " ","网易号","<h4>", "<p>", "</p>");
        }else if(url.contains("newpaper.dahe.cn/dhb/")){
            newsBean = SpiderNews.temp5(url, "<title>","<","data-ptime=\"","<", "大河报","<td width=\"160\" align=left>", "</p><p>&nbsp;","<");
            newsBean.title = newsBean.title.split("--")[0];
            newsBean.come = newsBean.come.replace("《","").replace("》","").replace("：","");
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("newpaper.dahe.cn/dhjkb/")) {
            newsBean = SpiderNews.temp5(url, "<title>","<","data-ptime=\"","<", "大河健康报","<td width=\"160\" align=left>", "</p><p>&nbsp;","<");
            newsBean.title = newsBean.title.split("--")[0];
            newsBean.come = newsBean.come.replace("《","").replace("》","").replace("：","");
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("www.jinbw.com.cn/dzb")) {
            newsBean = SpiderNews.temp5(url, "<td class=\"font01\" align=center style=\"color: #0205FF;\">","<","<strong>"," 星期", "东方今报","<td width=\"145\" align=left>", "<p><p&nbsp;xmlns=\"\">","<");
            newsBean.come = newsBean.come.replace("《","").replace("》","").replace("：","");
        }else if(url.contains("dzb.jinbw.com.cn")) {
            newsBean = SpiderNews.temp5(url, "<td class=\"font01\" align=center style=\"color: #0205FF;\">","<","<strong>"," 星期", "东方今报","<td width=\"145\" align=left>", "<p><p&nbsp;xmlns=\"\">","<");
            newsBean.come = newsBean.come.replace("《","").replace("》","").replace("：","");
        }else if(url.contains("newpaper.dahe.cn/jrab/")) {
            newsBean = SpiderNews.temp5(url, "<title>","--","<strong>","<", "河南法制报第","<founder-pagenum>", "<!--enpcontent--><P><p>","<");
            newsBean.come = newsBean.come.replace("《","").replace("》","") + "版";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("www.hngrrb.cn")) {
            newsBean = SpiderNews.temp5(url, "<founder-title>","<","<strong>","<", "河南工人日报第","<founder-pagenum>", "<founder-content><P>","<");
            newsBean.come = newsBean.come.replace("《","").replace("》","") + "版";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("newpaper.dahe.cn/hnrb/")) {
            newsBean = SpiderNews.temp5(url, "<title>","--","<strong>","<", "河南日报第","<founder-pagenum>", "<p>&nbsp;&nbsp;&nbsp;&nbsp;","<");
            newsBean.come = newsBean.come.replace("《","").replace("》","") + "版";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("newpaper.dahe.cn/hnrbncb/")) {
            newsBean = SpiderNews.temp5(url, "<title>","--","<strong>","<", "河南日报农村报第","<founder-pagenum>", "<p>&nbsp;&nbsp;&nbsp;&nbsp;","<");
            newsBean.come = newsBean.come.replace("《","").replace("》","") + "版";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("newpaper.dahe.cn/hnsb/")) {
            newsBean = SpiderNews.temp5(url, "<title>","--","<strong>","<", "河南商报第","<founder-pagenum>", "<!--enpcontent--><P>","<");
            newsBean.come = newsBean.come.replace("《","").replace("》","") + "版";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("www.yywsb.com")) {
            newsBean = SpiderNews.temp6(url, "<TD align=left valign=\"top\" class=default ><P>","<","<strong>","<", "医药卫生报","          ", "<P>&nbsp;","<");
            newsBean.time = newsBean.url.split("/")[4] + "-" + newsBean.url.split("/")[5] ;
        }else if(url.contains("newpaper.dahe.cn/jrxf/")) {
            newsBean = SpiderNews.temp5(url, "<title>","--","<strong>","<", "今日消费报第","<founder-pagenum>", "<!--enpcontent--><P>","</");
            if (newsBean.comment!=null){
                newsBean.comment = newsBean.comment.replace("<P>","").replace("<p>","").replace("</P>","").replace("</p>","");
            }
            newsBean.come = newsBean.come.replace("《","").replace("》","") + "版";
            newsBean.time = newsBean.url.split("/")[5] + "-" + newsBean.url.split("/")[6] ;
        }else if(url.contains("epaper.hnfzb.com:8080")) {
            String timess = url.split("/")[6] + "-" + url.split("/")[7]+ "-" + url.split("/")[8] ;
            newsBean = SpiderNews.temp6(url, "<h2 class=\"content_title\">","<","<strong>","<", "河南法制报",timess +" ", "<div id=\"pgcontent\" class=\"nfont\">","</");
            if (newsBean.comment!=null){
                newsBean.comment = newsBean.comment.replace("<P>","").replace("<p>","").replace("</P>","").replace("</p>","");
            }
            newsBean.time = newsBean.url.split("/")[6] + "-" + newsBean.url.split("/")[7]+ "-" + newsBean.url.split("/")[8] ;
        }else if(url.contains("www.hndt.com")) {
            newsBean = SpiderNews.temp3(url, "<title>","<","<span class=\"tag\">"," ", "河南广播客户端", "<p><span style=\"font-size: 18px;\">","<");
        }else if(url.contains("www.henandaily.cn")) {
            newsBean = SpiderNews.temp3(url, "<title>","-","<div class=\"content-time\">"," ", "河南日报客户端", "<meta name=\"description\" content=\"","\" />");
            newsBean.time = newsBean.time.replace(".","-");
        }else if(url.contains("huimian.app.china.com")) {
            newsBean = SpiderNews.temp3(url, "<title>","<","\t\t201"," ", "郑州电台客户端", "<p style=\"text-align: justify;\">","<");
            if (newsBean.comment==null){
                newsBean = SpiderNews.temp3(url, "<title>","<","\t\t201"," ", "郑州电台客户端", "<p style=\"text-indent: 2em;\">","<");
            }
            newsBean.time = "201" + newsBean.time;
        }else if(url.contains("www.shangbw.com")) {
            newsBean = SpiderNews.temp3(url, "<title>","_","发布日期：","&", "河南商报客户端", "<meta name=\"description\" content=\"","\"/>");
        }else if(url.contains("khd.shangbw.com")) {
            newsBean = SpiderNews.temp3(url, "  ","</h1>","201"," ", "河南商报客户端", "　　","<br />");
            newsBean.time = "201" + newsBean.time;
        }else if(url.contains("share.zztv.tv")) {
            newsBean = SpiderNews.temp3(url, "<title>","<","<span id=\"ptime\" class=\"date\">","<", "郑州电视台客户端", "ext-align: left; margin-top: 0px; margin-bottom: 0px; padding: 0px; box-sizing: border-box;\">","</");
        }else if(url.contains("liuyan.people.com.cn")) {
            newsBean = SpiderNews.temp3(url, "<h2><b>","\n","&nbsp;&nbsp;&nbsp;&nbsp;","</span>", "人民网留言板", "<p class=\"zoom\">","</");
        }else if(url.contains("xtq.zynews.cn")) {
            newsBean = SpiderNews.temp3(url, "<meta name=\"keywords\" content=\"","\" />","发表于 "," ", "心通桥", "&nbsp; &nbsp;&nbsp; &nbsp;","<");
        }else if(url.contains("club.kdnet.net")) {
            newsBean = SpiderNews.temp3(url, "<div class=\"posts-title\">","</div>","</span> 201"," ", "凯迪社区", "&nbsp;&nbsp;&nbsp;&nbsp;","<");
            newsBean.time = ("201" + newsBean.time).replace("/","-");
        }else if(url.contains("bbs.tianya.cn")) {
            newsBean = SpiderNews.temp3(url, "<span class=\"s_title\"><span style=\"font-weight:400;\">","<","js_replytime=\""," ", "天涯论坛", "<meta name=\"description\" itemprop=\"description\" content=\"","\" />");
        }else if(url.contains("edu.zynews.cn")){
            newsBean = SpiderNews.tempGB2312(url, "<h1 class=\"article-title ffyh\">","<","<div class=\"info\"><i>","</i><i>来源", "中原网", "<p><p>","<");

        }
/*

* */
        System.out.println(newsBean.toString());
        return newsBean ;
    }
}
