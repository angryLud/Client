package businesslogic;

import java.rmi.RemoteException;
import java.util.List;

import businesslogicservice.CreditService;
import po.UserPo;
import rmi.RemoteHelper;

public class CreditServiceImpl implements CreditService {
	
	private UserPo userPo;
	
	public CreditServiceImpl(){
		
	}
	
	public boolean recoverCredit(int id,int credit){
		try {
			userPo = RemoteHelper.getInstance().getUserdataservice().find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userPo.getId() == id){
			int creditBefore = userPo.getCredit();
			userPo.setCredit(creditBefore+credit);
			try {
				if(RemoteHelper.getInstance().getUserdataservice().update(userPo)){
					return true;
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
