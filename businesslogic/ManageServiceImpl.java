package businesslogic;

import businesslogicservice.ManageService;
import vo.HotelVo;
import vo.PromotionerVo;
import vo.UserVo;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.HotelPo;
import po.PromotionerPo;
import po.UserPo;
import rmi.RemoteHelper;

public class ManageServiceImpl implements ManageService {
	
	private UserVo userVo;
	
	private PromotionerVo pvo;
	
	private HotelPo hotelPo;
	
	private List<UserPo> userList;
	
	public int addUser(PromotionerPo pPo,String password){
		try {
			char[] pass = password.toCharArray();
			int id = RemoteHelper.getInstance().getPromotiondataservice().promotionerinsert(pPo,pass);
			if(id>3999){
				return id;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean changeUserInfo(UserPo usPo){
		try {
			if(RemoteHelper.getInstance().getUserdataservice().userupdate(usPo)){
				return true;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int addHotel(HotelPo hotelPo,String password){
		try {
			char[] pass = password.toCharArray();
			int id = RemoteHelper.getInstance().getHoteldataservice().hotelinsert(hotelPo,pass);
			if(id>1999){
				return id;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public UserVo uploadUser(int id){
		try {
			UserPo userPo = RemoteHelper.getInstance().getUserdataservice().userfind(id);
			userVo = new UserVo(userPo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userVo;
	}
	
	public HotelPo uploadHotel(int id){
		try {
			hotelPo = RemoteHelper.getInstance().getHoteldataservice().findhotelbyid(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hotelPo;
	}
	
	public boolean changeHotelInfo(HotelPo hPo){
		try {
			if(RemoteHelper.getInstance().getHoteldataservice().hotelupdate(hPo)){
				return true;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public PromotionerVo uploadPromotioner(int id){
		try {
			PromotionerPo ppo = RemoteHelper.getInstance().getPromotiondataservice().promotionerfind(id);
			pvo = new PromotionerVo(ppo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pvo;
	}
	
	public boolean changePromotionerInfo(PromotionerPo ppo){
		try {
			if(RemoteHelper.getInstance().getPromotiondataservice().promotionerupdate(ppo)){
					return true;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return false;
	}
	
	public void logout(int id) {

	}

}
