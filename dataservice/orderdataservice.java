package dataservice;


import po.OrderPo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface orderdataservice extends Remote {
	int orderinsert(OrderPo opo) throws RemoteException;
	boolean orderupdate(OrderPo opo) throws RemoteException;
	OrderPo orderfind(int orderid) throws RemoteException;
	List<OrderPo> findorderbyuserid(int userid) throws RemoteException;
	List<OrderPo> findorderbyhotelid(int hotelid) throws RemoteException;

}
