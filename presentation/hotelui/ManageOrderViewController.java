package presentation.hotelui;

import java.util.List;

import presentation.controller.controller;
import vo.OrderVo;

public interface ManageOrderViewController {
	public void setcon(controller con);
	
	public void setView(ManageOrderView view);
	
	public void OrderBrowseButtonClicked();
	
	public void OrderSearchButtonClicked();
	
	public void ExecuteButtonClicked();
	
	public void ExitButtonClicked();
	
	public List<OrderVo> getAllOrders(int holelID);
	
	public OrderVo searchOrder(int orderID);
	
	public boolean executeOrder(int orderID);

}
