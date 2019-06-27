package spring.springboot2.zj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.entity.Color;
import spring.springboot2.entity.UserBot;
import spring.springboot2.exercise.zeren.ZeRenService;
import spring.springboot2.repository.UserBotRepository;
import spring.springboot2.service.RabbitSender;
import spring.springboot2.service.RabbitSender1;
import spring.springboot2.service.TransactionalService;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : ZJ
 * @date : 18-10-15 下午2:00
 */
@RestController
public class TestController {


    @Autowired
    private RabbitSender1 rabbitSender1;

    @Autowired
    private RabbitSender rabbitSender;

    @Autowired
    private ZeRenService zeRenService;

    @Autowired
    private UserBotRepository userBotRepository;

    @Autowired
    private TransactionalService transactionalService;

    @Autowired
    private UserBotRepository userJpa;

    @Autowired
    private EntityManager entityManager;


    @GetMapping("/test1")
    public String test1() {
        UserBot userBot = new UserBot();
        userBot.setId(1);
        userBot.setReadIs("dddd");
        rabbitSender1.sendMsg(userBot);
        rabbitSender.sendMsg("test");
        return "ok";
    }

    @GetMapping("/test")
    public String test() {
        zeRenService.cal("duration");
        return "ok";
    }

    @GetMapping("/test2")
    public Object test2() {
        return userBotRepository.findAll();
    }

    @GetMapping("/test3")
    public Object test3() {
        UserBot userBot = new UserBot();
        userBot.setReadIs("dddd");
        userBot.setColor(Color.BLUE);
        userBot = userBotRepository.save(userBot);
        return userBot;
    }

    @GetMapping("/test4")
    public Object test4() {
        try {
            transactionalService.testSysConfig2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }


    @GetMapping("/test5")
    public Object test5() {
        List<UserBot> all = userJpa.findAll((Specification<UserBot>) (root, query, criteriaBuilder) -> {
            /**
             * root.get("readIs")表示获取readIs这个字段名称,like表示执行like查询,%z%表示值
             * 将两个查询条件联合起来之后返回Predicate对象
             */
            Predicate p1 = criteriaBuilder.like(root.get("readIs"), "%z%");
            Predicate p2 = criteriaBuilder.greaterThan(root.get("id"), 3);

            return criteriaBuilder.and(p1, p2);
        });


        /**
         * 第一个Specification定义了两个or的组合
         */
        Specification<UserBot> s1 = (Specification<UserBot>) (root, query, criteriaBuilder) -> {
            Predicate p1 = criteriaBuilder.equal(root.get("id"), "7");
            Predicate p2 = criteriaBuilder.equal(root.get("id"), "3");
            return criteriaBuilder.or(p1, p2);
        };

        /**
         * 第二个Specification定义了两个or的组合
         */
        Specification<UserBot> s2 = (Specification<UserBot>) (root, query, criteriaBuilder) -> {
            Predicate p1 = criteriaBuilder.like(root.get("readIs"), "j%");
            Predicate p2 = criteriaBuilder.like(root.get("readIs"), "Z%");

            return criteriaBuilder.or(p1, p2);
        };


        /**
         * 通过Specifications将两个Specification连接起来，第一个条件加where，第二个是and
         */
        List all1 = userBotRepository.findAll(Specification.where(s1).and(s2));


        return all1;
    }


    @GetMapping("/test6")
    public Object test6() {

        //创建CriteriaBuilder安全查询工厂
        //CriteriaBuilder是一个工厂对象,安全查询的开始.用于构建JPA安全查询.
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //创建CriteriaQuery安全查询主语句
        //CriteriaQuery对象必须在实体类型或嵌入式类型上的Criteria 查询上起作用。
        CriteriaQuery<UserBot> query = criteriaBuilder.createQuery(UserBot.class);
        //Root 定义查询的From子句中能出现的类型
        Root<UserBot> itemRoot = query.from(UserBot.class);
        //Predicate 过滤条件 构建where字句可能的各种条件
        //这里用List存放多种查询条件,实现动态查询
        List<Predicate> predicatesList = new ArrayList<>();
        //name模糊查询 ,like语句

        predicatesList.add(
                criteriaBuilder.and(
                        criteriaBuilder.like(
                                itemRoot.get("readIs"), "%" + "z" + "%")));

        // itemPrice 小于等于 <= 语句
        predicatesList.add(
                criteriaBuilder.and(
                        criteriaBuilder.le(
                                itemRoot.get("id"), 9)));
        //itemStock 大于等于 >= 语句
        predicatesList.add(
                criteriaBuilder.and(
                        criteriaBuilder.ge(
                                itemRoot.get("id"), 0)));

        //where()拼接查询条件
        query.where(predicatesList.toArray(new Predicate[predicatesList.size()]));
        query.groupBy(itemRoot.get("id"));

        TypedQuery<UserBot> typedQuery = entityManager.createQuery(query);

        List<UserBot> resultList = typedQuery.getResultList();
        return "ok";
    }

    @GetMapping("/test7")
    public Object test7() {

        Sort sort = new Sort(Sort.Direction.DESC,"id");
        int page = 0;
        int pageSize = 5;
        /**
         * 如果没有查询条件呢？即Predicate为null，CriteriaBuilder同样提供了两个方法conjunction()和disjunction()。
         * cb.conjunction where 1=1
         *  cb.disjunction where 0=1
         */
        Pageable pageable = PageRequest.of(page,pageSize,sort);
        Specification<UserBot> specification = (Specification<UserBot>) (root, query, cb) -> cb.disjunction();
        Page<UserBot> userPage = userBotRepository.findAll(specification,  pageable);
        return userPage;
    }

}
