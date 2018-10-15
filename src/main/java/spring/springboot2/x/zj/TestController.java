package spring.springboot2.x.zj;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : ZJ
 * @date : 18-10-15 下午2:00
 */
@RestController
public class TestController {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://www.pangmao.tv/view/index8207.html").get();

            System.out.println(doc.toString());
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
