package edu.etime.xsjsc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Result {
    private Boolean state = true;
    private String msg;

   /* public Boolean getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }*/
}
