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
			
			try {
				hpo = hoteldataservice.findhotelbyid(hotelID);
				return RemoteHelper.getInstance().getHoteldataservice().hotelupdate(hpo);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		return false;
	}

	@Override
	public HotelPo getHotel(int hotelID) {
		try {
			hpo = hoteldataservice.findhotelbyid(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hpo;
	}
	

}
