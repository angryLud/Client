package presentation.controller;


import businesslogic.PromotionServiceImpl;
import businesslogicservice.PromotionService;
import presentation.promotionui.Promotion;
import presentation.promotionui.PromotionController;

import java.util.Date;

/**
 * Created by huihantao on 2016/12/22.
 */
public class PromotionControllerimpl implements PromotionController {
    private controller con;
    private Promotion view;
    private int id;
    private PromotionService proser;

    public PromotionControllerimpl(int id){
        proser=new PromotionServiceImpl(new Date());
        this.id=id;
    }

    @Override
    public void back() {
        con.login();
        proser.logout(id);
    }

    @Override
    public void setcon(controller con) {
        this.con=con;
    }

    @Override
    public void setView(Promotion view) {
        this.view=view;
    }

    @Override
    public String getname() {
        return  proser.getname();
    }

    @Override
    public void gerenxinxi() {
        con.cuxiaocelue();
    }

    @Override
    public void chexunjiudian() {
        con.xinyongchongzhi();
    }

    @Override
    public void chaxundingdan() {
        con.liulandingdan();
    }


}
