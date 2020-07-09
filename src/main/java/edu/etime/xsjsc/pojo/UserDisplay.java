package edu.etime.xsjsc.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserDisplay {

    private String productid;

    private String typeid;

    private String typename;

    private String productnum;

}
