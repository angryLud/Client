package businesslogicservice;

import java.util.List;
import java.util.Date;

import vo.PromotionVo;
import po.PromotionPo;

public interface PromotionService {
	
	/**
	* @param promotionPo
	* @return	增加销售策略
	*/
	public boolean insert(PromotionPo promotionPo);

	/**
	* @param date
	* @return	查看销售策略列表
	*/
	public List<PromotionVo> find(Date date);
}
