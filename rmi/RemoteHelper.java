package rmi;

import businesslogicservice.loginservice;
import dataservice.logindataservice;
import dataservice.orderdataservice;
import dataservice.promotiondataservice;
import dataservice.userdataservice;

import java.rmi.Remote;

/**
 * Created by huihantao on 2016/12/13.
 */
public class RemoteHelper {
    private Remote remote;
    private static RemoteHelper remoteHelper = new RemoteHelper();
    public static RemoteHelper getInstance(){
        return remoteHelper;
    }

    private RemoteHelper() {
    }

    public void setRemote(Remote remote){
        this.remote = remote;
    }

    public userdataservice getUserdataservice(){
        return (userdataservice)remote;
    }
    public orderdataservice getOrderdataservice(){
        return (orderdataservice)remote;
    }
    public promotiondataservice getPromotiondataservice(){
        return (promotiondataservice) remote;
    }
    public logindataservice getloginservice(){return (logindataservice) remote;}
}

