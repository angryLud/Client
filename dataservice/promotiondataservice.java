package dataservice;

import po.PromotionPo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 * Created by huihantao on 2016/12/10.
 */
public interface promotiondataservice extends Remote {
    List<PromotionPo> promotionfind() throws RemoteException;
    boolean promotioninsert(PromotionPo pormotionPo) throws RemoteException;
   
}
