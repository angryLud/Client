package presentation.controller;

import java.util.List;


import businesslogic.userserviceimpl;
import businesslogicservice.userservice;
import presentation.userui.UserSearchOrder;
import presentation.userui.UserSearchOrderCotroller;
import vo.HotelVo;
import vo.OrderVo;
import vo.UserVo;


public class UserSearchOrderCotrollerimpl implements UserSearchOrderCotroller {
	private userservice userso;
	private UserSearchOrder view;
	private int userId;
	private controller con;

public UserSearchOrderCotrollerimpl(int userId){
	userso = new userserviceimpl(userId);
	this.userId = userId;
	
}
	public void setview(UserSearchOrder view) {
		// TODO Auto-generated method stub
		this.view = view;
	}
	public int getUserID() {
		// TODO Auto-generated method stub
		return 0;
	}
	public List<OrderVo> getAllOrders(int userId){
		// TODO Auto-generated method stub
		return userso.getAllOrders(userId);
	}
	public List<OrderVo> getUnfinishedOrders(int userId){
		// TODO Auto-generated method stub
		return userso.getUnfinishedOrders(userId);
	}
	public List<OrderVo> getFinishedOrders(int userId){
		// TODO Auto-generated method stub
		return userso.getFinishedOrders(userId);
	}
	public List<OrderVo> getAbnormalOrders(int userId){
		// TODO Auto-generated method stub
		return userso.getAbnormalOrders(userId);
	}
	public List<OrderVo> getCancelOrders(int userId){
		// TODO Auto-generated method stub
		return userso.getCancelOrders(userId);
	}

	@Override
	public void setcon(controller con) {
		this.con=con;
	}
	@Override
	public void ExitButtonClicked() {
		// TODO Auto-generated method stub
		con.loggedin(userId+"");
	}
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateorderinfor(int orderid,String assess, int score) {
		// TODO Auto-generated method stub
		
		userso.updateorderinfo(orderid,assess,score);
	}
	@Override
	public void cancelorder(int orderid) {
		// TODO Auto-generated method stub
		userso.cancelorder(orderid);
	}


}
