package presentation.controller;


import presentation.promotionui.ChangeOrderView;
import presentation.promotionui.ChangeOrderViewControllerService;
import presentation.promotionui.Promotion;
import presentation.promotionui.PromotionController;
import vo.OrderVo;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import businesslogic.ChangeOrderServiceImpl;
import businesslogicservice.ChangeOrderService;

public class ChangeOrderViewControllerImpl implements ChangeOrderViewControllerService {
	
	private ChangeOrderView view;
	
	private int hotelId;

	private controller con;
	
	private JPanel view2;
	
	private ChangeOrderService changeOrderService;
	
	public ChangeOrderViewControllerImpl(int hotelId){
		this.hotelId = hotelId;
		changeOrderService = new ChangeOrderServiceImpl(hotelId);
	}
	
	public void setView(ChangeOrderView view){
		this.view = view;
	}
	
	public int getHotelId(){
		return hotelId;
	}

	@Override
	public void setcon(controller controller) {
		this.con=controller;
	}

	public List<OrderVo> getAbnormalOrder(int hotelId){
		
		return changeOrderService.getAbnormalOrder(hotelId);
	}
	
	public void changeButtonClicked(){
		view.changeButtonClicked();
	}
	
	public void returnButtonClicked(){
		con.loggedin("3130");

	}

}
