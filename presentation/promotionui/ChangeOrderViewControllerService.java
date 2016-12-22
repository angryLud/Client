package presentation.promotionui;

import presentation.controller.controller;
import vo.OrderVo;
import java.util.List;

public interface ChangeOrderViewControllerService {
	
	 void setView(ChangeOrderView view);
	 
	 List<OrderVo> getAbnormalOrder();
	 
	 void changeButtonClicked();
	 
	 void returnButtonClicked();
	 
	 int getHotelId();

    void setcon(controller controller);
}
