package po;

import java.io.Serializable;

/**
 * Created by huihantao on 2016/12/24.
 */
public class PromotionerPo implements Serializable{


    String name;
    int id;
    public PromotionerPo(int id, String name) {
        this.id=id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
