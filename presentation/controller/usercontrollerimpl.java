package presentation.controller;

import presentation.userui.usercontroller;

/**
 * Created by huihantao on 2016/11/20.
 */
public class usercontrollerimpl implements usercontroller {
    private controller con;

    @Override
    public void back() {
        con.login();
    }

    @Override
    public void setcon(controller con) {
        this.con=con;
    }

}
