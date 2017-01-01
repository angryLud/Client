package presentation.controller;

import businesslogic.HotelServiceImpl;
import businesslogicservice.HotelService;
import po.HotelPo;
import presentation.hotelui.ManageRoomView;
import presentation.hotelui.ManageRoomViewController;

public class ManageRoomViewControllerImpl implements ManageRoomViewController{
	
	private int HotelID;
	
	private ManageRoomView view;
	
	private controller con;
	
	private HotelService hotelservice;
	
	public ManageRoomViewControllerImpl(int HotelID){
		this.HotelID = HotelID;
		hotelservice = new HotelServiceImpl(HotelID);
	}

	@Override
	public void setView(ManageRoomView view) {
		this.view = view;
		
	}

	@Override
	public void ExitButtonClicked() {
		con.loggedin(HotelID+"");
	}

	@Override
	public void setcon(controller con) {

		this.con = con;
		
	}
	
	public void refresh(){
		con.ManageRoom();
	}


	@Override
	public boolean updateHotel(HotelPo po) {
		// TODO Auto-generated method stub
		return hotelservice.updateHotel(po);
	}

	@Override
	public int getHotelID() {
		// TODO Auto-generated method stub
		return hotelservice.getHotelID();
	}

	@Override
	public String getHotelName() {
		// TODO Auto-generated method stub
		return hotelservice.getHotelName();
	}

	@Override
	public int getAvdachuangfang() {
		// TODO Auto-generated method stub
		return hotelservice.getAvdachuangfang();
	}

	@Override
	public int getDachaungfangprice() {
		// TODO Auto-generated method stub
		return hotelservice.getDachuangfangjiage();
	}

	@Override
	public int getAvshuangrenfang() {
		// TODO Auto-generated method stub
		return hotelservice.getAvshuangrenfang();
	}

	@Override
	public int getShuangrenfangprice() {
		// TODO Auto-generated method stub
		return hotelservice.getShuangrenfangprice();
	}

	@Override
	public int getAvsanrenjian() {
		// TODO Auto-generated method stub
		return hotelservice.getAvsanrenjian();
	}

	@Override
	public int getSanrenjianprice() {
		// TODO Auto-generated method stub
		return hotelservice.getSanrenjianprice();
	}
	
	
}
