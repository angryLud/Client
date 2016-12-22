package presentation.promotionui;

import presentation.controller.controller;

/**
 * Created by huihantao on 2016/12/22.
 */
public interface PromotionController {
    void back();

    void setcon(controller con);

    void setView(Promotion view);

    String getname();

    void gerenxinxi();

    void chexunjiudian();

    void chaxundingdan();
    
}
