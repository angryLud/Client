package presentation.hotelui;

import java.rmi.RemoteException;
import java.util.List;

import po.OrderPo;
import presentation.controller.controller;
import vo.OrderVo;

public interface ManageOrderViewController {
	public void setcon(controller con);
	
	public void setView(ManageOrderView view);
	
	public void OrderSearchButtonClicked();
	
	public void ExecuteButtonClicked();
	
	public void ExitButtonClicked();
	
	public List<OrderVo> getAllOrders(int holelID);
	
	public List<OrderVo> getUnfinishedOrders(int hotelID);
	
	public List<OrderVo> getFinishedOrders(int hotelID);
	
	public List<OrderVo> getAbnormalOrders(int hotelID);
	
	public List<OrderVo> getcanceledOrders(int hotelID);
	
	public OrderPo searchOrder(int orderID);
	
	public boolean executeOrder(int orderID);
    
    public void CreditChange(int orderID,int userid,int credit) throws RemoteException;

	public void refresh();

	public void CreditRestore(int orderNo, int userid, int credit, long delaytime)throws RemoteException;


}
