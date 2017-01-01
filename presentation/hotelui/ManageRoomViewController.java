package presentation.hotelui;

import po.HotelPo;
import presentation.controller.controller;

public interface ManageRoomViewController {
	public void setcon(controller con);
	
	public void setView(ManageRoomView view);
	
	public void ExitButtonClicked();
	
	public boolean updateHotel(HotelPo po);
  
    public void refresh();

	public int getHotelID();

	public String getHotelName();

	public int getAvdachuangfang();

	public int getDachaungfangprice();

	public int getAvshuangrenfang();

	public int getShuangrenfangprice();

	public int getAvsanrenjian();

	public int getSanrenjianprice();
}
