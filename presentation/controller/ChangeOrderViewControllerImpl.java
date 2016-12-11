package presentation.controller;


import presentation.promotionui.ChangeOrderView;
import presentation.promotionui.ChangeOrderViewControllerService;
import vo.OrderVo;

import java.util.List;

public class ChangeOrderViewControllerImpl implements ChangeOrderViewControllerService {
	
	private ChangeOrderView view;
	
	public ChangeOrderViewControllerImpl(){
		
	}
	
	public void setView(ChangeOrderView view){
		this.view = view;
	}
	
	public List<OrderVo> getAbnormalOrder(){
		return null;
//		return changeOrderService.getAbnormalOrder();
	}

}
