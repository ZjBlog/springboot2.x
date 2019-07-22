package spring.springboot2.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author : ZJ
 * @date : 19-7-18 下午3:26
 */
@Data
@Table(name = "Scores")
@Entity
public class Scores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Score")
    private BigDecimal Score;
}
