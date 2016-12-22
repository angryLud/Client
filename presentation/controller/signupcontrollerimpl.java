package presentation.controller;

import businesslogic.login;
import businesslogic.userserviceimpl;
import businesslogicservice.loginservice;
import businesslogicservice.userservice;
import presentation.signup.signup;
import presentation.signup.signupcontroller;
import vo.UserVo;

/**
 * Created by huihantao on 2016/11/18.
 */
public class signupcontrollerimpl implements signupcontroller {
    private signup view;
    private controller con;
    private loginservice logser;
    private userservice userser;

    public signupcontrollerimpl(){
        logser=new login();
    }

    @Override
    public void setcon(controller con) {
        this.con=con;
    }

    @Override
    public void setview(signup view) {
        this.view=view;
    }

    @Override
    public void back() {
        con.login();
    }





    @Override
    public boolean uservalidate(String name,char[] password,char[] passwordconfirm,String number) {


        if(name==null) return false;
        if(password==null) return false;
        if(passwordconfirm==null) return false;
        if(number==null) return false;


        if(number.length()!=11) return false;
        for(int i=0;i<number.length();i++){
            if ((int) number.charAt(i) <48) return false;
            if ((int) number.charAt(i) >57) return false;
        }
        if (password.length!=passwordconfirm.length) return  false;
        for(int i=0;i<password.length;i++){
            if (password[i]!=passwordconfirm[i]) return false;
            if ((int)password[i]>126) return false;
            if ((int)password[i]<32) return false;

        }


        
        return true;
    }



    @Override
    public void signupfail() {
        view.signupfail();
    }

    @Override
    public int signup(String name, char[] password, String number) {
        userser.insert(name,number,password);
        return 0;
    }
}
