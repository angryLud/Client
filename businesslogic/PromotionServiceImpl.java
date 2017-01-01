package businesslogic;

import java.rmi.RemoteException;
import java.util.List;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.PromotionService;
import businesslogicservice.loginservice;
import dataservice.promotiondataservice;
import vo.PromotionVo;
import po.HotelPo;
import po.OrderPo;
import po.PromotionPo;
import rmi.RemoteHelper;

public class PromotionServiceImpl implements PromotionService {
	
	private List<PromotionPo> promotionList;
	
	private List<HotelPo> hotelList;
	private loginservice logs;
	
	public PromotionServiceImpl(){
		promotionList = new ArrayList<PromotionPo>();
<<<<<<< HEAD
//		try {
//			promotionList = RemoteHelper.getInstance().getPromotiondataservice().find();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		logs=new login();
=======
		try {
			promotionList = RemoteHelper.getInstance().getPromotiondataservice().promotionfind();
			hotelList = RemoteHelper.getInstance().getHoteldataservice().getallhotellist();
//			System.out.print(promotionList==null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
>>>>>>> c91914d3a6cfe1b81295c0f02cebc1316f7d116d
	}
	
	
	public boolean insert(PromotionPo promotionPo){
		try {
			int id = RemoteHelper.getInstance().getPromotiondataservice().promotioninsert(promotionPo);
			if(id>999){
				return true;
			}

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		

	}
	

	
	public List<PromotionVo> find(){
		List<PromotionVo> list = new ArrayList<PromotionVo>();
		for(PromotionPo promotionPo : promotionList){
			PromotionVo promotionVo = new PromotionVo(promotionPo);
			list.add(promotionVo);
//			try {
//				Date dateBegin = sdf.parse(promotionVo.getBeginTime());
//				if(date.getTime()<=dateBegin.getTime()){
//					list.add(promotionVo);
//				}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
		}
		return list;
	}
	
	public boolean updateOrder(String place,double discount){
		for(HotelPo hotelPo : hotelList){
			if(( place).equals(hotelPo.getAddress()+"_"+hotelPo.getPosition())){
				int id = hotelPo.getHotelID();
				List<OrderPo> list = new ArrayList<OrderPo>();
				try {
					list = RemoteHelper.getInstance().getOrderdataservice().findorderbyhotelid(id);
					for(OrderPo orderPo:list){
						int value = orderPo.getValue();
						value = (int)(value * discount);
						orderPo.setValue(value);
						if(RemoteHelper.getInstance().getOrderdataservice().orderupdate(orderPo)){						
						}else{
							return false;
						}
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return true;
	}

	@Override
	public void logout(int id) {

		try {
            RemoteHelper.getInstance().getloginservice().logout(id);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

	}

	@Override
	public String getname() {
		return "a";
	}


}
