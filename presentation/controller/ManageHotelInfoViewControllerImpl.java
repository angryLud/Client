package presentation.controller;

import businesslogic.HotelServiceImpl;
import businesslogicservice.HotelService;
import po.HotelPo;
import presentation.hotelui.ManageHotelInfoView;
import presentation.hotelui.ManageHotelInfoViewController;
import presentation.hotelui.ManageRoomView;

public class ManageHotelInfoViewControllerImpl implements ManageHotelInfoViewController{
	
    private ManageHotelInfoView view;
    
    private HotelService hotelservice;
    
    private controller con;
	
	public int HotelID;
	
	public ManageHotelInfoViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
		hotelservice = new HotelServiceImpl(HotelID);
	}
	
	
	@Override
	public void setView(ManageHotelInfoView view) {
	    this.view = view;
		
	}
	
	@Override
	public void ModifyButtonClicked() {
		view.ModifyButtonClicked();
		
	}

	@Override
	public void ConfirmButtonClicked() {
		view.ConfirmButtonClicked();
		
	}


	@Override
	public void ExitButtonClicked() {
		con.loggedin(HotelID+"");
		
	}


	@Override
	public void setcon(controller con) {
		this.con = con;
		
	}


	@Override
	public boolean updateHotel(HotelPo po) {
		return hotelservice.updateHotel(po);
//		return false;
	}
	
	public void refresh(){
		con.ManageHotelInfo();
	}


	@Override
	public int getDachuangfangjiage() {
		// TODO Auto-generated method stub
		return hotelservice.getDachuangfangjiage();
	}


	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return hotelservice.getAddress();
	}


	@Override
	public String getPosition() {
		// TODO Auto-generated method stub
		return hotelservice.getPosition();
	}


	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return hotelservice.getDescription();
	}


	@Override
	public int getShuangrenfangprice() {
		// TODO Auto-generated method stub
		return hotelservice.getShuangrenfangprice();
	}


	@Override
	public int getSanrenjianprice() {
		// TODO Auto-generated method stub
		return hotelservice.getSanrenjianprice();
	}


	@Override
	public int getStar() {
		// TODO Auto-generated method stub
		return hotelservice.getStar();
	}

	

}
