package businesslogicservice;

import po.HotelPo;

public interface HotelService {
	public boolean updateHotel(int hotelID);
	
	public HotelPo getHotel(int hotelID);

}
