package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by huihantao on 2016/12/17.
 */
public interface logindataservice extends Remote{
    boolean login(String id, char[] password) throws RemoteException;

    void logout(int id) throws RemoteException;


}
