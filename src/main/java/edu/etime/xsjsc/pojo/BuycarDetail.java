package edu.etime.xsjsc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 吴小莉
 * @date 2020-07-08 14:27
 * @ Description：返回前端的购物车详情
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class BuycarDetail {

      private String id;

      private String name;

      private Double price;

      private Integer stock;

      private Integer number;

      private Integer addnumber;

      private String fields2;



}
