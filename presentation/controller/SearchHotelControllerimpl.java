package presentation.controller;

import java.util.ArrayList;
import java.util.List;

import businesslogic.userserviceimpl;
import businesslogicservice.userservice;
import presentation.userui.SearchHotel;
import presentation.userui.SearchHotelController;
import vo.HotelVo;
import vo.OrderVo;

public class SearchHotelControllerimpl implements SearchHotelController{

	private userservice userso;
	private SearchHotel View;
	private int userId;
	private controller con;

public SearchHotelControllerimpl(){
	userso = new userserviceimpl(userId);
	
}
	public void cancel() {
		// TODO Auto-generated method stub
		
	}
	public void setview(SearchHotel view) {
		// TODO Auto-generated method stub
		this.View = view;
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
	@Override
	public void usersearchhotel(String s1,String s2,String s3,String s4) {
		// TODO Auto-generated method stub
//		View=new SearchHotel(this);
//		System.out.println(userso.usersearchhotel(s1,s2,s3,s4).elementAt(0).getHotelName());
		System.out.println("shit");
		View.createtable(userso.usersearchhotel(s1,s2,s3,s4));
	}

	@Override
	public void setcon(controller controller) {
		this.con=con;
	}
}
