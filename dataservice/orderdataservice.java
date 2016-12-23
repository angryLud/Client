package dataservice;


import po.OrderPo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface orderdataservice extends Remote {
	int orderinsert(OrderPo opo) throws RemoteException;
	boolean orderupdate(OrderPo opo) throws RemoteException;
	OrderPo orderfind(int orderid) throws RemoteException;
	ArrayList<OrderPo> findorderbyuserid(int userid) throws RemoteException;
	ArrayList<OrderPo> findorderbyhotelid(int hotelid) throws RemoteException;

}
