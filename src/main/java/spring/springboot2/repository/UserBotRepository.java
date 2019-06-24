package spring.springboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.springboot2.entity.UserBot;

/**
 * @author : ZJ
 * @date : 19-6-21 下午3:58
 */
public interface UserBotRepository extends JpaRepository<UserBot,Integer> {
}
