package dataservice;

import po.HotelPo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by huihantao on 2016/12/20.
 */
public interface hoteldataservice extends Remote {
    List<HotelPo> usergethotellist(int userid) throws RemoteException;
    
    List<HotelPo> getallhotellist() throws RemoteException;
    
    int hotelinsert(HotelPo hpo, char[] password) throws RemoteException;

    
	boolean hotelupdate(HotelPo hpo) throws RemoteException;
	
	HotelPo findhotelbyid(int hotelID) throws RemoteException;
    
}
