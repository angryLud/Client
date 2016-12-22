package businesslogic;

import java.rmi.RemoteException;

import businesslogicservice.HotelService;
import dataservice.hoteldataservice;
import po.HotelPo;
import rmi.RemoteHelper;

public class HotelServiceImpl implements HotelService{
	
	private int hotelID;
	
	private hoteldataservice hoteldataservice;
	
	public HotelServiceImpl(int hotelID){
		this.hotelID = hotelID;
		hoteldataservice = RemoteHelper.getInstance().getHoteldataservice();
	}

	@Override

	public boolean updateHotel(int hotelID) {
		HotelPo po = new HotelPo(1,"仙林","英尊",188,288,328,4,4.6,"商圈：XXXX\n地址：XXXXX\n服务设施：停车场丶wifi等\n房间价格：XXXXX\n");
		try {
			po = hoteldataservice.findhotelbyid(hotelID);
			if(hoteldataservice.update(po)){
				return true;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
