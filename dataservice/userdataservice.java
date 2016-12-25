package dataservice;

import po.UserPo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface userdataservice extends Remote {
	int userinsert(UserPo upo, char[] password) throws RemoteException;
	boolean userupdate(UserPo upo) throws RemoteException;
	UserPo userfind(int id) throws RemoteException;
}
