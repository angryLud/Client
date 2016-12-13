package businesslogic;

import java.util.List;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.PromotionService;
import dataservice.promotiondataservice;
import vo.PromotionVo;
import po.PromotionPo;
import rmi.RemoteHelper;

public class PromotionServiceImpl implements PromotionService {
	
	private List<PromotionPo> promotionList;
	
	private  Date date;
	
	public PromotionServiceImpl(Date date){
		this.date = date;
//		promotionDao = promotiondataservice.getInstance();
<<<<<<< HEAD
		try {
			promotionList = promotionDao.find(date);
=======

//		promotionList = promotionDao.find(date);
		try {
			RemoteHelper.getInstance().getPromotiondataservice().find(date);

>>>>>>> 10804504500365b51d2bf687df86cab595ef2fdd
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean insert(PromotionPo promotionPo){
		try {
<<<<<<< HEAD
			return promotionDao.insert(promotionPo);
=======

			if(RemoteHelper.getInstance().getPromotiondataservice().insert(promotionPo)){
				return true;
			}

>>>>>>> 10804504500365b51d2bf687df86cab595ef2fdd
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	

	
	public List<PromotionVo> find(Date date){
		List<PromotionVo> list = new ArrayList<PromotionVo>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		for(PromotionPo promotionPo : promotionList){
			PromotionVo promotionVo = new PromotionVo(promotionPo);
			try {
				Date dateBegin = sdf.parse(promotionVo.getBeginTime());
				if(date.getTime()<=dateBegin.getTime()){
					list.add(promotionVo);
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return list;
	}
	
	
}