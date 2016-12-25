package dataservice;

import po.PromotionPo;
import po.PromotionerPo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by huihantao on 2016/12/10.
 */
public interface promotiondataservice extends Remote {
    int promotionerinsert(PromotionerPo ppo, char[] password) throws RemoteException;

    boolean promotionerupdate(PromotionerPo ppo) throws RemoteException;

    PromotionerPo promotionerfind(int id) throws RemoteException;

    List<PromotionPo> promotionfind() throws RemoteException;

    int promotioninsert(PromotionPo pormotionPo) throws RemoteException;
   
}
