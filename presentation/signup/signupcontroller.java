package presentation.signup;

import presentation.controller.controller;

/**
 * Created by huihantao on 2016/11/18.
 */
public interface signupcontroller {
    void setcon(controller con);
    void setview(signup view);
    void back();

    boolean uservalidate(String name,char[] password,char[] passwordconfirm,String number);
    void signupfail();

    int signup(String name, char[] password, String number);
}
