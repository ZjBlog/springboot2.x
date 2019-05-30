package spring.springboot2.zj;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * @author : ZJ
 * @date : 18-10-15 下午2:08
 */
public class Test2Controller {

    public static void main(String[] args) {
        try {
            File input=new File("/home/zj/tmp/test.html");
            Document doc = Jsoup.parse(input, "UTF-8");
            Elements focusList = doc.getElementsByClass("focusList");
            Elements li = focusList.get(0).getElementsByTag("li");
            for (Element element : li) {
                System.out.println(element.attr(""));
                System.out.println(element.text());
                System.out.println(element.html());
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
