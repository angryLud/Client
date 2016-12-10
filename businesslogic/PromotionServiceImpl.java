package businesslogic;

import java.util.List;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.PromotionService;
import dataservice.promotiondataservice;
import vo.PromotionVo;
import po.PromotionPo;

public class PromotionServiceImpl implements PromotionService {
	
	private List<PromotionPo> promotionList;
	
	private  Date date;
	
	private promotiondataservice promotionDao;
	
	public PromotionServiceImpl(Date date){
		this.date = date;
		promotionList = promotionDao.find(date);
	}
	
	
	public boolean insert(PromotionPo promotionPo){
		return promotionDao.insert(promotionPo);
		
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