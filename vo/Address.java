package vo;

import java.util.Vector;

/**
 * Created by huihantao on 2016/12/22.
 */
public class Address extends Vector<String>{
    public Address(){
        this.add("南京");
        this.add("北京");
        this.add("上海");
        this.add("西安");
    }
    public int getindex(String address){
        return this.indexOf((String)address);
    }
}
