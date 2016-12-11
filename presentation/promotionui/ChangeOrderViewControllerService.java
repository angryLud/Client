package presentation.promotionui;

import vo.OrderVo;
import java.util.List;

public interface ChangeOrderViewControllerService {
	
	 void setView(ChangeOrderView view);
	 
	 List<OrderVo> getAbnormalOrder();

}
