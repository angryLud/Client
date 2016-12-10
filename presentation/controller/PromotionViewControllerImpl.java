package presentation.controller;

import java.util.List;
import java.util.Date;

import businesslogic.PromotionServiceImpl;
import businesslogicservice.PromotionService;
import presentation.promotionui.PromotionView;
import presentation.promotionui.PromotionViewControllerService;
import vo.PromotionVo;

public class PromotionViewControllerImpl implements PromotionViewControllerService {
	
	private Date date;
	
	private PromotionService promotionService;
	
	private PromotionView view;
	
	public PromotionViewControllerImpl(Date date){
		this.date = date;
		promotionService = new PromotionServiceImpl(date);
	}
	
	public void setView(PromotionView view){
		this.view = view;
	}
	
	public Date getDate(){
		return date;
	}
	
	/**
	 * @return 获取销售策略列表
	 */
	public List<PromotionVo> observeList(Date date){
		return promotionService.find(date);
	}
	
	/**
	 * 打开制定新销售策略界面
	 */
	public void newStrategyButtonClicked(){
		view.newStrategyButtonClicked();
	}
	
	/**
	 * 删除销售策略按钮点击事件
	 */
	public void deleteStrategyButtonClicked(){
		view.deleteStrategyButtonClicked();
	}
	
	/**
	 * 输入日期按钮点击事件
	 */
	public void inputDateButtonClicked(){
		view.inputDateButtonClicked();
	}

}
