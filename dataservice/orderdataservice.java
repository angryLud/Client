package dataservice;


import po.OrderPo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface orderdataservice extends Remote {
	boolean insert(OrderPo opo) throws RemoteException;
	boolean update(OrderPo opo) throws RemoteException ;
	OrderPo find(int orderid) throws RemoteException;
	ArrayList<OrderPo> findbyuserid(int userid) throws RemoteException;
	ArrayList<OrderPo> findbyhotelid(int hotelid) throws RemoteException;

}
