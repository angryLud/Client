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
		try {
			hpo = RemoteHelper.getInstance().getHoteldataservice().findhotelbyid(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override

	public boolean updateHotel(HotelPo po) {
			try {
				return RemoteHelper.getInstance().getHoteldataservice().hotelupdate(po);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		return false;
	}

	

	@Override
	public int getDachuangfangjiage() {
		// TODO Auto-generated method stub
		return hpo.getDachaungfangprice();
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return hpo.getAddress();
	}

	@Override
	public String getPosition() {
		// TODO Auto-generated method stub
		return hpo.getPosition();
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return hpo.getDescription();
	}

	@Override
	public int getShuangrenfangprice() {
		// TODO Auto-generated method stub
		return hpo.getShuangrenfangprice();
	}

	@Override
	public int getSanrenjianprice() {
		// TODO Auto-generated method stub
		return hpo.getSanrenjianprice();
	}

	@Override
	public int getStar() {
		// TODO Auto-generated method stub
		return hpo.getStar();
	}
	

}
