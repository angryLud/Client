package presentation.controller;

import businesslogic.userserviceimpl;
import businesslogicservice.loginservice;
import businesslogicservice.userservice;
import presentation.login.login;
import presentation.login.logincontroller;

/**
 * Created by huihantao on 2016/11/18.
 */
public class logincontrollerimpl implements logincontroller {
    private login view;
    private controller con;
    private loginservice logcon;


//useid
    public logincontrollerimpl(){
        logcon=new businesslogic.login();
    }

    @Override
    public boolean login(String id, char[] password) {
        return logcon.login(id,password);
    }

    @Override
    public void loginsuccess(String name) {
        con.loggedin( name);
    }

    @Override
    public void loginfail() {
        view.loginfail();
    }

    @Override
    public void setcon(controller con) {
        this.con=con;
    }

    @Override
    public void setview(login view) {
        this.view=view;
    }

    @Override
    public void signup() {
        con.signup();
    }

}
