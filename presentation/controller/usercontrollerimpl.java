package presentation.controller;

import businesslogic.userserviceimpl;
import businesslogicservice.userservice;
import presentation.userui.user;
import presentation.userui.usercontroller;

/**
 * Created by huihantao on 2016/11/20.
 */
public class usercontrollerimpl implements usercontroller {
    private controller con;
    private user view;
    private userservice usv;
    private int userid;

    public usercontrollerimpl(int userid){
        this.userid=userid;
        usv=new userserviceimpl(userid);
    }

    @Override
    public void back() {
        con.login();
        usv.logout(userid);
    }

    @Override
    public void setcon(controller con) {
        this.con=con;
    }

    @Override
    public void setView(user view) {
        this.view=view;
    }

    @Override
    public String getname() {
        return  usv.getname();
    }

    @Override
    public void gerenxinxi() {
        con.gerenxinxi(userid);
    }

}
