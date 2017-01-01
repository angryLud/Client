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

public SearchHotelControllerimpl(int userId){
	userso = new userserviceimpl(userId);
	this.userId = userId;
	
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
		return userId;
	}
	public List<HotelVo> getAllHotels(int userid){
		// TODO Auto-generated method stub
		return userso.getAllHotels(userid);
	}
	@Override
	public void ExitButtonClicked() {
		// TODO Auto-generated method stub
		con.loggedin(userId+"");
	}
	@Override
	public void reservehotel() {
		// TODO Auto-generated method stub
		View.reservehotel();
	}

	@Override
	public int getcredit() {
		// TODO Auto-generated method stub
		return userso.getcredit();
	}
	@Override
	public void setcon(controller con) {
		// TODO Auto-generated method stub
		this.con=con;
	}

	@Override
	public int createorder(int orderid,int userid,int hotelid,int intnowtime,long s5,long s7,long s6,int status,String s1,int s2) {
		// TODO Auto-generated method stub
		OrderVo ovo = new OrderVo(orderid,userid,hotelid,intnowtime,s5,s7,s6,0,status,s1,s2);
		
		return userso.createorder(ovo);
		
	}
	@Override
	public String getname() {
		// TODO Auto-generated method stub
		return userso.getname();
	}
	@Override
	public void creatpo(int selectedhotelid) {
		// TODO Auto-generated method stub
		userso.creathotelpo(selectedhotelid);
	}
	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return userso.getAddress();
	}
	@Override
	public String getPosition() {
		// TODO Auto-generated method stub
		return userso.getPosition();
	}
	@Override
	public int getDachuangfangprice() {
		// TODO Auto-generated method stub
		return userso.getDachuangfangprice();
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return userso.getDescription();
	}
	@Override
	public int getShuangrenfangprice() {
		// TODO Auto-generated method stub
		return userso.getShuangrenfangprice();
	}
	@Override
	public int getSanrenjianprice() {
		// TODO Auto-generated method stub
		return userso.getSanrenjianprice();
	}
	@Override
	public int getStar() {
		// TODO Auto-generated method stub
		return userso.getStar();
	}
	@Override
	public boolean isreserved(int selectedhotelid,int userId) {
		// TODO Auto-generated method stub
		return userso.isreserved(selectedhotelid,userId);
	}

}
