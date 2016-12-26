package businesslogicservice;

import po.HotelPo;

public interface HotelService {
	public boolean updateHotel(HotelPo po);

	public int getDachuangfangjiage();

	public String getAddress();

	public String getPosition();

	public String getDescription();

	public int getShuangrenfangprice();

	public int getSanrenjianprice();

	public int getStar();

	
	

}
