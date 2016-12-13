package dataservice;

import po.PromotionPo;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 * Created by huihantao on 2016/12/10.
 */
public interface promotiondataservice {
    List<PromotionPo> find(Date date) throws RemoteException;
    boolean insert(PromotionPo pormotionPo) throws RemoteException;
    promotiondataservice getInstance() throws RemoteException;
}
