package businesslogic;

import businesslogicservice.ManageService;
import vo.UserVo;

import java.rmi.RemoteException;
import java.util.List;

import po.HotelPo;
import po.PromotionerPo;
import po.UserPo;
import rmi.RemoteHelper;

public class ManageServiceImpl implements ManageService {
	
	private UserVo userVo;
	
	private List<UserPo> userList;
	
	public int addUser(PromotionerPo pPo,String password){
		try {
			char[] pass = password.toCharArray();
			int id = RemoteHelper.getInstance().getPromotiondataservice().promotionerinsert(pPo,pass);
			if(id>2999){
				return id;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean changeUserInfo(int id,UserPo usPo){
		for(UserPo userPo :userList){
			if(userPo.getId() == id){
				userPo.setUserName(usPo.getUserName());
				userPo.setCompany(usPo.getCompany());
				userPo.setPhone(usPo.getPhone());
				userPo.setBirthday(usPo.getBirthday());
				try {
					if(RemoteHelper.getInstance().getUserdataservice().userupdate(userPo)){
						return true;
					}
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
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
	
	public void logout(int id) {

	}

}
