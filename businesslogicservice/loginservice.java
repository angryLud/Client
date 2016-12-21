package businesslogicservice;


import java.rmi.RemoteException;

/**
 * Created by huihantao on 2016/12/13.
 */
public interface loginservice  {
    boolean login(String id,char[] password);

    void logout(int id);
}
