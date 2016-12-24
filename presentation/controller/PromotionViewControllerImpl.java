package presentation.controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import businesslogic.PromotionServiceImpl;
import businesslogicservice.PromotionService;
import presentation.promotionui.Promotion;
import presentation.promotionui.PromotionController;
import presentation.promotionui.PromotionView;
import presentation.promotionui.PromotionViewControllerService;
import vo.PromotionVo;

public class PromotionViewControllerImpl implements PromotionViewControllerService {
	
	private PromotionService promotionService;
	
	private PromotionView view;

	private controller con;
	
	private JPanel view2;
	
	public PromotionViewControllerImpl(){
		promotionService = new PromotionServiceImpl();
	}
	
	public void setView(PromotionView view){
		this.view = view;
	}
	
//	public Date getDate(){
//		return date;
//	}
	
	/**
	 * @return 获取销售策略列表
	 */
	public List<PromotionVo> observeList(){
		return promotionService.find();
	}
	
	/**
	 * 打开制定新销售策略界面
	 */
	public void newStrategyButtonClicked(){
		view.newStrategyButtonClicked();
	}
	
	
	public void returnButtonClicked(){
		con.login();
		promotionService.logout(3);
		con.loggedin("3");
	}
	
	public void comeToUseButtonClicked(){
		view.comeToUseButtonClicked();
	}
	
	/**
	 * 输入日期按钮点击事件
	 */
//	public void inputDateButtonClicked(){
//		view.inputDateButtonClicked();
//	}

	@Override
	public void setcon(controller controller) {
		this.con=controller;
	}

}
