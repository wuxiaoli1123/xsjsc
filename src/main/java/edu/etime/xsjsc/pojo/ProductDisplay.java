package edu.etime.xsjsc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 吴小莉
 * @date 2020-07-09 09:53
 * @ Description：商品统计实体类
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProductDisplay {

    private String id;

    private String name;

    private Double price;

    private Integer totalnumber;

}
