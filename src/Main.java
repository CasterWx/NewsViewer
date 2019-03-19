import com.news.ui.MFrame;
import com.news.web.SpiderNews;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2019-01-24-11:03
 */
public class Main {
    public static void main(String[] args) {
/*
* http://share.zztv.tv/?_hgOutLink=news/newsDetail&id=29607

 * */

        try {
            String mygit = SpiderNews.getWebViewer("https://github.com/CasterWx");
            if (mygit.contains("student")){
                new MFrame("Magic Typewriter v2.1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        ChooseNet.chooseNet("http://news.zynews.cn/2019-03/06/content_11706682.htm");
    }
}






/*
https://wap.zzwb.cn/news/141193
https://www.zzwb.cn/news_141109
http://zzrb.zynews.cn/html/2019-01/30/content_1040662.htm
https://www.toutiao.com/i6651766648149639684/
http://mengma.jinbw.com.cn/queryNewsStringById.do?newid=1180921&flag=1
http://www.dahebao.cn/news/1345445?cid=1345445
http://news.zynews.cn/2019-01/30/content_11666502.htmhttp://news.zynews.cn/2019-01/30/content_11666502.htm

郑州晚报客户端：中牟县、二七区、高新区 3个严重扬尘污染项目被市控尘办约谈
URL：https://wap.zzwb.cn/news/141193
摘要："1月29日，市控尘办对中牟县广惠街办事处、二七区马寨镇、高新区梧桐街办事处辖区的3起严重扬尘污染问题进行约谈。
*/