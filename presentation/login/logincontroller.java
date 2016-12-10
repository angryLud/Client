package presentation.login;

import presentation.controller.controller;

/**
 * Created by huihantao on 2016/11/18.
 */
public interface logincontroller {
    public boolean login(String name,char[] password);
    public void loginsuccess(String name);
    public void loginfail();
    public void setcon(controller con);
    public void setview(login view);
    public void signup();

}
