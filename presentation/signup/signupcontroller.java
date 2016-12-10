package presentation.signup;

import presentation.controller.controller;

/**
 * Created by huihantao on 2016/11/18.
 */
public interface signupcontroller {
    void signup(String type);
    void setcon(controller con);
    void setview(signup view);
    void back();
    void signupuser();
    void signuphotel();
    boolean uservalidate(String name,char[] password,char[] passwordconfirm,String number);
    boolean hotelvalidate();
    void signupfail();
}
