package presentation.hotelui;

import po.HotelPo;
import presentation.controller.controller;

public interface ManageHotelInfoViewController {
	public void ModifyButtonClicked();
	
	public void ConfirmButtonClicked();
	
	public void ExitButtonClicked();
	
	public void setView(ManageHotelInfoView view);
	
	public void setcon(controller con);
	
	public boolean updateHotel(HotelPo po);
	
	public void refresh();

	public int getDachuangfangjiage();

	public String getAddress();

	public String getPosition();

	public String getDescription();

	public int getShuangrenfangprice();

	public int getSanrenjianprice();

	public int getStar();
}
