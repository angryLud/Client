package vo;

import java.util.Vector;

/**
 * Created by huihantao on 2016/12/22.
 */
public class shangquan extends Vector<String> {
   public  shangquan(String address){
        switch (new Address().getindex(address)) {
            case 0:{
                this.add("鼓楼");
                this.add("仙林");
                this.add("浦口");
                this.add("玄武");
                break;
            }
            case 1:{
                this.add("朝阳");
                this.add("海淀");
                this.add("东城");
                this.add("西城");
                break;
            }

            case 2:{
                this.add("嘉定");
                this.add("浦东");
                this.add("金山");
                this.add("松江");
                break;
            }

            case 3:{
                this.add("碑林");
                this.add("长安");
                this.add("雁塔");
                this.add("未央");
                break;
            }
            default: break;


        }
    }
}
