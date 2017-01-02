package presentation.promotionui;

import java.util.List;
import java.util.Date;

import presentation.controller.controller;
import vo.PromotionVo;



public interface PromotionViewControllerService {
	
	public void setView(PromotionView view);
	
//	public Date getDate();
	
	public List<PromotionVo> observeList();
	
	public void newStrategyButtonClicked();
	
	public void returnButtonClicked();
	
	void comeToUseButtonClicked();
	
//	public void inputDateButtonClicked();

    void setcon(controller controller);
    String getid();
    
}
