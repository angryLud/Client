package presentation.controller;

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

    @Override
    public void back() {
        con.login();
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
    public String getname(int userid) {
        return  usv.getname();
    }

}
