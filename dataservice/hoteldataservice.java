package dataservice;

import po.HotelPo;
import po.OrderPo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by huihantao on 2016/12/20.
 */
public interface hoteldataservice extends Remote {
    List<HotelPo> usergethotellist (int userid) throws RemoteException;
    
    int hotelinsert(HotelPo hpo) throws RemoteException;
    
	boolean hotelupdate(HotelPo hpo) throws RemoteException;
	
	HotelPo findhotelbyid(int hotelID) throws RemoteException;
    
}
