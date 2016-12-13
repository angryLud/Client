package presentation.controller;

import presentation.hotelui.mainframecontroller;

/**
 * Created by huihantao on 2016/12/13.
 */
public class hotelcontroller implements mainframecontroller {
    private controller con;
    @Override
    public void signout() {
        con.login();
    }

    @Override
    public void setcon(controller con) {
        this.con=con;
    }
}
