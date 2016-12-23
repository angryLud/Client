package businesslogic;

import java.rmi.RemoteException;

import businesslogicservice.HotelService;
import dataservice.hoteldataservice;
import po.HotelPo;
import rmi.RemoteHelper;

public class HotelServiceImpl implements HotelService{
	
	private int hotelID;
	
	private hoteldataservice hoteldataservice;
	private HotelPo hpo;
	
	public HotelServiceImpl(int hotelID){
		this.hotelID = hotelID;
		hoteldataservice = RemoteHelper.getInstance().getHoteldataservice();
	}

	@Override

	public boolean updateHotel(int hotelID) {
		hpo.setHotelName("aef");
		try {
//			po = hoteldataservice.findhotelbyid(hotelID);
//			if(hoteldataservice.update(po)){
//				return true;
//			}
			
			return RemoteHelper.getInstance().getHoteldataservice().update(hpo);
			} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
