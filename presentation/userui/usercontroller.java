package presentation.userui;

import presentation.controller.controller;

/**
 * Created by huihantao on 2016/11/20.
 */
public interface usercontroller {
    void back();
    void setcon(controller con);
    void setView(user view);
    String getname();

    void gerenxinxi();

    void chexunjiudian();
}
