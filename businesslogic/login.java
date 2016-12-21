package businesslogic;

import businesslogicservice.loginservice;
import rmi.RemoteHelper;

import java.rmi.RemoteException;

/**
 * Created by huihantao on 2016/12/13.
 */
public class login implements loginservice {
    @Override
    public boolean login(String id, char[] password) {
        try {
            return RemoteHelper.getInstance().getloginservice().login(id,password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return true;

//        if (id.equals("abc")) return false;
//        return  true;
    }

    @Override
    public void logout(int id) {
//        try {
//            RemoteHelper.getInstance().getloginservice().logout(id);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
    }
}
