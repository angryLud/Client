package presentation.controller;

import java.util.List;

import businesslogic.userserviceimpl;
import businesslogicservice.userservice;
import presentation.userui.SearchHotel;
import presentation.userui.SearchHotelController;
import vo.HotelVo;
import vo.OrderVo;

public class SearchHotelControllerimpl implements SearchHotelController{

	private userservice userso;
	private SearchHotel view;
	private int userId;

public SearchHotelControllerimpl(){
	userso = new userserviceimpl(userId);
	
}
	public void cancel() {
		// TODO Auto-generated method stub
		
	}
	public void setview(SearchHotel view) {
		// TODO Auto-generated method stub
		this.view = view;
	}
	@Override
	public int getUserID() {
		// TODO Auto-generated method stub
		return 0;
	}
	public List<HotelVo> getAllHotels(int userId){
		// TODO Auto-generated method stub
		return userso.getAllHotels(userId);
	}
}