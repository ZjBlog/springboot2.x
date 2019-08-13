package spring.springboot2.zj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.springboot2.config.WxTest;
import spring.springboot2.service.ThymeleafService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloWorld {


    @Autowired
    private WxTest wxTest;


    @Autowired
    ThymeleafService thymeleafService;

    @Value(value = "${username}")
    private String name;


    @GetMapping("/")
    public String HellorWorld() {
        return "Hello World 1Spring boot2.x for" + name + "===" + wxTest;
    }

    /**
     *负载均衡配置时的2个参数：fail_timeout和max_fails
     *
     *    这2个参数一起配合，来控制nginx怎样认为upstream中的某个server是失效的当在fail_timeout的时间内，某个server连接失败了max_fails次，则nginx会认为该server不工作了。同时，在接下来的 fail_timeout时间内，nginx不再将请求分发给失效的server。
     * 个人认为，nginx不应该把这2个时间用同一个参数fail_timeout来控制，要是能再增加一个fail_time，来控制接下来的多长时间内，不再使用down掉的server就更好了~
     * 如果不设置这2个参数，fail_timeout默认为10s，max_fails默认为1。就是说，只要某个server失效一次，则在接下来的10s内，就不会分发请求到该server上
     * 负载均衡配置时的2个参数：fail_timeout和max_fails
     *
     *
     * location / {
     *             proxy_pass http://report;
     * 			index  index.html index.htm;
     * 			# proxy_next_upstream
     * 			proxy_next_upstream error timeout invalid_header http_500 http_503 http_404;
     * 			proxy_connect_timeout 20s;
     * 			proxy_read_timeout 20s;
     * 			proxy_send_timeout 20s;
     *         }
     *  upstream report{
     *          server localhost1:18080 max_fails=10 fail_timeout=60s;
     *          server localhost1:28080 max_fails=10 fail_timeout=60s;
     *         server localhost2:18080 max_fails=10 fail_timeout=60s;
     *         server localhost2:28080 max_fails=10 fail_timeout=60s;
     *         #ip_hash;
     *         #weight 10
     *     }
     *    这2个参数一起配合，来控制nginx怎样认为upstream中的某个server是失效的当在fail_timeout的时间内，某个server连接失败了max_fails次，则nginx会认为该server不工作了。同时，在接下来的 fail_timeout时间内，nginx不再将请求分发给失效的server。
     * 个人认为，nginx不应该把这2个时间用同一个参数fail_timeout来控制，要是能再增加一个fail_time，来控制接下来的多长时间内，不再使用down掉的server就更好了~
     * 如果不设置这2个参数，fail_timeout默认为10s，max_fails默认为1。就是说，只要某个server失效一次，则在接下来的10s内，就不会分发请求到该server上
     *
     *
     * none : 允许没有http_refer的请求访问资源；
     * blocked : 允许不是http://开头的，不带协议的请求访问资源；
     * 119.28.190.215 : 只允许指定ip来的请求访问资源；
     * location ~ .*\.(jpg|gif|png)$ {
     *     valid_referers none blocked 119.28.190.215 http://www.itcats.cn www.itcats.cn;
     *     if ($invalid_referer) {
     *         return 403;
     *     }
     *     root  /opt/app/code/images;
     * }
     * $request_uri $uri
     * 		location ~ \.html$ {
     * 		    root html;
     * 		    index index.html;
     * 		    try_files $request_uri @fight;
     *                }
     *
     * 		location @fight {
     * 		    proxy_pass http://localhost:8080;
     * 		    proxy_connect_timeout 10;
     * 		    proxy_set_header Host $host;
     * 		    proxy_set_header X-Real-IP $remote_addr;
     * 		    proxy_set_header REMOTE-HOST $remote_addr;
     * 		    proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
     *        }
     * @param id
     * @param response
     */
    @GetMapping("/{id}.html")
    public void HellorWorld11(@PathVariable("id") Integer id, HttpServletResponse response) {
//http://www.glxxw2018.com/study/blog/detail/ag6Gf13MuC.html
        thymeleafService.createHtml(Long.valueOf(id));
        response.setStatus(302);
        response.setHeader("Location", "http://127.0.0.1/"+id+".html");
    }
}
