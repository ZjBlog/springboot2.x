package spring.springboot2.zj;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.entity.Color;
import spring.springboot2.entity.RoleBot;
import spring.springboot2.entity.UserBot;
import spring.springboot2.repository.UserBotRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author : ZJ
 * @date : 18-10-15 下午2:08
 */
@Slf4j
@RestController
public class Test2Controller {

    @Autowired
    private UserBotRepository userJpa;


    @GetMapping("/v1/test1")
    public String test1() {

        Optional<UserBot> byId = userJpa.findById(8);

        if (byId.isPresent()) {
           log.info(byId.get().getId().toString());
            List<RoleBot> list = byId.get().getList();
            for (RoleBot roleBot : list) {
                log.info(roleBot.toString());
            }
        }
        return "ok";
    }

}
