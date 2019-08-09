package spring.springboot2;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : ZJ
 * @date : 19-8-7 下午5:55
 */
public class Test4 {
    public static String cssStr(String str) {
        String pattern = "(url\\(\")(.*)(\"\\))";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find()) {
            return StringUtils.replace(str, m.group(2), "http://baidu.com");
        }
        return str;
    }

    public static void main(String[] args) {
//        MyLinkedList linkedList = new MyLinkedList();
//        linkedList.addAtHead(1);
//
//        System.out.println(linkedList);

        Document doc = Jsoup.parse("<section style=\"box-sizing: border-box; font-style: normal; font-weight: 400; text-align: justify; font-size: 16px;\"><section style=\"position: static; box-sizing: border-box;\"><section style=\"display: inline-block; width: 100%; vertical-align: top; background-position: 50% 50%; background-repeat: no-repeat; background-size: cover; background-attachment: scroll; background-image: url(&quot;http://statics.xiumi.us/stc/images/templates-assets/tpl-paper/image/5932cf53ba079ebc8a702fec3ad5ebca-sz_788213.png&quot;); box-sizing: border-box;\"><section style=\"box-sizing: border-box;\"><p style=\"white-space: normal; margin: 0px; padding: 0px; box-sizing: border-box;\"><br/></p></section><section style=\"font-size: 12px; color: rgb(255, 255, 255); letter-spacing: 1px; box-sizing: border-box;\"><p style=\"text-align: right; white-space: normal; margin: 0px; padding: 0px; box-sizing: border-box;\">周洁茹&nbsp;▍《岛上蔷薇》</p></section><section style=\"color: rgb(255, 255, 255); font-size: 21px; box-sizing: border-box;\"><p style=\"text-align: right; white-space: normal; margin: 0px; padding: 0px; box-sizing: border-box;\">蔷薇是什么花？</p></section><section style=\"font-size: 12px; color: rgb(255, 255, 255); letter-spacing: 2px; opacity: 0.43; box-sizing: border-box;\"><p style=\"text-align: right; white-space: normal; margin: 0px; padding: 0px; box-sizing: border-box;\">Finding my secret garden</p></section><section style=\"text-align: right; position: static; box-sizing: border-box;\"><section style=\"display: inline-block; vertical-align: top; width: 25%; box-sizing: border-box;\"><section style=\"margin: 15px 0% 8px; position: static; box-sizing: border-box;\"><section style=\"background-color: rgb(249, 174, 165); height: 1px; box-sizing: border-box;\"></section></section></section><section style=\"display: inline-block; vertical-align: top; width: 25%; box-sizing: border-box;\"><section style=\"text-align: justify; color: rgb(255, 255, 255); font-size: 18px; box-sizing: border-box;\"><p style=\"white-space: normal; margin: 0px; padding: 0px; box-sizing: border-box;\">&nbsp; 序</p></section></section></section><section style=\"box-sizing: border-box;\"><p style=\"white-space: normal; margin: 0px; padding: 0px; box-sizing: border-box;\"><br/></p></section><section style=\"margin-top: 10px; margin-bottom: 10px; text-align: center; position: static; box-sizing: border-box;\"><section style=\"display: inline-block; width: 80%; border: 1px solid rgb(249, 174, 165); padding: 10px; background-color: rgba(255, 74, 74, 0.62); box-sizing: border-box;\"><section style=\"text-align: justify; color: rgb(255, 255, 255); font-size: 12px; line-height: 2; padding: 0px 5px; box-sizing: border-box;\"><p style=\"white-space: normal; margin: 0px; padding: 0px; box-sizing: border-box;\">蔷薇（学名：Rosa multiflora），又称野蔷薇，是一种蔓藤爬篱笆的小花，耐寒，可以药用。野蔷薇多自然分布于溪畔、路旁及园边、地角等处，往往密集丛生，满枝灿烂，微雨或朝露后，花瓣红晕湿透，景色颇佳。——维基百科</p></section></section></section></section></section></section><section style=\"box-sizing: border-box; font-style: normal; font-weight: 400; text-align: justify; font-size: 16px;\"><section style=\"position: static; box-sizing: border-box;\"><section style=\"display: inline-block; width: 100%; vertical-align: top; background-position: 0% 0%; background-repeat: repeat; background-size: 50%; background-attachment: scroll; background-image: url(&quot;http://statics.xiumi.us/stc/images/templates-assets/tpl-paper/image/3bff7e0566b6927048a87ac04fb6a5a8-sz_45659.jpg?x-oss-process=style/xmorient&quot;); box-sizing: border-box;\"><section style=\"position: static; box-sizing: border-box;\"><section style=\"display: inline-block; vertical-align: top; width: 75%; box-sizing: border-box;\"><section style=\"margin: 0px 0%; position: static; box-sizing: border-box;\"><section style=\"display: inline-block; width: 100%; border: 1px solid transparent; padding: 10px; background-color: rgb(255, 255, 255); box-shadow: rgb(170, 170, 170) 0px 0px 10px; box-sizing: border-box;\"><section style=\"margin-top: 10px; margin-bottom: 10px; text-align: left; position: static; box-sizing: border-box;\"><section style=\"display: inline-block; border: 2px solid rgb(105, 105, 105); padding: 0.1em 0.3em; color: rgb(105, 105, 105); box-sizing: border-box;\"><p style=\"margin: 0px; padding: 0px; box-sizing: border-box;\">六一儿童节</p></section></section><section style=\"font-size: 14px; color: rgb(105, 105, 105); box-sizing: border-box;\"><p style=\"white-space: normal; margin: 0px; padding: 0px; box-sizing: border-box;\">中央人民政府政务院第十二次政务会议于1949年12月23日通过了《全国年节及纪念日放假办法》，其中规定6月1日为儿童节，并将其列为“属于部分人民之节日。－－维基百科</p></section></section></section></section><section class=\"group-empty\" style=\"display: inline-block; vertical-align: top; width: 25%; padding: 0px; box-sizing: border-box; height: 1px;\"></section></section><section style=\"box-sizing: border-box;\"><p style=\"white-space: normal; margin: 0px; padding: 0px; box-sizing: border-box;\"><img src=\"http://lukehui.oss-cn-beijing.aliyuncs.com/web/upload/tmp/5c16f3b9-8de7-44af-ad61-8af752cc2043.jpeg\" title=\"upfile\" alt=\"upfile\" width=\"100%\" style=\"width: 702px; height: 708px;\" border=\"0\"/></p></section><section style=\"box-sizing: border-box;\"><p style=\"white-space: normal; margin: 0px; padding: 0px; box-sizing: border-box;\"><br/></p></section></section></section></section><p style=\"white-space: normal;\"><a href=\"app://initiative/jump?type=deepreadDeatil&id=1336\" target=\"_self\" style=\"font-size: 24px;\">精读班跳转测试</a></p><p style=\"white-space: normal;\"><a href=\"app://initiative/jump?type=ebookSerial&id=1380\" target=\"_self\" style=\"font-size: 24px;\">电子书跳转测试</a></p><p style=\"white-space: normal;\"><a href=\"app://initiative/jump?type=voiceserialdetail&id=1358\" target=\"_self\" style=\"font-size: 24px;\">有声书跳转测试</a></p><p style=\"white-space: normal;\"><a href=\"app://initiative/jump?type=voiceserialdetail&id=1367\" target=\"_self\" style=\"font-size: 24px;\">一书一课跳转测试</a></p><p style=\"white-space: normal;\"><a href=\"app://initiative/jump?type=voiceserialdetail&id=1250\" target=\"_self\" style=\"font-size: 24px;\">通识课跳转测试</a></p><p><br/></p>");
        Elements select = doc.select("[style]");
        Iterator<Element> iterator = select.iterator();
        while (iterator.hasNext()) {
            Element etemp = iterator.next();
            String styleStr = etemp.attr("style");
            if (styleStr.contains("background-image")) {
                System.out.println(styleStr);
                etemp.removeAttr("style");
                etemp.attr("style", cssStr(styleStr));
                String styleStr1 = etemp.attr("style");
                System.out.println(styleStr1);
            }
        }

        System.out.println(doc.body());

    }


}
